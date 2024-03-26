package com.example.demo.coursework2.service;

import org.springframework.stereotype.Service;
import com.example.demo.coursework2.exception.QuestionIsAlreadyCreatedException;
import com.example.demo.coursework2.exception.QuestionNotFoundException;
import com.example.demo.coursework2.service.QuestionService;
import com.example.demo.coursework2.service.Question;

import java.util.*;


@Service
public class JavaQuestionServiceImpl implements QuestionService {


    private final Set<Question> questions;

    public JavaQuestionServiceImpl(Set<Question> questions) {

        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)) {
            throw new QuestionIsAlreadyCreatedException("Такой вопрос уже существует");
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionIsAlreadyCreatedException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {

            questions.remove(question1);
            return question1;

        }
        throw new QuestionNotFoundException("Такой вопрос не найден");
    }


    @Override
    public Set<Question> getAll() {
        Set<Question> questionSet = new HashSet<>(questions);
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int random = r.nextInt(questions.size());
        List<Question> list = new ArrayList<>(questions);
        return list.get(random);

    }
}

