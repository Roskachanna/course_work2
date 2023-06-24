package controller;

import model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import roskach.anna.course_work2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question add(
            @RequestParam String questionText, @RequestParam String answer) {
            return questionService.add(questionText, answer);
    }
    @GetMapping("/remove")
    public Question remove(
            @RequestParam String questionText, @RequestParam String answer) {
        return questionService.remove(new Question(questionText, answer));
    }

}
