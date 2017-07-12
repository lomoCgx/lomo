package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.User;

public interface UserDao extends JpaRepository<User, Serializable>{

	User findById(Integer id);
}
