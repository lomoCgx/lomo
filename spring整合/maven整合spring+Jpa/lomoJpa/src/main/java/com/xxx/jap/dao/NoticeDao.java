package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.Notice;


public interface NoticeDao extends JpaRepository<Notice, Serializable>{

}
