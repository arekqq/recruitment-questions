package com.recruitment_questions.external;

import com.recruitment_questions.dto.QuestionResponse;

import java.util.List;

public interface QuestionsReader {

    List<QuestionResponse> getQuestions();

    // TODO add reader strategy and return question from json if DB is down
}
