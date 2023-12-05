package com.example.geoquizfrontend.models;

import com.example.geoquizfrontend.models.Quiz;

import java.util.Set;

public abstract class User {

    private long id;
    private UserType userType;
    private Set<Quiz> quizzes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
