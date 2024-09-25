package com.rq.RecrutimentQuestions.dto;

public record AnswerResponse(
        String text,
        boolean correct,
        String explanation
) {
}
