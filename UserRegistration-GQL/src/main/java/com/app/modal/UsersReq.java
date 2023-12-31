package com.app.modal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersReq {

	private String name;

	private String email;
	

	private String mobile;
	

	private String password;

	private String role;
}
