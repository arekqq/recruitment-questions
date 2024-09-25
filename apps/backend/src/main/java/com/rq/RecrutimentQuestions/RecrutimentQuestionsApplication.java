package com.rq.RecrutimentQuestions;

import com.rq.RecrutimentQuestions.dto.Advancement;
import com.rq.RecrutimentQuestions.dto.Category;
import com.rq.RecrutimentQuestions.dto.QuestionResponse;
import com.rq.RecrutimentQuestions.external.QuestionsFileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class RecrutimentQuestionsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RecrutimentQuestionsApplication.class, args);
		List<QuestionResponse> questions = run.getBean(QuestionsFileReader.class).getQuestions();
		Map<Category, List<QuestionResponse>> categories = questions.stream().collect(Collectors.groupingBy(QuestionResponse::category));
		Map<Advancement, List<QuestionResponse>> advancements = questions.stream().collect(Collectors.groupingBy(QuestionResponse::advancement));
		System.out.println(questions);

	}

}
