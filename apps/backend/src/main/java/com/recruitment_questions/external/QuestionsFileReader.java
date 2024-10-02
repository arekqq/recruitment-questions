package com.recruitment_questions.external;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitment_questions.question.domain.Question;
import com.recruitment_questions.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionsFileReader {

    private final QuestionRepository questionRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void insertIntoDb() {

        File file = new File("questions.json");
        if (!file.exists()) {
            return;
        }

        JsonFactory jsonFactory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper();
        try (JsonParser jsonParser = jsonFactory.createParser(file)) {
            // Ensure we are at the start of an array
            if (jsonParser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected start of array");
            }

            // Read each object from the array
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                // Deserialize each object into a Question record
                Question question = objectMapper.readValue(jsonParser, Question.class);
                question.getAnswers().forEach(a -> a.setQuestion(question));
                questionRepository.save(question);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
