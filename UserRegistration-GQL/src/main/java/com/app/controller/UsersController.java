package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.app.modal.Users;
import com.app.modal.UsersReq;
import com.app.service.UsersService;

/*
//login
{
   "email":"vinay@gmail.com",
   "password":"Vinay@1234"
}


{
    "status":"active",
    "role":"ADMIN",
    "password":"User@1234",
    "mobile":"1234567890",
    "email":"userone@gmail.com",
    "last_name":" One ",
    "first_name":"User"
}
*/

@Controller
public class UsersController {	

	@Autowired
	private UsersService usersService;
	
	@MutationMapping("register")
	public Users saveUser(@Argument  UsersReq user){
		Users userN = new Users(
				user.getName(),
				user.getEmail(),
				user.getMobile(),
				user.getPassword(),
				user.getRole()
		);
		return usersService.registerUser(userN);
	}
	@QueryMapping("getUser")
	public Users getUserByEmail(@Argument String email){
		return usersService.getUserDetails(email);
	}
	@QueryMapping("allUsers")
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}



}
