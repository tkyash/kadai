package com.example.kadai.domain.repository.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;

public interface UserRepository {

	User findOne(String id);

	List<User> findAll();

	Page<User> findAll(Pageable pageable);

	long count();

	void create(User entity);

	void update(User entity);

	void delete(String id);

	User findOneRole(String id);

	void createRole(Role entity);

	void updateRole(Role entity);

	void deleteRole(String id);

}
