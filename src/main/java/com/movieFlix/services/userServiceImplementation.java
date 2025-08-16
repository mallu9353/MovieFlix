package com.movieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieFlix.entities.User;
import com.movieFlix.repository.userRepository;
@Service
public class userServiceImplementation implements userService {
	@Autowired
	userRepository userRepo;

	@Override
	public String userAdd(User us) {
		
		userRepo.save(us);
		return "user is created";
	}

	@Override
	public boolean emailExist(String email) {
		if(userRepo.findByEmail(email)==null) {
			return false;
		
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkUser(String email, String password) {
		// TODO Auto-generated method stub
		
	     User us= userRepo.findByEmail(email);
	     String db_email=us.getEmail();
	     
	     String db_password= us.getPassword();
	     if(db_password.equals(password)) {
	    	 return true;
	     }
	     else {
	    	 return false;
	     }
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
	List<User> users= userRepo.findAll();
	return users;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
		
		
	}

	

	@Override
	public User getUser(String email) {	
	User us=userRepo.findByEmail(email);
	return us;
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}
	
	

}
