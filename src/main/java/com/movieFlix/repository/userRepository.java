package com.movieFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieFlix.entities.User;

public interface userRepository extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);

}
