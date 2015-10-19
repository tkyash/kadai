package com.example.kadai.app.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.kadai.app.common.check.single.annotation.ChkAddress;
import com.example.kadai.app.common.check.single.annotation.ChkBirthday;
import com.example.kadai.app.common.check.single.annotation.ChkPassword;
import com.example.kadai.app.common.check.single.annotation.ChkTel;
import com.example.kadai.app.common.check.single.annotation.ChkUserId;
import com.example.kadai.app.common.check.single.annotation.ChkUserName;

public class UserForm implements Serializable {

	private static final long serialVersionUID = 5997286193019785998L;

	public static interface register {
	};

	public static interface search {
	};
	public static interface delete {
	};

	@ChkUserId
	@NotNull(groups = {register.class,delete.class})
	private String id;

	@ChkPassword(groups = register.class)
	@NotNull(groups = register.class)
	private String password;

	@NotNull(groups = register.class)
	private String confirmPassword;

	@ChkUserName
	@NotNull(groups = register.class)
	private String name;

	@ChkBirthday
	@NotNull(groups = register.class)
	private String birthday;

	@ChkAddress
	@NotNull(groups = register.class)
	private String address;

	@ChkTel
	@NotNull(groups = register.class)
	private String tel;

	@Size(groups = register.class, min = 1, max = 2)
	// TODO チェックボックスのリセット処理がない。
	private String[] userRole;

	private String userStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String[] getUserRole() {
		return userRole;
	}

	public void setUserRole(String[] userRole) {
		this.userRole = userRole;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
