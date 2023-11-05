package com.example.geoquizbackend.Class;

import com.example.geoquizbackend.Professor.Professor;
import com.example.geoquizbackend.Student.Student;
import jakarta.persistence.*;

public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne
    Professor professor;
    @ManyToMany
    Student student;
}
