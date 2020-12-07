package com.mm.auth.service.dao;

import com.mm.auth.service.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	User findByUsername(String username);

}
