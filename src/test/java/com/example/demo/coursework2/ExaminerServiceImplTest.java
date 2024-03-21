package com.example.demo.coursework2;

import com.example.demo.coursework2.service.ExaminerService;
import com.example.demo.coursework2.service.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.coursework2.service.QuestionService;
import com.example.demo.coursework2.service.ExaminerServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService mockQuestionService;

    @InjectMocks
    ExaminerServiceImpl out;
    Question one = new Question("What is your name?", "Anton");
    Question two = new Question("What is your surname?", "Volobuev");
    Question three = new Question("How old are you?", "56");
    Question four = new Question("Where are you from?", "i'm from Russia");
    Set<Question> all = new HashSet<>(Set.of(one, two, three, four));


    @Test
    void getSizeRandomQuestions() {

        when(mockQuestionService.getAll())
                .thenReturn(all);
        when(mockQuestionService.getRandomQuestion())
                .thenReturn(one, two, three, four);

        assertEquals(4, out.getQuestions(3).size());
    }
}

