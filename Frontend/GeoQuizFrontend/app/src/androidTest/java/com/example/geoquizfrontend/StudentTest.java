package com.example.geoquizfrontend;

import static org.junit.Assert.assertEquals;

import com.example.geoquizfrontend.models.Student;
import com.example.geoquizfrontend.models.UserType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StudentTest {

    private Student student;

    @Before
    public void setup() {
        student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setPassword("password");
        student.setClassCode("CS101");
        student.setGrade(90.0f);
        student.setUserType(UserType.STUDENT);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", student.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", student.getLastName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", student.getEmail());
    }
}
