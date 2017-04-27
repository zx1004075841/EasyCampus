package com.easycampus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.easycampus.model.Club;
import com.easycampus.model.User;
import com.easycampus.service.AdminConsoleService;
import com.easycampus.utils.InputValidation;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("admin")
public class AdminConsoleController {

	@Autowired
	private AdminConsoleService adminConsoleService;
	
	@RequestMapping(value="addClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg addClub(String userId,@Valid @ModelAttribute("club") Club club,BindingResult bindingResult){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId);
		if(0 == message.getCode())
			return message;
		List<ObjectError> list = bindingResult.getAllErrors();
		if(list.isEmpty())
			return adminConsoleService.addClub(userId, club);
		String error = "";
		for(int i = 0; i < list.size(); i++){
			error += list.get(i);
		}
		message.setCode(0);
		message.setMsg(error);
		return message;
	}
	
	@RequestMapping(value="removeClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg removeClub(String userId,String clubId,User user){
		InputValidation inputValidation = new InputValidation();
		ResponseMsg message = inputValidation.validate(userId,clubId);
		if(0 == message.getCode()){
			return message;
		}
		
		return this.removeClub(userId, clubId,user);
	}
	
	@RequestMapping(value="showClub",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg showClub(){
		return this.showClub();
	}
	
	@RequestMapping(value="editClub",method=RequestMethod.POST)
	public ResponseMsg editClub(String userId,@Valid @ModelAttribute("club") Club club,BindingResult bindingResult){
		InputValidation inputValidation = new InputValidation();
		ResponseMsg message = inputValidation.validate(userId);
		if(0 == message.getCode()){
			return message;
		}
		List<ObjectError> list = bindingResult.getAllErrors();
		if(list.isEmpty())
			return this.adminConsoleService.editClub(userId, club);
		String errors = "";
		for(int i = 0; i < list.size(); i++){
			errors += list.get(i);
		}
		message.setCode(0);
		message.setMsg(errors);
		return message;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg login(String userName,String password){
		InputValidation inputValidation = new InputValidation();
		ResponseMsg msg = inputValidation.validate(userName,password);
		if(0 == msg.getCode()){
			msg.setMsg("用户名和密码不能为空");
			return msg;
		}
		return this.adminConsoleService.login(userName, password);
	}
	
}
