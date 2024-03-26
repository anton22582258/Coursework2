package com.example.demo.coursework2;

import com.example.demo.coursework2.service.Question;
import org.junit.jupiter.api.Test;
import com.example.demo.coursework2.exception.QuestionIsAlreadyCreatedException;
import com.example.demo.coursework2.exception.QuestionNotFoundException;
import com.example.demo.coursework2.service.JavaQuestionServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceImplTest {
    Set<Question> testSet = new HashSet<>();
    JavaQuestionServiceImpl out = new JavaQuestionServiceImpl(testSet);

    Question one = new Question("What is your name?", "Anton");
    Question two = new Question("What is your surname?", "Volobuev");
    Question three = new Question("How old are you?", "56");
    Question four = new Question("Where are you from?", "i'm from Russia");
    Set<Question> all = new HashSet<>(Set.of(one, two, three, four));


    @Test
    void addNewQuestion() {
        Question result = out.add("What is your name?", "Anton");
        assertEquals(result, one);
    }

    @Test
    void addWhenQuestionCreated() {
        Question result = out.add("What is your name?", "Anton");
        assertThrows(QuestionIsAlreadyCreatedException.class, () -> out.add(result));
    }

    @Test
    void removeQuestion() {
        out.add("How are you?", "i'm fine");
        out.remove("How are you?", "i'm fine");
        assertEquals(0, out.getAll().size());
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove("How are you?", "i'm fine"));
    }

    @Test
    void getAllTest() {
        out.add(one);
        out.add(two);
        out.add(three);
        out.add(four);
        Set<Question> result = out.getAll();
        assertEquals(result, all);
    }
}

