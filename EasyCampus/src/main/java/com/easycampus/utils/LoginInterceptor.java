/**
 * 
 */
package com.easycampus.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(null == session.getAttribute("user")){
			return true;
		}	
		System.out.println("adsadasdasadas");
		response.sendRedirect("/index.html");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
