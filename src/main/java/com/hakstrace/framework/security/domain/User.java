package com.hakstrace.framework.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hakstrace.framework.domain.Domain;

@Entity
@Table(name="users")
public class User extends Domain{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="user_name", nullable = false)
	private String userName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	protected User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
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

}
