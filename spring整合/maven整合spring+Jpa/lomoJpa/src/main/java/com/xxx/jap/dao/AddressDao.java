package com.xxx.jap.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.Address;


public interface AddressDao extends JpaRepository<Address, Serializable>{

}
