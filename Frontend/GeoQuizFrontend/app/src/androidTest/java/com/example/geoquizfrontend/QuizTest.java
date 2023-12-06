package com.example.geoquizfrontend;

import static org.junit.Assert.assertEquals;

import com.example.geoquizfrontend.models.Quiz;
import com.example.geoquizfrontend.models.QuizType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QuizTest {

    private Quiz quiz;

    @Before
    public void setup() {
        quiz = new Quiz();
        quiz.setId(1);
        quiz.setScore(90);
        quiz.setDuration(30.0);
        quiz.setType(QuizType.FLAG);
    }

    @Test
    public void testGetId() {
        assertEquals(1, quiz.getId());
    }

    @Test
    public void testGetScore() {
        assertEquals(90, quiz.getScore());
    }

    @Test
    public void testGetDuration() {
        assertEquals(30.0, quiz.getDuration(), 0.001);
    }

    @Test
    public void testGetType() {
        assertEquals(QuizType.FLAG, quiz.getType());
    }
}
