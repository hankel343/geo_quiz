package com.example.geoquizbackend.Quiz;

import com.example.geoquizbackend.Guest.Guest;
import com.example.geoquizbackend.Student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Schema(description = "Quiz entity")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique identifier for the quiz", example = "1")
    long id;
    @Schema(description = "Score of the quiz", example = "85")
    private int score;
    @Schema(description = "Duration of the quiz in hours", example = "1.5")
    private double duration;
    @ManyToOne
    @JsonIgnore
    @Schema(description = "Student associated with the quiz")
    private Student student;
    public Quiz() {
    }
    // =============================== Getters and Setters for each field ================================== //
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }
}
