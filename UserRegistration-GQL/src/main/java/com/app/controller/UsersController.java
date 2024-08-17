package com.app.controller;

import java.util.List;
import java.util.Map;

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

http://localhost:9009/graphql
query AllUsers {
    allUsers {
        name
        mobile
        email
    }
}

mutation Register {
    register(
        user: {
            name: "Vinay KS"
            mobile: "7479856872"
            email: "vin@gmail.com"
            role: "ADMIn"
            password: "password"
        }
    ) {
        mobile
        role
        email
        password
    }
}





*/

@Controller
public class UsersController {	

	@Autowired
	private UsersService usersService;
	
	@MutationMapping("registerNewUser")
	public Map<String, Object> saveUser(@Argument  UsersReq user){
		Users userN = new Users(
				user.getName(),
				user.getEmail(),
				user.getMobile(),
				user.getPassword(),
				user.getRole()
		);
		return usersService.registerUser(userN);
	}
	@QueryMapping("getUserByEmail")
	public Users getUserByEmail(@Argument String email){
		return usersService.getUserDetails(email);
	}
	@QueryMapping("allUsers")
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}



}
