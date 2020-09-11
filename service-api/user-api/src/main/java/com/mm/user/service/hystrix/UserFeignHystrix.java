package com.mm.user.service.hystrix;

import com.mm.user.service.api.UserApi;
import com.mm.user.service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignHystrix implements UserApi {
	@Override
	public User getByUuid(String uuid) {
		return null;
	}

	@Override
	public User getByName(String name) {
		return null;
	}

	@Override
	public void save(String name, String nickname, String logoPath, String password) {

	}

	@Override
	public boolean loginValid(String name, String password) {
		return false;
	}

}
