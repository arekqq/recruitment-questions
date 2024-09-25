package com.rq.RecrutimentQuestions.config.web.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClient;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class RestClientConfig {

    @Value("${andret.questionsUrl}")
    public String andretQuestionsUrl;

    @Bean
    public RestClient tasksClient() {
        return RestClient.builder()
                .baseUrl(andretQuestionsUrl)
                .defaultStatusHandler(new DefaultResponseErrorHandler())
                .build();
    }
}