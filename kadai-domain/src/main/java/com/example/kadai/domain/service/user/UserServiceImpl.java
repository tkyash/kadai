package com.example.kadai.domain.service.user;

import java.awt.image.SampleModel;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.codelist.CodeList;

import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;
import com.example.kadai.domain.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository;

	@Inject
	@Named("CL_USERROLE")
	CodeList userRoleCodeList;

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {

		List<User> user = userRepository.findAll();

		return user;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(User user, Role role) {

		// TODO 重複チェックが必要。

		// 登録時はステータスをinitにする。
		// TODO 本当はenumからとりたいが、時間がないので文字列にしてしまう。SQLのデフォやに直書きでもいい気がする。
		user.setUserStatus("INIT");
		userRepository.create(user);

		for (int i = 0; i < role.getUserRole().length; i++) {
			// コードリストを使って権限の数字を文字列に変換する。
			role.setRole(userRoleCodeList.asMap().get(role.getUserRole()[i]));
			userRepository.createRole(role);
		}

	}

	@Override
	public void update(User user, Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
