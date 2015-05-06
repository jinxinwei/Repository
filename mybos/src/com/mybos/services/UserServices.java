package com.mybos.services;

import com.mybos.dao.base.DaoSupport;
import com.mybos.domain.User;

public interface UserServices extends DaoSupport<User> {
	public User login(User user);
	public void editPassword(User user);
}
