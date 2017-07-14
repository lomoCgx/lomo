package com.xxx.jap.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
implements BaseRepository<T,ID>{

	private final EntityManager entityManager;
	
	@Autowired
    @PersistenceContext
    private EntityManager em;
	
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
		this.entityManager = em;
	}

	@Override
	public List<Object[]> listBySQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map<String,Object>> queryListBySQL(String sql) {
		
		if(sql==null)
			return new ArrayList();
		
		Session session = em.unwrap(Session.class);
		List<Map<String,Object>> list = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		//List<Map<String,Object>> list = em.createNativeQuery("select id,username,password from user",java.util.Map.class).getResultList();
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map<String,Object>> queryListBySQL(String sql,Object[] args) {
		
		if(sql==null)
			return new ArrayList();
		
		
		Session session = em.unwrap(Session.class);
		SQLQuery query = session.createSQLQuery(sql);
		
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		
		List<Map<String,Object>> list = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		
		return list;
	}
	
	@Override
	public void updateBySql(String sql, Object... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByHql(String hql, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
