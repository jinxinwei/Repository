package com.mybos.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mybos.domain.PageBean;
import com.mybos.utils.QueryHelp;


@SuppressWarnings("unchecked")
@Repository
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {
	
	private Class<T> clazz;
 	public DaoSupportImpl(){
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz=(Class<T>)type.getActualTypeArguments()[0];
 	}

	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void delete(Long id) {
		T entity=findById(id);
		if(entity!=null){
			getSession().delete(entity);			
		}
	}
	
	public void delete(Serializable[] ids){
		String hql="delete from "+this.clazz.getSimpleName()+" where id in (";
		StringBuilder builder=new StringBuilder();
		if(ids!=null&&ids.length>0){
			for(Serializable id:ids){				
				builder.append("?").append(",");
			}
			builder.deleteCharAt(builder.length()-1);
			hql=hql+builder.toString()+")";
			Query query=getSession().createQuery(hql);
			for(int i=0;i<ids.length;i++){
				query.setParameter(i,ids[i]);
			}
			query.executeUpdate();
		}
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public List<T> findAll() {
		return getSession().createQuery("from "+this.clazz.getSimpleName()).list();
	}

	public T findById(Long id) {
		return (T)getSession().get(this.clazz, id);
	}



	public List<T> findByIds(Long[] ids) {
		if(ids==null||ids.length==0){
			return Collections.EMPTY_LIST;
		}else{
			return getSession().createQuery("from "+this.clazz.getSimpleName()+" where id in (:ids)").setParameterList("ids", ids).list();
		}
	}


	public PageBean<T> findPageBean(Integer page, Integer pageSize, 
			QueryHelp queryHelp) {

		Query query=getSession().createQuery(queryHelp.buildQuery());
		setParamaters(query, queryHelp.getParams());
		setPageParam(query, page, pageSize);
		
		List<T> entitys=query.list();
		
		query=getSession().createQuery(queryHelp.buildQueryForOrder());
		setParamaters(query, queryHelp.getParams());
		
		Long recordsCount=(Long)query.uniqueResult();
		
		return new PageBean<T>(page, pageSize, entitys, recordsCount);		
		
		
	}

	public PageBean<T> findPageBean(Integer page, Integer pageSize, String hql,
			ArrayList<Object> param) {

		Query query=getSession().createQuery(hql);
		setParamaters(query, param);
		setPageParam(query, page, pageSize);
		
		List<T> entitys=query.list();
		
		StringBuilder hqlString=new StringBuilder();
		hqlString.append("select count(*) ");
		hqlString.append(hql);
		query=getSession().createQuery(hqlString.toString());
		setParamaters(query, param);
		
		Long recordsCount=(Long)query.uniqueResult();
		
		return new PageBean<T>(page, pageSize, entitys, recordsCount);
	}
	
	private void setPageParam(Query query,Integer page,Integer pageSize){
		if(page!=null&&pageSize!=null&&page>0&&pageSize>0){
			query.setFirstResult((page-1)*pageSize);
			query.setMaxResults(pageSize);
		}
	}
	
	private void setParamaters(Query query,ArrayList<Object> param){
		if(param!=null&&param.size()>0){
			
			Object[] params=param.toArray();			
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
			
		}
	}



}
