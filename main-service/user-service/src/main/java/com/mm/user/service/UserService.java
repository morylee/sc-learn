package com.mm.user.service;

import com.mm.common.impl.BaseApiImpl;
import com.mm.user.api.UserApi;
import com.mm.user.model.User;
import com.mm.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mory.lee
 */
@Service
public class UserService extends BaseApiImpl<User, UserMapper> implements UserApi {

	@Autowired
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

}
