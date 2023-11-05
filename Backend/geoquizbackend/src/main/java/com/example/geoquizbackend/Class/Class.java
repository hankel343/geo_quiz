package com.example.geoquizbackend.Class;

import com.example.geoquizbackend.Professor.Professor;
import com.example.geoquizbackend.Student.Student;
import jakarta.persistence.*;

import java.util.Set;

public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne
    @JoinColumn(name="professsor_id")
    Professor professor;
    @OneToMany(mappedBy = "class")
    Set<Student> student;
}
