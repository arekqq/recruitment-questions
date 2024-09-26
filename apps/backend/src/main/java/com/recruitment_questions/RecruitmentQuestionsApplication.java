package com.recruitment_questions;

import com.recruitment_questions.dto.Advancement;
import com.recruitment_questions.dto.Category;
import com.recruitment_questions.dto.QuestionResponse;
import com.recruitment_questions.external.QuestionsFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class RecruitmentQuestionsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RecruitmentQuestionsApplication.class, args);
		List<QuestionResponse> questions = run.getBean(QuestionsFileReader.class).getQuestions();
		Map<Category, List<QuestionResponse>> categories = questions.stream().collect(Collectors.groupingBy(QuestionResponse::category));
		log.info(categories.toString());
		Map<Advancement, List<QuestionResponse>> advancements = questions.stream().collect(Collectors.groupingBy(QuestionResponse::advancement));
		log.info(advancements.toString());
		log.info(questions.toString());


	}

}
