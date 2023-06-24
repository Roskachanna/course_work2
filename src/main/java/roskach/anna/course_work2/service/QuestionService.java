package roskach.anna.course_work2.service;

import model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String questionText, String answer);
    Question add(Question question);

    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
