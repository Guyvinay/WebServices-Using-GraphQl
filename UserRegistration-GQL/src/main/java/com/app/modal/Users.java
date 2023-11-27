package com.app.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {


	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String user_id;


	private String name;
	

	private String email;
	

	private String mobile;

	private String password;
	

	private String role;

	public Users(String name, String email, String mobile, String password, String role) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}
}
