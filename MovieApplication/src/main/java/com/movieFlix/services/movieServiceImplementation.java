package com.movieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieFlix.entities.Movie;
import com.movieFlix.repository.movieRepository;
@Service
public class movieServiceImplementation implements movieService{
	@Autowired
	movieRepository movrepo;
	
	@Override
	public String addMovie(Movie mv) {
		movrepo.save(mv);
		return "Movie added successfully";
	}

	@Override
	public boolean movieExist(String name) {
		Movie mvMovie= movrepo.findByName(name);
		if(mvMovie==null) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public List<Movie> viewMovies() {
	List<Movie> movieList=	movrepo.findAll();	
	return movieList;
	}

	@Override
	public void deleteMovie(Integer id) {
	 movrepo.deleteById(id);
	
	}

}
