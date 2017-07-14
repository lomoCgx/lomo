package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.Schedule;


public interface ScheduleDao extends JpaRepository<Schedule, Serializable>{

}
