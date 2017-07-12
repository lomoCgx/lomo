package com.cgx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cgx.dao.BaseDao;
import com.cgx.dto.User;
import com.cgx.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private BaseDao<User> baseDao;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		baseDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		baseDao.update(user);
	}

	@Override
	public User findUserById(int id) {
		return baseDao.get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		baseDao.delete(user);
	}

	@Override
	public List<User> findAllList() {
		return baseDao.find("from User");
	}

	
	
	@Override
	public User findUserByUsernameAndPassword(User user) {
		return baseDao.get("from User u where u.username=? and u.password=?", new Object[]{user.getUsername(),user.getPassword()});
	}

	@Override
	public boolean findUserIsExites(String username) {
		// TODO Auto-generated method stub
		
		/*String sql = "select id from users where 1=1 and username = '"+username+"' ";
		
		
		
		if(users!=null && users.size() ==1){
			return true;
		}*/
		User user = baseDao.get(" from User u where u.username= ? ", new Object[]{username});
		
		System.out.println(user);
		
		if(user!=null){
			return true;
		}
		
		return false;
		
	}

}
