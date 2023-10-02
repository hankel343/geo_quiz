package com.example.geoquizbackend.Quiz;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private int score;

    private double duration;

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // @JsonIgnore
    // private Student student

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
