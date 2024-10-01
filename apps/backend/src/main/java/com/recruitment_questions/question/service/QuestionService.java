package com.recruitment_questions.question.service;

import com.recruitment_questions.dto.QuestionResponse;
import com.recruitment_questions.question.domain.Question;
import com.recruitment_questions.question.mapper.QuestionMapper;
import com.recruitment_questions.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionResponse> getAll() {
        Iterable<Question> all = questionRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .map(QuestionMapper.INSTANCE::toResponse)
                .toList();
    }

    public QuestionResponse getOne(long id) {
        return questionRepository.findById(id)
                .map(QuestionMapper.INSTANCE::toResponse)
                .orElseThrow();
    }
}
