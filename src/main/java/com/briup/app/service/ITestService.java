package com.briup.app.service;

import java.util.List;

import com.briup.app.bean.User;

public interface ITestService {
	void saveOrUpdate(User user);
	List<User> findAll();
}
