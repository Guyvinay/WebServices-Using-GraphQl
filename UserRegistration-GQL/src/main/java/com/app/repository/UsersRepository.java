package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	Optional<Users> findByEmail(String email);
}
