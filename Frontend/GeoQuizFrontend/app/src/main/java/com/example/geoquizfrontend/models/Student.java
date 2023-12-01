package com.example.geoquizfrontend.models;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String classCode;
    private float grade;
    private UserType userType;

    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public String getLastName() { return lastName; }
    public void setLastName(String name) { this.lastName = name; }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public float getGrade() { return grade; }
    public void setGrade(float grade) {
        this.grade = grade;
    }
    public String getClassCode() { return classCode; }
    public void setClassCode(String classCode) { this.classCode = classCode; }
}
