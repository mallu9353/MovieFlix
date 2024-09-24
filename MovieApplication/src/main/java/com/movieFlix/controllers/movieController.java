 package com.movieFlix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieFlix.entities.Movie;
import com.movieFlix.services.movieService;
@Controller
public class movieController {
	@Autowired
	movieService movser;
	@PostMapping("add-movie")
	public String addMovie(@ModelAttribute Movie mv) {
	boolean status=	movser.movieExist(mv.getName());
		if (status==true) {
			return "addanotherMovie";
		}
		else {
			movser.addMovie(mv);
			return "movieaddedsuccessfully";
		}
	}
	@GetMapping("view-movie")
	public String viewMovies(Model model) {
		List<Movie> mList = movser.viewMovies();
		model.addAttribute("movielist",mList);
		return "viewmovies";
	}
	
	@PostMapping("del-movie")
	public String deleteMovies(@RequestParam Integer id) {
		movser.deleteMovie(id);
		return "moviedeletedsuccess";
	}
	
	@GetMapping("view-movies")
	public String userViewMovies(Model model) {
		List<Movie> uList=movser.viewMovies();
		model.addAttribute("userlist",uList);
		return "userviewmovies";
	}
	
	
}
