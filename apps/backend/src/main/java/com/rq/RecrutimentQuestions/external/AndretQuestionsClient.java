package com.rq.RecrutimentQuestions.external;

import com.rq.RecrutimentQuestions.dto.QuestionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class AndretQuestionsClient implements QuestionsReader {

    private final RestClient questionsClient;

    @Override
    public List<QuestionResponse> getQuestions() {
        return questionsClient.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
