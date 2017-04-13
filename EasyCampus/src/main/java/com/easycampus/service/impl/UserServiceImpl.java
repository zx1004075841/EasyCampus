package com.easycampus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.easycampus.model.User;
import com.easycampus.service.UserService;
import com.easycampus.utils.ResponseMsg;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private ResponseMsg msg;
	@Override
	public ResponseMsg login(String userName, String password) {
		// TODO Auto-generated method stub
		msg = new ResponseMsg();
		String sql = "select * from users where user_name=? AND password=?";
		User user = null; 
		try{
			user = jdbcTemplate.queryForObject(sql, new Object[]{userName,password},new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet rs, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					User user = null;
					if(rs.next()){
						user = new User();
						user.setActivityStatus(rs.getInt("activity_status"));
						user.setBriefIntroduction(rs.getString("brief_introduction"));
						user.setEmail(rs.getString("email"));
						user.setName(rs.getString("name"));
						user.setUserType(rs.getInt("user_type"));
					}
					return user;
				}});
		}catch(Exception e){
			msg.setMsg("用户名或密码不正确");
			msg.setCode(0);
			return msg;
		}
		
		msg.setCode(1);
		msg.setMsg("登陆成功");
		msg.setData(user);
		return msg;
	}

	@Override
	public ResponseMsg findBackPassword(String userName, String email) {
		// TODO Auto-generated method stub
		msg = new ResponseMsg();
		String userId = "";
		String sql = "select user_id from users where user_name=? AND email=?";
		try{
			userId = jdbcTemplate.queryForObject(sql, new Object[]{userName,email},new RowMapper<String>(){
	
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					if(rs.next())
						return rs.getString("user_id");
					return "";
				}});
		}catch(Exception exception){
			msg.setCode(0);
			msg.setMsg("用户名或密码不正确");
			return msg;
		}
		
		msg.setCode(1);
		msg.setData(userId);
		msg.setMsg("重置密码的链接已经发到您的邮箱");
		return msg;
	}
	@Override
	public ResponseMsg register(String userName, String password, String email, String name, String userId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResponseMsg isRegister(String userName) {
		// TODO Auto-generated method stub
		msg = new ResponseMsg();
		String sql = "select count(*) from users where user_name=?";
		int rowNum = jdbcTemplate.queryForObject(sql, new Object[]{userName},Integer.class);
		if(rowNum == 0){
			msg.setCode(1);
			msg.setMsg("此账号可以使用");
		}else{
			msg.setCode(0);
			msg.setMsg("此账号已经被注册");
		}
		return msg;
	}

}
