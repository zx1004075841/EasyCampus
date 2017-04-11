package com.easycampus.controller;

import java.nio.file.attribute.UserPrincipalLookupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycampus.service.UserService;
import com.easycampus.utils.ResponseMsg;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	private UserService service;
	public ResponseMsg login(String userName,String password){
		ResponseMsg msg = new ResponseMsg();
		if(userName.trim().equals("") || password.trim().equals("")){
			
			msg.setCode(0);
			msg.setMsg("用户名或密码不能为空");
			return msg;
		}
		return service.login(userName, password);
	}
}
