package com.easycampus.utils;

import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;

import com.sun.tools.classfile.StackMapTable_attribute.verification_type_info;

public class InputValidation {

	/**
	 * this mehtod is used to validate value of the input
	 * @param param input field
	 * @return 
	 */
	public ResponseMsg validate(String ...param){
		ResponseMsg message = new ResponseMsg();
		boolean flag = false;
		for (String object : param) {
			if(null == object)
				flag = true;
		}
		
		if(flag){
			message.setCode(0);
			message.setMsg("输入不能为null");
			return message;
		}
		for (String object : param) {
			if("".equals(object.trim())){
				flag = true;
			}
		}
		if(flag){
			message.setCode(0);
			message.setMsg("输入不能为空字符串");
			return message;
		}
		message.setCode(1);
		return message;
	}
	
	public ResponseMsg validateObject(Object object){
		return null;
	}
}
