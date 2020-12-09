package com.mm.auth.server.dao;

import com.mm.auth.server.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	User findByUsername(String username);

}
