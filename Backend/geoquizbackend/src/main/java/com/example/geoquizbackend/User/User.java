package com.example.geoquizbackend.User;

import com.example.geoquizbackend.Enums.UserType;
import com.example.geoquizbackend.Quiz.Quiz;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Schema(description = "User entity")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique identifier for the user", example = "1")
    long id;
    public UserType userType;
    @OneToMany
    @Schema(description = "Set of quizzes taken by the user")
    Set<Quiz> quizzes;

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
