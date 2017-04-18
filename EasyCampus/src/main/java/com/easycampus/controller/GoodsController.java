package com.easycampus.controller;

import java.util.Iterator;
import java.util.List;

import javax.mail.MessageAware;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycampus.model.Goods;
import com.easycampus.service.GoodService;
import com.easycampus.utils.InputValidation;
import com.easycampus.utils.ResponseMsg;
import com.sun.mail.handlers.message_rfc822;

@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodService goodsServiceImpl;
	
	@RequestMapping(value="showAllGoods",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg showAllGoods(){
		return goodsServiceImpl.showAllGoods();
	}
	
	@RequestMapping(value="showAssignGoods",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg showAssignGoods(String goodsId){
		ResponseMsg message = new ResponseMsg();
		InputValidation inputValidation = new InputValidation();
		message = inputValidation.validate(goodsId);
		if(0 == message.getCode()){
			message.setMsg("faild");
			return message;
		}
		return goodsServiceImpl.showAssignGoods(goodsId);
	}
	
	@RequestMapping(value="addGoods",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg addGoods(@Valid String userId,Goods goods,BindingResult bind){
		ResponseMsg message = new ResponseMsg();
		List<ObjectError> list= bind.getAllErrors();
		if(list.size() > 0){
			String error = "";
			for (int i = 0; i < list.size(); i++) {
				error += list.get(i);
			}
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		return goodsServiceImpl.addGoods(userId, goods);
	}
	
	@RequestMapping(value="removeGoods",method=RequestMethod.POST)
	@ResponseBody
	public ResponseMsg removeGoods(String userId,String goodsId){
		ResponseMsg message = new ResponseMsg();
		InputValidation input = new InputValidation();
		message = input.validate(userId,goodsId);
		if(0 == message.getCode()){
			message.setMsg("faild");
			return message;
		}
		return goodsServiceImpl.removeGoods(userId, goodsId);
	}
}
