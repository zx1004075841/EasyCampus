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

import com.easycampus.model.Skill;
import com.easycampus.service.ExchangeSkillService;
import com.easycampus.utils.InputValidation;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("skill")
public class ExchangeSkillController {

	@Autowired
	private ExchangeSkillService exchangeSkillService;
	
	@RequestMapping(value="addSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg addSkill(String userId,@Valid @ModelAttribute("skill") Skill skill,BindingResult bindingResult){	
		InputValidation validation = new InputValidation();
		ResponseMsg message = validation.validate(userId);
		if(1 == message.getCode()){
			List<ObjectError> list= bindingResult.getAllErrors();
			if(list.isEmpty()){
				return exchangeSkillService.addSkill(userId, skill);
			}
			message.setCode(0);
			String e = "";
			for (int i = 0; i < list.size(); i++) {
				ObjectError error= list.get(i);
				e += error.getDefaultMessage();
			}
			message.setMsg(e);
			return message;
		}
		return message;
	}
	
	@RequestMapping(value="removeSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg removeSkill(String userId,String skillId){
		InputValidation validate = new InputValidation();
		ResponseMsg message = validate.validate(userId,skillId);
		if(0 == message.getCode()){
			return message;
		}
		return exchangeSkillService.removeSkill(userId, skillId);
	}
	
	@RequestMapping(value="editSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg editSkill(String userId,@Valid @ModelAttribute("skill") Skill skill,BindingResult bindingResult){
		InputValidation validate = new InputValidation();
		ResponseMsg msg = validate.validate(userId);
		if(1 == msg.getCode()){
			List<ObjectError> errors= bindingResult.getAllErrors();
			if(errors.isEmpty()){
				return exchangeSkillService.editSkill(userId, skill);
			}
			String str = "";
			for(int i = 0; i < errors.size(); i++){
				str += errors.get(i).getDefaultMessage();
			}
			msg.setMsg(str);
			msg.setCode(0);
			return msg;
		}
		return msg;
	}
	
	@RequestMapping(value="discuss",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg discussSkill(String skillId,String context,String userId){
		InputValidation validation = new InputValidation();
		ResponseMsg message = validation.validate(skillId,context,userId);
		if(0 == message.getCode()){
			return message;
		}
		return exchangeSkillService.discussSkill(skillId, context, userId);
	}
	
	@RequestMapping(value="mySkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg mySkill(String userId){
		InputValidation validation = new InputValidation();
		ResponseMsg message = validation.validate(userId);
		if(0 == message.getCode()){
			return message;
		}
		return exchangeSkillService.mySkill(userId);
	}
	
	@RequestMapping(value="focusSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg focusSkill(String userId,String skillId){
		InputValidation validation = new InputValidation();
		ResponseMsg message = validation.validate(userId,skillId);
		if(0 == message.getCode()){
			return message;
		}
		return exchangeSkillService.focusSkill(userId, skillId);
	}
	
}
