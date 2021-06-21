package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@NotEmpty(message = "User name is required")
	 @NotNull
	 @Size(min=3,max=6)
	 @Pattern(regexp="^[A-Z][a-z]",message="length must be 3") 
	 private String userName;
	  
	 @NotEmpty(message = "Password is required")
	 @Pattern(regexp="^[A-Z][a-z]",message="length must be 3") 
	 @NotNull
	 private String password;
	 
	 @NotEmpty(message = "userType is required")
	 @NotNull
	 @Size(min=3,max=6)
	 private String userType;
	 
	 public User() {
		 super();
	 }
	 
	 public User(int userId,
			@NotEmpty(message = "User name is required") @NotNull @Size(min=3,max = 6) @Pattern(regexp = "^[a-z][A-Z]{3}", message = "length must be 3") String userName,
			@NotEmpty(message = "Password is required") @Pattern(regexp = "^[a-z][A-Z]", message = "length must be 3") @NotNull String password,
			@NotEmpty(message = "User Type is required") @NotNull @Size(min=3,max = 6) String userType) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
			this.userType = userType;
		}
	 
	
	public  int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ "]";
	}
	
	
}
