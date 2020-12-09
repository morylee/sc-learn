package com.mm.auth.server.dao;

import com.mm.auth.server.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

	List<Menu> loadAllByUsername(String username);

}
