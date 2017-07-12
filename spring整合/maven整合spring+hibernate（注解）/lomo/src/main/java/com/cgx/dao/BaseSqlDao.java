package com.cgx.dao;

import java.util.List;
import java.util.Map;

public interface BaseSqlDao {

	public List<Map<String,Object>> queryForList(String sql);
	
	public Object queryForOne(String sql) throws Exception;
	
	public Object queryForOneByParams(String sql, Object[] params) throws Exception;
}
