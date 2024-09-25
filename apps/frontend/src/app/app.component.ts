import { Component, OnInit } from '@angular/core';
import { QuestionsService, Question } from './services/questions.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  questions: Question[] = [];

  constructor(private questionsService: QuestionsService) {}

  ngOnInit() {
    this.questionsService.getQuestions().subscribe((data) => {
      this.questions = data;
    });
  }
}
