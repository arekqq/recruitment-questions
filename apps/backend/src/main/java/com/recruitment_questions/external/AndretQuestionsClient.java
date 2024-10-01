package com.recruitment_questions.external;

import com.recruitment_questions.dto.QuestionExternalResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class AndretQuestionsClient {

    private final RestClient questionsClient;

    public List<QuestionExternalResponse> getQuestions() {
        return questionsClient.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
