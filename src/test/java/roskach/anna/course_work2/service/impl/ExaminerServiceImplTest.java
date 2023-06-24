package roskach.anna.course_work2.service.impl;

import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import roskach.anna.course_work2.service.ExaminerService;
import roskach.anna.course_work2.service.QuestionService;

import java.util.*;


import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService  questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldCollectRandomQuestions() {
        //given
        int amount = 3;

        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Массив - это ссылочный тип данных", "Ссылочный"));
        questions.add(new Question("Как называестя тип данных для хранения символов", "char / Character"));
        questions.add(new Question("Сколько возможных значений у boolean ", "true / false"));
        questions.add(new Question("Какая сложность у алгоритма бинарного поиска", "0(log2N"));
        questions.add(new Question("Какие типы исключений бывают", "Проверяемые / Непроверяемые"));
        List<Question> questionList = new ArrayList<>(questions);

        given(questionService.getAll()).willReturn(questions);
        given(questionService.getRandomQuestion()).willReturn(
                questionList.get(0),
                questionList.get(0),
                questionList.get(0),
                questionList.get(1),
                questionList.get(1),
                questionList.get(2),
                questionList.get(2)
        );

        //when
        Collection<Question> actualRandomQuestions = examinerService.getQuestions(amount);
        Assertions.assertEquals(new HashSet<>(List.of(questionList.get(0), questionList.get(1), questionList.get(2))), actualRandomQuestions);
    }
}
