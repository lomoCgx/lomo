package com.cgx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.cgx.dao.BaseSqlDao;
import com.cgx.service.TreeService;

@Service
public class ZtreeServiceImpl implements TreeService{

	@Resource
	private BaseSqlDao baseDao;
	
	@Override
	public List<Map<String, Object>> findOrg(String code) {
		
		String sql = "";
		if(StringUtils.isBlank(code)){
			sql = " select id,code,name_cn from bic_base_org where org_level = '01' ORDER BY CODE ";
		}else{
			sql = " select id,code,name_cn from bic_base_org where parent_org_code = '"+code+"' ORDER BY CODE ";
		}
		
		String sql1 = "select id,code from bic_base_org where org_level = ? ";
		try {
			System.out.println(baseDao.queryForOneByParams(sql1,new Object[]{"01"}));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return baseDao.queryForList(sql);
	}

	
}
