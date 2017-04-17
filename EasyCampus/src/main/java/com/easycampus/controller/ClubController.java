package com.easycampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycampus.service.ClubService;
import com.easycampus.utils.InputValidation;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("club")
public class ClubController {

	@Autowired
	private ClubService clubService;
	
	@RequestMapping(value="jionClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg jionClub(String userId,String clubId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId,clubId);
		if(message.getCode() == 0)
			return message;
		return clubService.jionClub(userId, clubId);
	}
	
	@RequestMapping(value="quitClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg quitClub(String userId, String clubId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId,clubId);
		if(message.getCode() == 0)
			return message;
		return clubService.quitClub(userId, clubId);
	}
	
	@RequestMapping(value="jionActivity",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg jionActivity(String userId, String clubId, String activityId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId,clubId,activityId);
		if(message.getCode() == 0)
			return message;
		return clubService.jionActivity(userId, clubId, activityId);
	}
	
	@RequestMapping(value="canelActivity",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg cancelActivity(String userId, String clubId, String activityId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId,clubId,activityId);
		if(message.getCode() == 0)
			return message;
		return clubService.cancelActivity(userId, clubId, activityId);
	}
	
	@RequestMapping(value="chooseClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg chooseClub(){
		return clubService.chooseClub();
	}
	
	@RequestMapping(value="intro_club",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg intro_club(String clubId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(clubId);
		if(message.getCode() == 0)
			return message;
		return clubService.intro_club(clubId);
	}
	
	@RequestMapping(value="myActivities",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg myActivities(String userId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId);
		if(message.getCode() == 0)
			return message;
		return clubService.myActivities(userId);
	}
	
	@RequestMapping(value="roleControl",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg roleControl(String adminId, String userId, String clubId, String userRole){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(adminId,userId,clubId,userRole);
		if(message.getCode() == 0)
			return message;
		return clubService.roleControl(adminId, userId, clubId, userRole);
	}
	
	@RequestMapping(value="authorityControl",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg authorityControl(String adminId, String clubId, String userId, String authority){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(adminId,userId,clubId,authority);
		if(message.getCode() == 0)
			return message;
		return clubService.authorityControl(adminId, clubId, userId, new Integer(authority));
	}
	
	@RequestMapping(value="showUserByAuthority")
	@ResponseBody
	public ResponseMsg showUserByAuthority(String userId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId);
		if(message.getCode() == 0)
			return message;
		return clubService.showUserByAuthority(userId);
	}
}
