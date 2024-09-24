 package com.movieFlix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class navController {
	
	@GetMapping("map-sign")
	public String getregister() {
		return "register";
	}
	@GetMapping("map-log")
	public String getlogin() {
		return "login";
	}
	@GetMapping("map")
	public String getlog() {
		return "login";
	}
	@GetMapping("map1")
	public String getReg() {
		return "register";
	}
	@GetMapping("map2")
	public String getLogin() {
		return "login";
	}
	@GetMapping("add-movie")
	public String getAddMovie() {
		return "addmovie";
	}
	
	@GetMapping("add-movie1")
	public String getMovieAdd() {
		return "addmovie";
	}
	@GetMapping("go-adminhome")
	public String goadminhome() {
		return "adminhome";
	}
	@GetMapping("return-adminhome")
	public String getadminhome() {
		return "adminhome";
	}
	@GetMapping("delete-movie")
	public String gotodelete() {
		return "deletemovie";
	}

	@GetMapping("goto-adminhome")
	public String gotoadminhome() {
		return "adminhome";
	}
	@GetMapping("dele-user")
	public String gouserdelete() {
		return "deleteuser";
	}
	public navController() {
		// TODO Auto-generated constructor stub
	}@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@GetMapping("update")
	public String userUpdate() {
		return "updateprofile";
	}
	
	

}
