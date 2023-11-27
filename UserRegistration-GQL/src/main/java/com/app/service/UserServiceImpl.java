package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.UserNotFound;
import com.app.modal.Users;
import com.app.repository.UsersRepository;


@Service
public class UserServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public Users  registerUser(Users user) {
		user.setRole("ROLE_"+user.getRole().toUpperCase());
		 Users save = usersRepository.save(user);
		 
		 Map<String, Object> responseBody = new HashMap<>();
		    responseBody.put("status", 200);
			responseBody.put("message", "Logged in Successfully");
			responseBody.put("userData", save);
			
			return save;
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUserDetails(String email) {
		return usersRepository.findByEmail(email)
				.orElseThrow( ()->
				new UserNotFound("User Not Found"));
		
	}


}
