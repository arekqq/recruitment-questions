package com.rq.RecrutimentQuestions.external;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rq.RecrutimentQuestions.dto.QuestionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
public class QuestionsFileReader implements QuestionsReader {

    @Override
    public List<QuestionResponse> getQuestions() {

        JsonFactory jsonFactory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper();
        List<QuestionResponse> questions = new LinkedList<>();

        File file = new File("questions.json");
        if (!file.exists()) {
            throw new IllegalStateException("File with questions doesn't exist");
        }
        try (JsonParser jsonParser = jsonFactory.createParser(file)) {
            // Ensure we are at the start of an array
            if (jsonParser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected start of array");
            }

            // Read each object from the array
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                // Deserialize each object into a Question record
                QuestionResponse question = objectMapper.readValue(jsonParser, QuestionResponse.class);
                questions.add(question);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return questions;
    }
}
