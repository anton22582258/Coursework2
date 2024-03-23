package com.example.demo.coursework2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import com.example.demo.coursework2.exception.CollectionFullException;
import com.example.demo.coursework2.service.ExaminerService;
import com.example.demo.coursework2.service.QuestionService;
import com.example.demo.coursework2.service.Question;

import java.util.HashSet;
import java.util.Set;

@SessionScope

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> setRandom = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new CollectionFullException();
        }
        while (setRandom.size() < amount) {
            setRandom.add(questionService.getRandomQuestion());

        }
        return setRandom;
    }
 /*   @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectAmountOfQuestionException("В списке нет столько вопросов");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }*/
}


