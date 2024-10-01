package com.recruitment_questions.dto;

import java.util.List;

public record QuestionExternalResponse(
        long id,
        Advancement advancement,
        Category category,
        String text,
        List<AnswerExternalResponse> answers,
        String code
) {
}
