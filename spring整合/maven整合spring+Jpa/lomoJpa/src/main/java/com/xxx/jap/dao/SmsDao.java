package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.Sms;


public interface SmsDao extends JpaRepository<Sms, Serializable>{

}
