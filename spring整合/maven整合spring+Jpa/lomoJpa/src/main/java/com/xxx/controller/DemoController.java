package com.xxx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.dto.User;
import com.xxx.jap.dao.UserRepositoryCustom;
import com.xxx.jap.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Controller
@RequestMapping(value="/")
public class DemoController {

	@Autowired
    private UserService userService;
	
	@Autowired
	private UserRepositoryCustom userRepositoryCustom;
	
	@RequestMapping("/")
    @ResponseBody
    public String index(){
        return "index";
    }
	
	@Transactional
	@RequestMapping("/findall")
    @ResponseBody
	public Map<String, Object> getUser(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", "success");
        map.put("data", userService.findAll(2,2));
        //System.out.println(userService.findByema("abc@163.com"));
        //System.out.println(userRepositoryCustom.listClassroomDto());
        
        //User user = userService.findById(1);
        //user.setEmail("9@33qq");
        
        //userService.update(user);
        
        System.out.println(userService.findById(1));
		 System.out.println(userService.findById(1));
		 System.out.println("===============================================================================");
		 userService.findAll();
		 userService.findAll();
		 userService.findAll();
        
        return map;
    }
}
