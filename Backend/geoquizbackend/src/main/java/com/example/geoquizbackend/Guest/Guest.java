package com.example.geoquizbackend.Guest;

import com.example.geoquizbackend.Quiz.*;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int score;
	String initials;
	@OneToMany
    Set<Quiz> q;
	public Guest(){

	}

	public int getScore(){
		return score;
	}

	public void setScore(int score){
		this.score = score;
	}
	
	public String getInitials(){
		return initials;
	}
	
	public void setInitials(String initials){
		this.initials = initials;
	}

}
