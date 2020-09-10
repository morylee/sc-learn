package com.mm.user.service.impl;

import com.mm.exception.ExistException;
import com.mm.user.service.api.UserApi;
import com.mm.user.service.model.User;
import com.mm.user.service.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiImpl implements UserApi {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getByUuid(String uuid) {
		return userMapper.load(new User(uuid, null));
	}

	@Override
	public User getByName(String name) {
		return userMapper.load(new User(null, name));
	}

	@Override
	public void save(String name, String nickname, String logoPath, String password) {
		if (null != getByName(name)) {
			throw new ExistException();
		}

		User user = new User(null, name);
		user.setNickname(nickname);
		user.setLogoPath(logoPath);
		user.setPassword(password);
		user.preInsert();

		userMapper.save(user);
	}

	@Override
	public boolean loginValid(String name, String password) {
		User user = getByName(name);
		if (user == null) {
			return false;
		} else {
			if (!password.equals(user.getPassword())) {
				return false;
			}
		}

		return true;
	}

}
