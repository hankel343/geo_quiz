package com.example.geoquizfrontend.models;

public class Quiz {
    private int id;
    private int score;
    private double duration;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
}
