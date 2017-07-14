package com.xxx.jap.service.impl;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.dto.User;
import com.xxx.jap.dao.UserDao;
import com.xxx.jap.dao.UserRepositoryCustom;
import com.xxx.jap.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class UserServiceImpl implements UserService{

	@Autowired
    UserDao userDao;
	
	@Autowired
	UserRepositoryCustom urc;
	
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Override
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		/*User user1 = this.findById(1);
        user1.setEmail("922222222222223qq");
        this.update(user);
		userDao.save(user);
		userDao.save(user);
		int n = 1/0;*/
		
		return userDao.save(user);
	}

	public void update(User user){
		userDao.update(user.getEmail(), user.getId());
	}
	
	@Override
	public Page<User> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		 Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		 /*System.out.println(this.findAll());
		 System.out.println(this.findAll());
		 System.out.println(userDao.fi);
		 System.out.println(userDao.findById(1));*/
		return userDao.findAll(pageable);
	}
	
	@Override
	public List<User> findByema(String email){
		return userDao.findByema(email);
	}
}
