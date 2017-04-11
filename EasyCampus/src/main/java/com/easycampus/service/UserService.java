package com.easycampus.service;

import com.easycampus.utils.ResponseMsg;

/**
 * 
 * @author zhangxing
 *这个类主要定义了用户的一些行为
 */
public interface UserService {
	
	/**
	 * 这个方法主要实现用户的登陆
	 * @param userName		用户名
	 * @param password		密码
	 * @return				返回的是用户的登陆结果
	 */
	public ResponseMsg login(String userName,String password);
	/**
	 * 这个方法主要实现的市用户的找回密码功能
	 * @param userName		用户名
	 * @param email			用户注册的email
	 * @return				返回找回密码的操作的结果
	 */
	public ResponseMsg findBackPassword(String userName,String email);
	/**
	 * 这个方法主要实现的是用户的注册功能
	 * @param userName 
	 * @param password
	 * @param email
	 * @param name
	 * @return
	 */
	public ResponseMsg register(String userName,String password,String email,String name,String userId);
}
