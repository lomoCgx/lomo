package com.xxx.jap.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.xxx.dto.User;

public interface UserRepositoryCustom {

	@Transactional
	public void delete(int id);
	
	public List<Map<String,Object>> listClassroomDto();
	
	public User findById(int id);
}
