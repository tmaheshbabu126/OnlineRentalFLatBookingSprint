package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.User;
import com.advice.UserNotFoundException;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
	public User findByUserNameAndPassword(String userName,String password);
	   @Query("Select u from User u where u.userId=?1 and u.password=?2")
	   Optional<User> SignIn(int var1, String var2);
	
	   @Query("Select u from User u where u.userId=?1 and u.password=?2")
	   Optional<User> Changepassword(int userId, String password);
	
}
