package com.hakstrace.system.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hakstrace.framework.domain.Domain;

@Entity
@Table(name="authorities")
public class Authority extends Domain{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="auth_code")
	private String authCode;

	@Column(name="auth_name", nullable = false)
	private String authName;

	@Column
	private String description;

	protected Authority() {
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
