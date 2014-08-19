package com.hakstrace.system.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hakstrace.framework.domain.Domain;

@Entity
@Table(name="users")
public class User extends Domain{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id", nullable = false)
	private String userId;

	@Column(name="user_name", nullable = false)
	private String userName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
	
	@ManyToOne()
	private Authority authority; 
	

	public User() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	
	public Authority getAuthority(){
		return authority;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthority(Authority authority){
		this.authority = authority;
	}
}
