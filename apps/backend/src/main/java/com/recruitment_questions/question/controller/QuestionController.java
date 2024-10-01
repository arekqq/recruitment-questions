package com.recruitment_questions.question.controller;

import com.recruitment_questions.dto.QuestionResponse;
import com.recruitment_questions.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionResponse> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public QuestionResponse getOne(@PathVariable Long id) {
        return questionService.getOne(id);
    }
}
