package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.User;
import com.repository.IUserRepository;
@SpringBootTest
class UserServiceTest {
	@Autowired 
	IUserService userservice;
	
	@MockBean
	IUserRepository userRepo;

	@Test
	void testViewUser()  {
	       User u1 = new User();
	        u1.setUserId(1);
			u1.setUserName("Saili");
			u1.setPassword("Passwo");
			u1.setUserType("admin");
			Mockito.when(userRepo.save(u1)).thenReturn(u1);
			User response=userservice.addUser(u1);
			assertThat(response.getUserId()).isEqualTo(1);
			assertThat(response.getUserName()).isEqualTo("Saili");
			assertThat(response.getPassword()).isEqualTo("Passwo");
			assertThat(response.getUserType()).isEqualTo("admin");
         
       
	       
	
	}

	@Test
	public void testViewAllUser()  {
		User u1 = new User();
		u1.setUserId(1);
		u1.setUserName("Saili");
		u1.setPassword("Passwo");
		u1.setUserType("admin");
       
    	User u2 = new User();
    	u2.setUserId(2);
		u2.setUserName("Lahari");
		u2.setPassword("Akshar");
		u2.setUserType("user");
    
	    List<User> userList = new ArrayList();
	    userList.add(u1);
	    userList.add(u2);
	    Mockito.when(this.userRepo.findAll()).thenReturn(userList);
	    Assertions.assertThat(this.userservice.viewAllUser()).isEqualTo(userList);
	}
	

	

	@Test
	void testAddUser() {
		User u1 = new User();
		u1.setUserId(1);
		u1.setUserName("Saili");
		u1.setPassword("Passwo");
		u1.setUserType("admin");
        Mockito.when((User)this.userRepo.save(u1)).thenReturn(u1);
        Assertions.assertThat(this.userservice.addUser(u1)).isEqualTo(u1);
	}


	@Test
	void testUpdateUser() throws Exception {
		User u1 = new User();
		u1.setUserId(1);
		u1.setUserName("Saili");
		u1.setPassword("Passwo");
		u1.setUserType("admin");
		
		Optional<User> u2=Optional.of(u1);
		Mockito.when(userRepo.findById(1)).thenReturn(u2);
		u1.setUserName("Sailu");
		Mockito.when(userRepo.save(u1)).thenReturn(u1);
		assertThat(userservice.updateUser(u1).equals(u1));
	
		
	}

	@Test
	void testUpdatePassword() {
		User u1 = new User();
		u1.setUserId(1);
		u1.setUserName("Saili");
		u1.setPassword("Passwo");
		u1.setUserType("admin");
		
		Optional<User> u2=Optional.of(u1);
		Mockito.when(userRepo.findById(1)).thenReturn(u2);
		u1.setPassword("Sailu");
		Mockito.when(userRepo.save(u1)).thenReturn(u1);
		assertThat(userservice.updatePassword(u1,"Sailu")).isEqualTo(u1);
		
		
	}

	@Test
	void testRemoveUser() {
		 User u1 = new User();
			u1.setUserId(1);
			u1.setUserName("Saili");
			u1.setPassword("Passwo");
			u1.setUserType("admin");
			Optional<User> u2=Optional.of(u1);
			
			Mockito.when(userRepo.findById(100)).thenReturn(u2);
			Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(false);
			assertFalse(userRepo.existsById(u1.getUserId()));
	
	
	}

}
