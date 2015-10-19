package com.example.kadai.domain.repository.user;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Pageable;

import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;

public interface UserRepository {

	User findOne(String id);

	List<User> findAll(User entity, RowBounds rowBounds);

	long count(User entity);

	void create(User entity);

	void update(User entity);

	void delete(String id);

	Role findOneRole(String id);

	List<Role> findAllRole(Role entity);

	long countRole(Role entity);

	void createRole(Role entity);

	void updateRole(Role entity);

	void deleteRole(String id);

}
