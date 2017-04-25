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
import org.springframework.web.servlet.ModelAndView;

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
			return message;
		}
		
		return this.removeClub(userId, clubId);
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
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(String userName,String password){
		ModelAndView modelAndView = new ModelAndView();
		InputValidation inputValidation = new InputValidation();
		ResponseMsg msg = new ResponseMsg();
		msg = inputValidation.validate(userName,password);
		if(0 == msg.getCode()){
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("redirect:/index.html");
			return modelAndView;
		}
		msg = adminConsoleService.login(userName, password);
		System.out.println(msg.getCode());
		if(0 == msg.getCode()){
			msg.setMsg("userName or password is not worth");
			modelAndView.setViewName("redirect:/index.html");
			modelAndView.addObject("msg",msg);
			return modelAndView;
		}
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
}
