package com.easycampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycampus.service.ExchangeSkillService;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("skill")
public class ExchangeSkillController {

	@Autowired
	private ExchangeSkillService exchangeSkillService;
	
	@RequestMapping(value="addSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg addSkill(){	
		ResponseMsg message = new ResponseMsg();
	}
	
	@RequestMapping(value="removeSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg removeSkill(){
		ResponseMsg message = new ResponseMsg();
	}
	
	@RequestMapping(value="editSkill",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg editSkill(){
		
	}
	
	@RequestMapping(value="discuss",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg discussSkill(){
		
	}
}
