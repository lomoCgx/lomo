package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.Worklog;


public interface WorklogDao extends JpaRepository<Worklog, Serializable>{

}
