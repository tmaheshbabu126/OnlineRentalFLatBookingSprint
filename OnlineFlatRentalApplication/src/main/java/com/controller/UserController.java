package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.entities.User;
import com.advice.UserNotFoundException;
import com.service.IUserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path="/api")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(path = "/getUsers")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> list = userService.viewAllUser();
		ResponseEntity<List<User>> re=new ResponseEntity<List<User>>(list,HttpStatus.OK);
		return re;
	}

	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> viewUser(@PathVariable Integer userId) throws UserNotFoundException {
		User viewUser = userService.viewUser(userId);
		ResponseEntity<User> re=new ResponseEntity<User>(viewUser,HttpStatus.OK);
		return re;
	}

	@PostMapping(path = "/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user1) {
		User user=userService.addUser(user1);
		ResponseEntity<User> re=new ResponseEntity<User>(user1,HttpStatus.OK);
		return re;
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> removeUser(@PathVariable Integer userId) throws Exception {
		
		User user=new User();
		user.setUserId(userId);
		userService.removeUser(user);
		ResponseEntity<User> re=new ResponseEntity<User>(user,HttpStatus.OK);
		return re;
	}

	@PutMapping(path="/updateUser")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws Exception 
	{
		User e1=userService.updateUser(user);
		
		ResponseEntity re=new ResponseEntity<User>(e1,HttpStatus.OK);
		return re;
	}

	@PostMapping("/update-password")
	public ResponseEntity<User> updatePassword(@RequestParam("userId") Integer userId,
			@RequestParam("newPassword") String newPassword) {

		User user = new User();
		user.setUserId(userId);
		ResponseEntity<User> re=new ResponseEntity<User>(user,HttpStatus.OK);

		return ResponseEntity.ok(userService.updatePassword(user, newPassword));
	}

	@PostMapping("/validate-user")
	public ResponseEntity<String> validateUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password) throws UserNotFoundException {
		User user = userService.validateUser(userName, password);
		if (user == null) {
			return ResponseEntity.ok("Invalid user name or password");
		}
		return ResponseEntity.ok("valid user");
	}

	@ExceptionHandler(UserNotFoundException.class)
	private ResponseEntity<String> handlerUserNotFoundException() {
		return ResponseEntity.ok("User not found");
	}

}
