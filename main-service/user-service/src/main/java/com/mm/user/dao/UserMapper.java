package com.mm.user.dao;

import com.mm.common.dao.BaseMapper;
import com.mm.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
