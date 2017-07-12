package com.xxx.jap.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dto.User;
import com.xxx.jap.dao.UserDao;
import com.xxx.jap.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    UserDao userDao;
	
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public User save(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	
}
