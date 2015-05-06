package com.mybos.utils;

import java.util.ArrayList;

import com.mybos.dao.base.DaoSupport;
import com.mybos.domain.PageBean;
import com.opensymphony.xwork2.ActionContext;


public class QueryHelp {
	public static Boolean DESC=false;
	public static Boolean ASC=true;
	
	
	private String from;
	private String where="";
	private String order="";
	private ArrayList<Object> params=new ArrayList<Object>();
	public QueryHelp(Class clazz){
		from="from "+clazz.getSimpleName();
	}
	
	public QueryHelp addWhere(String where,Object... params){
		if(this.where.equals("")){
			this.where=" where "+where;
		}else{
			this.where+=" and "+where;
		}
		if(params!=null){
			for(Object param:params){
				this.params.add(param);				
			}
		}
		return this;
	}
	
	public QueryHelp addWhere(Boolean bool,String where,Object... params){
		if(bool){
			addWhere(where, params);
		}
		return this;
	}
	
	public QueryHelp addOrder(String order,Boolean asc){
		if(this.order.equals("")){
			this.order=" order by "+order+" "+(asc?"asc":"desc");
		}else{
			this.order+=" , "+order+" "+(asc?"asc":"desc");
		}
		return this;
	}
	public QueryHelp addOrder(Boolean bool,String order,Boolean asc){
		if(bool){
			addOrder(order, asc);
		}
		return this;
	}
	
	public String buildQueryForOrder(){
		return "select count(*) "+from+where;
	}
	
	public String buildQuery(){
		String result=from+where+order;
		System.out.println(result);
		return result;
	}
	
	public ArrayList<Object> getParams(){
		return this.params;
	}

	public <T> PageBean<T> getPageBean(DaoSupport<T> service,Integer page, Integer pageSize) {
		PageBean<T> pageBean=service.findPageBean(page,pageSize,this);

		return pageBean;
	}
	
}
