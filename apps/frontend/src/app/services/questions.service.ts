import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Question {
  id: number;
  advancement: string;
  category: string;
  text: string;
  answers: {
    text: string;
    correct: boolean;
    explanation: string;
  }[];
}

@Injectable({
  providedIn: 'https://public.andret.eu/questions.json',
})
export class QuestionsService {
  private apiUrl = '$QUESTIONS_URL';

  constructor(private http: HttpClient) {}

  getQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(this.apiUrl);
  }
}
