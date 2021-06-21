package com.implementation;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.entities.User;
import com.advice.UserNotFoundException;
import com.repository.IUserRepository;
import com.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User viewUser(int id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
	}

	@Override
	public List<User> viewAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User validateUser(String username, String password) {

		User user = userRepository.findByUserNameAndPassword(username, password);
		return user;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	
	@Override
	public User updateUser(User user ) throws Exception  {
	
		int uid = user.getUserId();
		
		System.out.println(user.getUserName());
		Supplier<Exception> s = () -> new UserNotFoundException("User not found");
		User c1=userRepository.findById(uid).orElseThrow(s);
		c1.setUserId(user.getUserId());
		c1.setUserName(user.getUserName());
		c1.setUserType(user.getUserType());
		userRepository.save(c1);	
		return c1;
	}

	@Override
	public User updatePassword(User user, String newpass) {
		user = userRepository.findById(user.getUserId()).get();
		user.setPassword(newpass);
		return userRepository.save(user);
	}

	@Override
	public void removeUser(User user) throws Exception {
		Supplier<Exception> s = () -> new UserNotFoundException("User Id is not present in the database");
	    userRepository.findById(user.getUserId()).orElseThrow(s);
		userRepository.delete(user);
	}

}
