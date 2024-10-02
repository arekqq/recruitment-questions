package com.recruitment_questions.question.repository;

import com.recruitment_questions.question.domain.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
