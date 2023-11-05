package com.example.geoquizfrontend.models;

import java.util.Set;

public class Guest {
    private long id;
    private int score;
    private String initials;
    public Guest() {
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getInitials() {
        return initials;
    }
    public void setInitials(String initials) {
        this.initials = initials;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
