package com.movieFlix.services;

import java.util.List;

import com.movieFlix.entities.User;

public interface userService {
	public String userAdd(User us);
	
	public boolean emailExist(String email);
	
	public boolean checkUser(String email,String password);
	public List<User> getUsers();
	
	public void deleteUser(Integer id);
	
	
	
	public User getUser(String email);
	
	public void updateUser(User user);

}
