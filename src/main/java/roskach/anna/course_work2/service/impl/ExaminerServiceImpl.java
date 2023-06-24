package roskach.anna.course_work2.service.impl;

import model.Question;
import org.springframework.stereotype.Service;
import roskach.anna.course_work2.exception.NotEnoughQuestionInStorageException;
import roskach.anna.course_work2.service.ExaminerService;
import roskach.anna.course_work2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionInStorageException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
           Question randomQuestion = questionService.getRandomQuestion();
           questions.add(randomQuestion);
        }

        return questions;
    }
}
