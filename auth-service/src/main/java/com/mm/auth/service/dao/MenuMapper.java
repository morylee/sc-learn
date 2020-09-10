package com.mm.auth.service.dao;

import com.mm.auth.service.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

	List<Menu> loadAllByUsername(String username);

}
