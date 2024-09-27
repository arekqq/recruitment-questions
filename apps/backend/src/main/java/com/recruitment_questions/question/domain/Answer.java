package com.recruitment_questions.question.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Answer {

    @Column(columnDefinition = "TEXT")
    private String text;

    private boolean correct;

    @Column(columnDefinition = "TEXT")
    private String explanation;
}
