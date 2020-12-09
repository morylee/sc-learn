package com.mm.base.service;

import com.mm.base.api.BaseApi;

import java.util.List;
import java.util.Map;

public abstract class BaseService<M extends BaseApi<T>, T> {

	protected M api;

	/**
	 * 获取单条数据
	 *
	 * @param entity
	 * @return
	 */
	public T load(T entity) {
		return api.load(entity);
	}

	/**
	 * 根据条件获取数据
	 *
	 * @param params
	 * @return
	 */
	public List<T> loadAll(Map<String, Object> params) {
		return api.loadAll(params);
	}

	/**
	 * 根据条件查询数量
	 *
	 * @param params
	 * @return
	 */
	public int count(Map<String, Object> params) {
		return api.count(params);
	}

	/**
	 * 保存
	 *
	 * @param entity
	 */
	public void save(T entity) {
		api.save(entity);
	}

	/**
	 * 批量保存
	 *
	 * @param entities
	 */
	public void saves(List<T> entities) {
		api.saves(entities);
	}

	/**
	 * 更新
	 *
	 * @param entity
	 */
	public void update(T entity) {
		api.update(entity);
	}

	/**
	 * 删除
	 *
	 * @param entity
	 */
	public void delete(T entity) {
		api.delete(entity);
	}

}
