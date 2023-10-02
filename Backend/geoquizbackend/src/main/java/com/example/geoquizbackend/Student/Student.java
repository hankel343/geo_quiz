package com.example.geoquizbackend.Student;

import com.example.geoquizbackend.Quiz.Quiz;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    String email;
    int[] classCodes;
    float grade;
    public Student() {

    }
}
