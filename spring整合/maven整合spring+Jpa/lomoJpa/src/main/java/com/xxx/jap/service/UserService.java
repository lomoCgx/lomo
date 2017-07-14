package com.xxx.jap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xxx.dto.User;

public interface UserService {

	User findById(Integer id);
    User save(User user);
    void update(User user);
    Page<User> findAll(Integer page,Integer size);
    List<User> findAll();
    List<User> findByema(String email);
}
