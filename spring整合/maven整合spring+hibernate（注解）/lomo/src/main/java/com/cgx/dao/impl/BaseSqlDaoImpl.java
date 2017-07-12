package com.cgx.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgx.dao.BaseSqlDao;

@Repository
public class BaseSqlDaoImpl implements BaseSqlDao {

	private SessionFactory sessionFactory;

	private Session session = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unused")
	private Session openSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unused")
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryForList(String sql) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		session = this.openSession();

		list = (List<Map<String, Object>>) session.createSQLQuery(sql)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

		if (session != null) {
			session.close();
		}

		return list;
	}

	/**
	 * 语句查询
	 */
	public Object queryForOne(String sql) throws Exception {

		session = this.openSession();
		Object result = null;

		try {
			@SuppressWarnings("unchecked")
			SQLQuery query = session.createSQLQuery(sql);
			
			result =  query.uniqueResult();
		} catch (Exception e) {

			throw e;

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}
/**
 * 获得对象
 * @param sql
 * @param obj
 * @return
 * @throws Exception
 */
	public Object queryForOneObject(String sql,Object obj) throws Exception {

		session = this.openSession();
		Object result = null;

		try {
			@SuppressWarnings("unchecked")
			SQLQuery query = session.createSQLQuery(sql);
			
			result =  query.addEntity(obj.getClass()).uniqueResult();
		} catch (Exception e) {

			throw e;

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}
	
	/**
	 * 语句查询 问好语句查询？
	 */
	public Object queryForOneByParams(String sql, Object[] params) throws Exception {

		session = this.openSession();
		Object result = null;

		try {
			@SuppressWarnings("unchecked")
			SQLQuery query = session.createSQLQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}

			// System.out.println(query.uniqueResult());
			result = query.uniqueResult();
		} catch (Exception e) {

			throw e;

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}
	/**
	 * 获得对象
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
		public Object queryForOneObjectByParams(String sql,Object[] params,Object obj) throws Exception {

			session = this.openSession();
			Object result = null;

			try {
				@SuppressWarnings("unchecked")
				SQLQuery query = session.createSQLQuery(sql);
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
				result =  query.addEntity(obj.getClass()).uniqueResult();
			} catch (Exception e) {

				throw e;

			} finally {
				if (session != null) {
					session.close();
				}
			}

			return result;
		}
}
