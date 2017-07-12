package com.xxx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.jap.service.UserService;

@Controller
@RequestMapping(value="/")
public class DemoController {

	@Autowired
    private UserService userService;
	
	@RequestMapping("/")
    @ResponseBody
    public String index(){
        return "index";
    }
	
	@RequestMapping("/findall")
    @ResponseBody
	public Map<String, Object> getUser(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", "success");
        map.put("data", userService.findAll());
        return map;
    }
}
