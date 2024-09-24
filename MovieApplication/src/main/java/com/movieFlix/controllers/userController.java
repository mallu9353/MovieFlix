package com.movieFlix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieFlix.entities.Movie;
import com.movieFlix.entities.User;
import com.movieFlix.services.movieService;
import com.movieFlix.services.userService;

import jakarta.servlet.http.HttpSession;
@Controller
public class userController {
	@Autowired
	userService usser;
	@Autowired
	movieService movser;
	@PostMapping("registration")
	public String addUser(@ModelAttribute User us) {
		boolean status= usser.emailExist(us.getEmail());
		if(status==true) {
			
			return "registerfailed";
			
		}
		else {
			usser.userAdd(us);
			return "registersuccess";
		}
	}
	@PostMapping("login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session) {
	    boolean status = usser.checkUser(email, password);
	    	
			if(status==true) {
				session.setAttribute("email",email);
				if(email.equals("admin@gmail.com")) {
					return "adminhome";
				}
				else {
					return "home";
				}
			}
			else {
				return "loginfailed";
			}
			
	}		
	@GetMapping("view-user")
	public String viewUsers(Model model) {
		List<User> userlist = usser.getUsers();
		model.addAttribute("users", userlist);
		
		return "viewusers";
	}
	@PostMapping("delete-user")
	public String deleteUser(@RequestParam Integer id) {
		usser.deleteUser(id);
		return "deleteusersuccessfull";
	}
	@PostMapping("go-update")
	public String updateUser(@ModelAttribute User us) {
		usser.updateUser(us);
		return "profileupdated";
	}
	
	
	@GetMapping("explore-movies")
	public String exploreMovies( HttpSession session,Model model) {
		  //getting the email from session
		String emailString=(String) session.getAttribute("email");
		  //getting the user details for email
		User usr= usser.getUser(emailString);
		boolean status=usr.isPremium();
		
		  //checking whether user id premium
		if (status==true) {
			//getting the list of movies
			List<Movie> uList=movser.viewMovies();
			//adding the movie details in model
			model.addAttribute("userlist",uList);
		   //if premium, ShowSummary movies
			return "userviewmovies";
		}
		else {
		//else, make payment
			return "payment";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}


	}


