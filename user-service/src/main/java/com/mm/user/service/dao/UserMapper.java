package com.mm.user.service.dao;

import com.mm.dao.BaseMapper;
import com.mm.user.service.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
