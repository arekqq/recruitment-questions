package com.recruitment_questions.dto;

public record AnswerResponse(
        String text,
        boolean correct,
        String explanation
) {
}
