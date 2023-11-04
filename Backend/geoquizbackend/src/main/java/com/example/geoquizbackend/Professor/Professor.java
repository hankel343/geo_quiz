package com.example.geoquizbackend.Professor;

import com.example.geoquizbackend.Quiz.Quiz;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	String firstName;
	String lastName;
	String email;
	String password;

	public Professor() {

	}

	public long getId() { return id; }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() { return lastName; }

	public void setLastName(String name) { this.lastName = name; }

	public String getPassword() { return password; }

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
