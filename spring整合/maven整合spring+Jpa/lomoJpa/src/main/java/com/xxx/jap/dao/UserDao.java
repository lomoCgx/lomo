package com.xxx.jap.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.dto.User;

@Repository
public interface UserDao extends JpaRepository<User, Serializable>,JpaSpecificationExecutor<User>{

	
	User findById(Integer id);
	
	@Query(value=" select id,username,password,email from User b where b.email=?1 ")
	List<User> findByema(String email);
	
	@Modifying
	@Query("update User set email = ?1 where id = ?2")
	void update(String age1 , int id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<User> findAll();
	
}
