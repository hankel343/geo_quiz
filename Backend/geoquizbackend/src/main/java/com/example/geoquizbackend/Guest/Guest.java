package com.example.geoquizbackend.Guest;

import com.example.geoquizbackend.Quiz.*;
import com.example.geoquizbackend.User.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Schema(description = "Guest entity")
public class Guest extends User {

	@Schema(description = "Initials of the guest", example = "JD")
	String initials;

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}
}
