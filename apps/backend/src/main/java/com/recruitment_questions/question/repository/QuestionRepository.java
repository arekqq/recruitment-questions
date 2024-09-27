package com.recruitment_questions.question.repository;

import com.recruitment_questions.question.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
