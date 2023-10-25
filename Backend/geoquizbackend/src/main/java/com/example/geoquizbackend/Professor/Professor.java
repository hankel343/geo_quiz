package com.example.geoquizbackend.Professor;

import jakarta.persistence.*;


@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String name;
	String email;
	
	int[] classcodes;
	
	//@OneToMany
	//Class[] classes;
	
	public Professor() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int[] getClasscodes() {
		return classcodes;
	}
	
	public void setClasscodes(int[] classes) {
		classcodes = classes;
	}
}
