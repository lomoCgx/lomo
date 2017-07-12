package com.cgx.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgx.dto.Notice;
import com.cgx.dto.User;
import com.cgx.service.NoticeService;
import com.cgx.service.UserService;

@Controller //��������һ��������
//@RequestMapping(value="/lomo") //RequestMapping����ƥ���·��  �����������ϣ���ʾ�Ǹ�·����
public class LoginController {
	
	@SuppressWarnings("unused")
	@Autowired   //ע�⣬ͨ��ע�ⷽʽ��ʵ����UserService�ࡣ
	private UserService userService;
	
	@Autowired   //ע�⣬ͨ��ע�ⷽʽ��ʵ����UserService�ࡣ
	private NoticeService noticeService;
	
	@RequestMapping("/index") 
	public String index() {
		/*System.out.println(noticeService.findAllList());
		List<Notice> list = noticeService.findAllList();
		for (int i = 0; i < list.size(); i++) {
			Notice no = list.get(i);
			System.out.println(no.toString());
		}*/
		System.out.println(noticeService.findAllList());
		System.out.println(noticeService.findNoticeById(1).toString());
		return "login";
	}
	
	@RequestMapping("/login") 
	public String login(String username,String password,ModelMap map,HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(DigestUtils.md5Hex(password));
		
		User loginUser = userService.findUserByUsernameAndPassword(user);
		Cookie cookies[] = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("cookie="+cookie.getName()+" : "+cookie.getValue()+" : "+cookie.getPath());
		}
		
		if(loginUser==null){
			map.addAttribute("msgerr", "登入失败");
			return "login";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", loginUser);
		session.setAttribute("username", loginUser.getUsername());
		
		return "pageJump";
	}
	
	@RequestMapping("/testInterceptor") 
	public String testInterceptor() {
		
		
		return "common/error";
	}
	
	@RequestMapping("/main") 
	public String main() {
				
		return "main";
	}
	
	@RequestMapping("/register") 
	public String register(User user,ModelMap map) {

		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		
		if(userService.findUserByUsernameAndPassword(user)==null){
			userService.saveUser(user);
			map.addAttribute("msg", "注册成功！");
		}else{
			map.addAttribute("msg", "注册失败！");
		}
		
		return "login";
	}
	
	
	//@ResponseBody
	@RequestMapping("/isExistUsername") 
	public void isExistUsername(HttpServletRequest request, HttpServletResponse response,String username) throws Exception { 
		response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        if(userService.findUserIsExites(username)){
        	out.print("false");
        }else{
        	out.print("true");
        }
        
        //out.print("false");
        out.flush();
        out.close();
		 // ��Ϊֱ��������ݶ�������jsp,��˷���null. 
		} 
}
