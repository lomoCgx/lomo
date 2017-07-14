package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.Meeting;


public interface MeetingDao extends JpaRepository<Meeting, Serializable>{

}
