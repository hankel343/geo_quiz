package com.example.geoquizbackend.Student;

import com.example.geoquizbackend.GeoClass.GeoClass;
import com.example.geoquizbackend.Professor.Professor;
import com.example.geoquizbackend.Quiz.Quiz;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Entity
@Schema(description = "Student entity")
public class Student {

    @Id
    @Schema(description = "Unique identifier for the student", example = "1")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Schema(description = "First name of the student", example = "John")
    String firstName;
    @Schema(description = "Last name of the student", example = "Doe")
    String lastName;
    @Schema(description = "Email of the student", example = "john.doe@example.com")
    String email;
    @Schema(description = "Password of the student", example = "password123")
    String password;
    @Schema(description = "Class code of the student", example = "CS101")
    private String classCode;
    @Schema(description = "Grade of the student", example = "90.5")
    float grade;
    @OneToMany
    @Schema(description = "Set of quizzes taken by the student")
    Set<Quiz> q;
    @ManyToOne
    @JoinColumn(name="class_id")
    @Schema(description = "GeoClass associated with the student")
    GeoClass geoClass;
    @ManyToOne
    @JoinColumn(name="professor_id")
    @Schema(description = "Professor associated with the student")
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
