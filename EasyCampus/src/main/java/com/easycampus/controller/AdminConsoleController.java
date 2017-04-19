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

import com.easycampus.model.Club;
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
	public ResponseMsg removeClub(String userId,String clubId){
		InputValidation inputValidation = new InputValidation();
		ResponseMsg message = inputValidation.validate(userId,clubId);
		if(0 == message.getCode()){
			
		}
		return null;
	}
}
