package com.example.geoquizbackend.Student;

import com.example.geoquizbackend.Quiz.Quiz;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    String email;

    @OneToMany
    Set<Quiz> q;

    int[] classCodes;
    float grade;
    public Student() {

    }
}
