package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	List<Users> findByEmail(String email);
}
