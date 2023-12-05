package com.example.geoquizfrontend.models;

import com.example.geoquizfrontend.models.GeoClass;
import com.example.geoquizfrontend.models.Professor;
import com.example.geoquizfrontend.models.Quiz;

import java.util.Set;

public class Student extends User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String classCode;
    private float grade;
    private GeoClass geoClass;
    private Professor professor;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public GeoClass getGeoClass() {
        return geoClass;
    }

    public void setGeoClass(GeoClass geoClass) {
        this.geoClass = geoClass;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
