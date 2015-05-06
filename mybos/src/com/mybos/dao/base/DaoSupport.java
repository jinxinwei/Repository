package com.mybos.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mybos.domain.PageBean;
import com.mybos.utils.QueryHelp;


public interface DaoSupport<T>{
	void save(T entity);
	void delete(Long id);
	void delete(Serializable[] ids);
	void update(T entity);
	List<T> findAll();
	T findById(Long id);
	List<T> findByIds(Long[] ids);
	PageBean<T> findPageBean(Integer page, Integer pageSize, String hql,
			ArrayList<Object> param);
	PageBean<T> findPageBean(Integer page, Integer pageSize, QueryHelp queryHelp);

}
