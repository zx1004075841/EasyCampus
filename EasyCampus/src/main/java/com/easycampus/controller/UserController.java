package com.easycampus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycampus.service.UserService;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg login(String userName,String password){
		ResponseMsg msg = new ResponseMsg();
		if(userName == null || password == null){
			msg.setCode(0); 
			msg.setMsg("用户名或密码不能为null");
			return msg;
		}
		if(userName.trim().equals("") || password.trim().equals("")){				
			msg.setCode(0);
			msg.setMsg("用户名或密码不能为空");
			return msg;
		}
		return userService.login(userName, password);
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg register(String userName,String password,String email,String briefIntroduction,String name,String userId){
		ResponseMsg msg = new ResponseMsg();
		if(userName.trim().equals("") || password.trim().equals("") || name.trim().equals("")
				|| email.trim().equals("") || briefIntroduction.trim().equals("") || userId.trim().equals("")){
			msg.setCode(0);
			msg.setMsg("输入不能为空");
			return msg;
		}
		if(userName.trim().equals("null") || password.trim().equals("null") || name.trim().equals("null")
				|| email.trim().equals("null") || briefIntroduction.trim().equals("null") || userId.trim().equals("null")){
			msg.setCode(0);
			msg.setMsg("输入不能为null");
			return msg;
		}
		return userService.register(userName, password, email, name, userId);
	}
	
	@RequestMapping(value="isRegister",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg isRegister(String userName){
		return userService.isRegister(userName);
	}
	
	@RequestMapping(value="findBackPassword",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg findBackPassword(String userName,String email){
		return userService.findBackPassword(userName, email); 
	}
}
