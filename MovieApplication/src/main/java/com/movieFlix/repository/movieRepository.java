package com.movieFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieFlix.entities.Movie;

public interface movieRepository extends JpaRepository<Movie, Integer> {
	public Movie findByName(String name);
	
}
