package com.easycampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycampus.service.ClubService;
import com.easycampus.utils.ResponseMsg;

@Controller
@RequestMapping("club")
public class ClubController {

	@Autowired
	private ClubService clubService;
	
	@RequestMapping()
	public ResponseMsg jionClub(String userId,String clubId){
		
		return null;
	}
}
