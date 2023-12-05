package com.example.geoquizbackend.Quiz;

public class InvalidQuizCountException extends RuntimeException {
    public InvalidQuizCountException(String message) {
        super(message);
    }
}
