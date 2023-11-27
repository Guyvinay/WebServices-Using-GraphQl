package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.modal.Users;

public interface UsersService {

	public Users registerUser(Users user);
	public List<Users> getAllUsers();
	public Users getUserDetails(String email);
}
