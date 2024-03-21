package com.example.demo.coursework2.service;

import com.example.demo.coursework2.service.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
