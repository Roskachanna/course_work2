package roskach.anna.course_work2.service.impl;

import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory;
import roskach.anna.course_work2.service.QuestionService;

import java.util.Collection;

public class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();
    @Test
    public void shouldAddNewQuestion(){
        //given
        Question question = new Question("question", "answer");

        //when
        Question addedQuestion = questionService.add(question);

        //then
        Assertions.assertEquals(question, addedQuestion);
    }
    @Test
    public void shouldReturnNewExistedQuestion() {
        //given
        Question question = new Question("question", "answer");

        //when
        Collection<Question> all = questionService.getAll();

        //then
        Assertions.assertEquals(all.size(), 1);


    }
}
