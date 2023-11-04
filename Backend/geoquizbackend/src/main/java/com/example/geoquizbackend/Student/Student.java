package com.example.geoquizbackend.Student;

import com.example.geoquizbackend.Professor.Professor;
import com.example.geoquizbackend.Quiz.Quiz;
import jakarta.persistence.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String firstName;
    String lastName;
    String email;
    String password;
    private String classCode;
    float grade;
    @OneToMany
    Set<Quiz> q;
    @ManyToOne
    @JoinColumn(name="professor_id")
    Professor professor;
    public Student() {

    }
    public long getId() { return id; }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String name) { this.lastName = name; }

    public void getPassword() { this.password = password; }
    public void setPassword(String password) {
        this.password = password;
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        this.password = encoder.encode(password);
    }
//    public boolean checkPassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.matches(password, this.password);
//    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    public void setClassCode(String classCode) { this.classCode = classCode; }
    public String getClassCode() { return this.classCode; }
}
