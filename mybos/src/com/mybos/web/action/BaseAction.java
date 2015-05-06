package com.mybos.web.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.mybos.services.UserServices;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	protected Integer page=1;
	protected Integer pageSize=10;
	protected T entity;
	public BaseAction(){
		try{
		ParameterizedType types=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class<T> clazz=(Class<T>)types.getActualTypeArguments()[0];
		this.entity=clazz.newInstance();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public T getModel() {
		return entity;
	}
	
	@Resource
	protected UserServices userServices;
	

}
