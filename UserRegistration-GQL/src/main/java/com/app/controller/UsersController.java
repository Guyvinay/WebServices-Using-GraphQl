package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping(value = "/users")
public class UsersController {	

	@Autowired
	private UsersService usersService;
	
	@MutationMapping("/register")
	public ResponseEntity<Map<String, Object>> saveUser(@Argument  UsersReq userReq){
		Users user = new Users(
				userReq.getName(),
				userReq.getEmail(),
				userReq.getMobile(),
				userReq.getPassword(),
				userReq.getRole()
		);
		return new ResponseEntity<Map<String, Object>>(usersService.registerUser(user),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getByEmail/{email}")
	public ResponseEntity<Users> getUserByEmai(@PathVariable("email")String email){
		return new ResponseEntity<Users>(usersService.getUserDetails(email),HttpStatus.ACCEPTED);
	}


}
