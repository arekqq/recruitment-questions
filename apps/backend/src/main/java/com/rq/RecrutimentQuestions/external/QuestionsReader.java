package com.rq.RecrutimentQuestions.external;

import com.rq.RecrutimentQuestions.dto.QuestionResponse;

import java.util.List;

public interface QuestionsReader {

    List<QuestionResponse> getQuestions();

    // TODO add reader strategy and return question from json if DB is down
}
