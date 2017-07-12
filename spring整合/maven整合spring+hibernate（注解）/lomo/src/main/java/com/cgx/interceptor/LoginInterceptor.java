package com.cgx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 * ��¼��֤�������� 
 */  
public class LoginInterceptor implements HandlerInterceptor{

	/** 
     * Handlerִ�����֮������������ 
     */  
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("1111");
	}
	
	/** 
     * Handlerִ��֮��ModelAndView����֮ǰ����������� 
     */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("22222");
	}

	/** 
     * Handlerִ��֮ǰ����������� 
     */ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ�����URL
		//System.out.println("3333");
		String url = request.getRequestURI();
		//URL:login.jsp�ǹ�����;���demo�ǳ���login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ��� 
		//System.out.println("url="+url);
		
		if(url.indexOf("index.action")>=0){  
            return true;  
        }
		
		if(url.indexOf("login.action")>=0){  
            return true;  
        }
		
		if(url.indexOf("isExistUsername.action")>=0){
			return true;
		}
		
		if(url.indexOf("register.action")>=0){
			return true;
		}
		
		//��ȡSession 
		HttpSession session = request.getSession();  
        String username = (String)session.getAttribute("username"); 
        
        if(username != null){  
            return true;  
        } 
		
      //�����������ģ���ת����¼����  
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
		return false;
	}

}
