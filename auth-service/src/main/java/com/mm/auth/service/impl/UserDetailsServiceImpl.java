package com.mm.auth.service.impl;

import com.mm.auth.service.dao.MenuMapper;
import com.mm.auth.service.dao.UserMapper;
import com.mm.auth.service.model.Menu;
import com.mm.auth.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.findByUsername(username);
		List<Menu> menus = menuMapper.loadAllByUsername(username);
		user.setAuthorities(menus);
		return user;
	}

}
