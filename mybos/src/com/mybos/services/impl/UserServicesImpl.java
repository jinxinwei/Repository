package com.mybos.services.impl;

import org.springframework.stereotype.Service;

import com.mybos.dao.base.DaoSupportImpl;
import com.mybos.domain.User;
import com.mybos.services.UserServices;
import com.mybos.utils.MD5;

@Service
public class UserServicesImpl extends DaoSupportImpl<User> implements UserServices{

	@Override
	public User login(User user) {
		user=(User)getSession().createQuery("from User where name=? and password=?").setParameter(0,user.getName()).setParameter(1,MD5.MD5Encode(user.getPassword())).uniqueResult();
		return user;
	}

	@Override
	public void editPassword(User user) {
		this.findById(user.getId()).setPassword(user.getPassword());
	}
	
	

}
