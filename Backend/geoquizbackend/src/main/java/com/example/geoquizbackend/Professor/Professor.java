package com.example.geoquizbackend.Professor;

import com.example.geoquizbackend.GeoClass.GeoClass;
import com.example.geoquizbackend.Student.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Schema(description = "Professor entity")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Unique identifier for the professor", example = "1")
	long id;
	@Schema(description = "First name of the professor", example = "John")
	String firstName;
	@Schema(description = "Last name of the professor", example = "Doe")
	String lastName;
	@Schema(description = "Email of the professor", example = "john.doe@example.com")
	String email;
	@Schema(description = "Password of the professor", example = "password123")
	String password;
	@OneToMany(mappedBy = "professor")
	@Schema(description = "Set of students associated with the professor")
	Set<Student> students;
	@OneToMany(mappedBy = "professor")
	@Schema(description = "Set of GeoClasses associated with the professor")
	Set<GeoClass> geoClasses;
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
