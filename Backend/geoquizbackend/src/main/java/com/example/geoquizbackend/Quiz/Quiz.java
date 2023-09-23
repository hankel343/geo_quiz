package com.example.geoquizbackend.Quiz;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private int score;

    private double duration;

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // @JsonIgnore
    // private Person person

    public Quiz() {

    }

    // =============================== Getters and Setters for each field ================================== //

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }


}
