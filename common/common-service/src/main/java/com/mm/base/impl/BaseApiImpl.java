package com.mm.base.impl;

import com.mm.base.api.BaseApi;
import com.mm.base.dao.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author mory.lee
 */
public abstract class BaseApiImpl<T, M extends BaseMapper<T>> implements BaseApi<T> {

	protected M mapper;

	/**
	 * 获取单条数据
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public T load(T entity) {
		return mapper.load(entity);
	}

	/**
	 * 根据条件获取数据
	 *
	 * @param params
	 * @return
	 */
	@Override
	public List<T> loadAll(Map<String, Object> params) {
		return mapper.loadAll(params);
	}

	/**
	 * 根据条件查询数量
	 *
	 * @param params
	 * @return
	 */
	@Override
	public int count(Map<String, Object> params) {
		return mapper.count(params);
	}

	/**
	 * 保存
	 *
	 * @param entity
	 */
	@Override
	public void save(T entity) {
		mapper.save(entity);
	}

	/**
	 * 批量保存
	 *
	 * @param entities
	 */
	@Override
	public void saves(List<T> entities) {
		mapper.saves(entities);
	}

	/**
	 * 更新
	 *
	 * @param entity
	 */
	@Override
	public void update(T entity) {
		mapper.update(entity);
	}

	/**
	 * 删除
	 *
	 * @param entity
	 */
	@Override
	public void delete(T entity) {
		mapper.delete(entity);
	}

}
