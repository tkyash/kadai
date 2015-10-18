package com.example.kadai.app.login;

import java.io.Serializable;

public class LoginForm implements Serializable {

	private static final long serialVersionUID = -5075082214543636171L;
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
