package com.neusoft.service.impl;


import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;
import com.neusoft.service.UserService;

public class UserServiceImpl implements UserService{
    private UserDao userDao;  
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User login(User user) {
		
		return userDao.loginUser(user);
	}

}
