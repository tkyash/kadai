package com.example.kadai.domain.service.user;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

		User user = userRepository.findOne(id);

		// ロール名の組み立てを行う
		// 検索用に対象のIDをセット
		Role searchRole = new Role();
		searchRole.setId(user.getId());

		List<Role> roles = userRepository.findAllRole(searchRole);
		StringBuilder roleBuf = new StringBuilder();
		for (Role rol : roles) {
			roleBuf.append(rol.getRole());
			roleBuf.append(",");
		}

		user.setuserRole(new String(roleBuf));

		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(User user, Role role, Pageable pageable) {

		// Userの検索結果件数を取得
		long total = userRepository.count(user);
		List<User> users;
		if (0 < total) {

			RowBounds rowBounds = new RowBounds(pageable.getOffset(),
					pageable.getPageSize());

			users = userRepository.findAll(user, rowBounds);

			// ロール名の組み立てを行う
			for (User usr : users) {

				// 検索用に対象のIDをセット
				Role searchRole = new Role();
				searchRole.setId(usr.getId());

				List<Role> roles = userRepository.findAllRole(searchRole);
				StringBuilder roleBuf = new StringBuilder();
				for (Role rol : roles) {
					roleBuf.append(rol.getRole());
					roleBuf.append(" ");
				}
				usr.setuserRole(new String(roleBuf));
			}

		} else {

			users = Collections.emptyList();
		}

		return new PageImpl<>(users, pageable, total);

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
		
		userRepository.delete(id);
		userRepository.deleteRole(id);
		
	}

}
