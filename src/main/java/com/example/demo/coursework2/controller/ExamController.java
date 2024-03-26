package com.example.demo.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.coursework2.service.ExaminerService;
import com.example.demo.coursework2.service.Question;

import java.util.Collection;

@RestController

public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/exam/get/{amount}")
    public Collection<Question> getAllQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(amount);
    }
}





