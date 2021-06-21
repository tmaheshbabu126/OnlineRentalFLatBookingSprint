package com.service;

import java.util.List;

import com.entities.User;
import com.advice.UserNotFoundException;

public interface IUserService {
	public User viewUser(int id) throws UserNotFoundException;
	public List<User> viewAllUser();
	public User validateUser(String username,String password) throws UserNotFoundException;
	public User addUser(User user);
	public User updateUser(User user) throws Exception;
	public User updatePassword(User user,String newpass);
	public void removeUser(User user) throws UserNotFoundException, Exception;
}
