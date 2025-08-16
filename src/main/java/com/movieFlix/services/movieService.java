package com.movieFlix.services;

import java.util.List;

import com.movieFlix.entities.Movie;

public interface movieService {
	
	public String addMovie(Movie mv);
	
	public boolean movieExist(String name);
	
	public List<Movie> viewMovies();
	
	public void deleteMovie(Integer id);

}
