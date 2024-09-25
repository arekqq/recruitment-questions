package com.rq.RecrutimentQuestions.dto;

import java.util.List;

public record QuestionResponse (
        long id,
        Advancement advancement, // TODO enum
        Category category, // TODO enum
        String text,
        List<AnswerResponse> answers,
        String code
) {
}
