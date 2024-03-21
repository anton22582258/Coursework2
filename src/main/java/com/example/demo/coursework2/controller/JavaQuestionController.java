package com.example.demo.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.coursework2.service.Question;
import com.example.demo.coursework2.service.JavaQuestionServiceImpl;

import java.util.Collection;


@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return javaQuestionService.remove(question, answer);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }
}

