package com.xxx.jap.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.dto.User;

@Transactional(readOnly = true)
@Service
public class UserRepositoryImpl implements UserRepositoryCustom{

	@Autowired
    @PersistenceContext
    private EntityManager em;

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		
	}

	
	
	
	
	
	@Override
	public List<Map<String,Object>> listClassroomDto() {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		String sqlStr = "select id,username,password from user";
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list = session.createSQLQuery(sqlStr).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		//List<Map<String,Object>> list = em.createNativeQuery("select id,username,password from user",java.util.Map.class).getResultList();
		return list;
	}






	@Override
	public User findById(int id) {
		em.find(User.class, id);
		System.out.println("111111111111111111111111111");
		return em.find(User.class, id);
	}	
}
