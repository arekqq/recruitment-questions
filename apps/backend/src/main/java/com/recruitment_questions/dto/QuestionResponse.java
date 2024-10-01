package com.recruitment_questions.dto;

import java.util.List;

public record QuestionResponse(
        long id,
        Advancement advancement,
        Category category,
        String text,
        List<AnswerResponse> answers,
        String code
) implements BaseJsonResponse {
}
