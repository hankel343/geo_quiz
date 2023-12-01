package com.example.geoquizfrontend.models;

import com.example.geoquizfrontend.models.Quiz;

public class Guest extends User {

    private String initials;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
