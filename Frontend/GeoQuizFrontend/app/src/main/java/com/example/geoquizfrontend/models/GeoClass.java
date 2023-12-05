package com.example.geoquizfrontend.models;

import com.example.geoquizfrontend.models.Professor;
import com.example.geoquizfrontend.models.Student;

import java.util.Set;

public class GeoClass {
    private long id;
    private String name;
    private Professor professor;
    private Set<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
