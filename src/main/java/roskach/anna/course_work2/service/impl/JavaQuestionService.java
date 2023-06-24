package roskach.anna.course_work2.service.impl;

import model.Question;
import org.springframework.stereotype.Service;
import roskach.anna.course_work2.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();
    @Override
    public Question add(String questionText, String answer) {
        Question question = new Question(questionText, answer);
        return add(new Question(questionText, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions );
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return (new ArrayList<>(questions)).get(randomIndex);
    }
}
