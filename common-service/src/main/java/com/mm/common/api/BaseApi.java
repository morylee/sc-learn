package com.mm.common.api;

import java.util.List;
import java.util.Map;

/**
 * @author mory.lee
 */
public interface BaseApi<T> {

	/**
	 * 获取单条数据
	 *
	 * @param entity
	 * @return
	 */
	T load(T entity);

	/**
	 * 根据条件获取数据
	 *
	 * @param params
	 * @return
	 */
	List<T> loadAll(Map<String, Object> params);

	/**
	 * 根据条件查询数量
	 *
	 * @param params
	 * @return
	 */
	int count(Map<String, Object> params);

	/**
	 * 保存
	 *
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 批量保存
	 *
	 * @param entities
	 */
	void saves(List<T> entities);

	/**
	 * 更新
	 *
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 删除
	 *
	 * @param entity
	 */
	void delete(T entity);

}
