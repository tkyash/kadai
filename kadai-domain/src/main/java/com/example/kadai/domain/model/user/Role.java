package com.example.kadai.domain.model.user;

import java.io.Serializable;
import java.util.Date;

import com.example.kadai.domain.common.enums.UserRole;
import com.example.kadai.domain.common.enums.UserStatus;

public class Role implements Serializable {

	private static final long serialVersionUID = 6734215887272141206L;

	private String id;
	private String role;
	private String[] userRole;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String[] getUserRole() {
		return userRole;
	}

	public void setUserRole(String[] userRole) {
		this.userRole = userRole;
	}

}
