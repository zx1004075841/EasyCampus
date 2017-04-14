package com.easycampus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycampus.service.ClubService;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("club")
public class ClubController {

	@Autowired
	private ClubService clubService;
	private ResponseMsg message;
	
	@RequestMapping("jionClub")
	@ResponseBody
	public ResponseMsg jionClub(String userId,String clubId){
		message = new ResponseMsg();
		if(userId.trim().equals("") || clubId.trim().equals("")){
			message.setCode(0);
			message.setMsg("userId 或 clubId 不能为空");
			message.setData(null);
			return message;
		}
		return clubService.jionClub(userId, clubId);
	}
	
	@RequestMapping(value="quitClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg quitClub(String userId, String clubId){
		message = new ResponseMsg();
		if(userId.trim().equals("") || clubId.trim().equals("")){
			message.setCode(0);
			message.setMsg("userId 或 clubId 不能为空");
			message.setData(null);
			return message;
		}
		return clubService.quitClub(userId, clubId);
	}
}
