package com.example.geoquizbackend.Student;

import com.example.geoquizbackend.GeoClass.GeoClass;
import com.example.geoquizbackend.Professor.Professor;
import com.example.geoquizbackend.Quiz.Quiz;
import com.example.geoquizbackend.User.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Schema(description = "Student entity")
public class Student extends User {

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
    @ManyToOne
    @JoinColumn(name="class_id")
    @Schema(description = "GeoClass associated with the student")
    GeoClass geoClass;
    @ManyToOne
    @JoinColumn(name="professor_id")
    @Schema(description = "Professor associated with the student")
    Professor professor;

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
