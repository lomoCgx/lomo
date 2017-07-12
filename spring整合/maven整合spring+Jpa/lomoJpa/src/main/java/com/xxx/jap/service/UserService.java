package com.xxx.jap.service;

import java.util.List;

import com.xxx.dto.User;

public interface UserService {

	User findById(Integer id);
    User save(String name);
    List<User> findAll();
}
