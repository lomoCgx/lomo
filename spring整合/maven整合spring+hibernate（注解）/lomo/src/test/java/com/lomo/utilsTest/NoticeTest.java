package com.lomo.utilsTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgx.service.UserService;

public class NoticeTest {

	ClassPathXmlApplicationContext context = null;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	@Test
	public void test(){
		context.start();  
		  
		UserService us = (UserService) context.getBean("userService");  
        System.out.println(us.findAllList());
	}
}
