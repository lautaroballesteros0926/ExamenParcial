package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    @Test
    public void testUserAnswerValidation() {
        Question question = new Question("¿Cuál es la capital de Francia?",
                new String[]{"Madrid", "Londres", "París", "Berlín"},
                3);
        Quiz quiz = new Quiz(new Question[]{question});

        assertEquals(3, quiz.getUserAnswer("3"));
        assertEquals(4, quiz.getUserAnswer("4"));
        assertEquals(1, quiz.getUserAnswer("1"));
        assertEquals(2, quiz.getUserAnswer("2"));
    }

    @Test
    public void testUserAnswerValidationWithInvalidInput() {
        Question question = new Question("¿Cuál es la capital de Francia?",
                new String[]{"Madrid", "Londres", "París", "Berlín"},
                3);
        Quiz quiz = new Quiz(new Question[]{question});

        assertEquals(0, quiz.getUserAnswer("a"));
        assertEquals(0, quiz.getUserAnswer("5"));
        assertEquals(0, quiz.getUserAnswer("0"));
        assertEquals(0, quiz.getUserAnswer("-1"));
    }

}
