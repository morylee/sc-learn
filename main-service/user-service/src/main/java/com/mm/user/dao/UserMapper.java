package com.mm.user.dao;

import com.mm.base.dao.BaseMapper;
import com.mm.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
