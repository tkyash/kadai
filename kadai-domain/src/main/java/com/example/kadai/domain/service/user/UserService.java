package com.example.kadai.domain.service.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;

public interface UserService {

	User findOne(String id);

	List<User> findAll();
	
	Page<User> findAll(User user, Role role, Pageable pageable);

	long count();

	void create(User user, Role role);

	void update(User user, Role role);

	void delete(String id);
}
