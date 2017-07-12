package com.cgx.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgx.service.TreeService;

@Controller
@RequestMapping(value="/tree")
public class ZtreeController {

	@SuppressWarnings("unused")
	@Autowired   //ע�⣬ͨ��ע�ⷽʽ��ʵ����UserService�ࡣ
	private TreeService treeService;
	
	@RequestMapping(value="/show")
	public String show(){
		
		List<Map<String, Object>> list = treeService.findOrg(null);
		System.out.println(list.size());
		//System.out.println(list);
		System.out.println("11111111111111111111");
		
		return "tree";
	}
}
