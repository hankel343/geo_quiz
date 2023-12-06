package com.example.geoquizfrontend;

import static org.junit.Assert.assertEquals;

import com.example.geoquizfrontend.models.Professor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProfessorTest {

    private Professor professor;

    @Before
    public void setup() {
        professor = new Professor();
        professor.setId(1);
        professor.setFirstName("John");
        professor.setLastName("Doe");
        professor.setEmail("john.doe@example.com");
        professor.setPassword("password");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", professor.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", professor.getLastName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", professor.getEmail());
    }

    @Test
    public void testGetId() {
        assertEquals(1, professor.getId());
    }
}

