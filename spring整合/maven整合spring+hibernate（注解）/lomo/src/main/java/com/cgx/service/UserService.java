package com.cgx.service;

import java.util.List;

import com.cgx.dto.User;

public interface UserService {

	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User findUserById(int id);
	
	public void deleteUser(User user);
	
	public List<User> findAllList();
	
	public User findUserByUsernameAndPassword(User user);
	
	public boolean findUserIsExites(String username);
}
