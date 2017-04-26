/**
 * 
 */
package com.easycampus.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.easycampus.model.User;

/**
 * @author zhangxing
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private StringBuilder notFilter;
	private Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("this is intercepted");
		HttpSession session = request.getSession();
		if(null == session.getAttribute("user")){
			request.setAttribute("msg", "你还没有登录");
			logger.error("user is not logined");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
