package com.example.geoquizbackend.Quiz;


import com.example.geoquizbackend.Student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private int score;
    private double duration;
     @ManyToOne
     @JsonIgnore
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
