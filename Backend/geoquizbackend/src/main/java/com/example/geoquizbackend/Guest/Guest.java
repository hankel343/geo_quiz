package com.example.geoquizbackend.Guest;

import com.example.geoquizbackend.Quiz.*;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Schema(description = "Guest entity")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Unique identifier for the guest", example = "1")
	long id;

	@Schema(description = "Score of the guest", example = "85")
	int score;

	@Schema(description = "Initials of the guest", example = "JD")
	String initials;
	@OneToMany
	@Schema(description = "Set of quizzes taken by the guest")
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
