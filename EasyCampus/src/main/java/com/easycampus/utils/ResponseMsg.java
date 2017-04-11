package com.easycampus.utils;

/**
 * 
 * @author zhangxing
 */
public class ResponseMsg {

	private int code;			//返回结果的状态：0 失败，1成功
	private String msg;				//返回的信息
	private Object data;			//返回的数据
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
