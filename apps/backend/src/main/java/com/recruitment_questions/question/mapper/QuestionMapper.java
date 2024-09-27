package com.recruitment_questions.question.mapper;

import com.recruitment_questions.dto.QuestionResponse;
import com.recruitment_questions.question.domain.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question toEntity(QuestionResponse questionResponse);

}
