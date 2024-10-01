package com.recruitment_questions.dto;

public record AnswerExternalResponse(
        String text,
        boolean correct,
        String explanation
) {
}
