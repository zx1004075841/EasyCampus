package com.easycampus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.easycampus.model.Skill;
import com.easycampus.service.ExchangeSkillService;
import com.easycampus.utils.ResponseMsg;
import com.sun.mail.handlers.message_rfc822;

@Service
public class ExchangeSkillServiceImpl implements ExchangeSkillService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ResponseMsg mySkill(String userId) {
		String sql = "select * from skills where user_id=?";
		ResponseMsg message = new ResponseMsg();
		List<Skill> list = null;
		try{
			list= jdbcTemplate.query(sql, new Object[]{userId},new RowMapper<Skill>(){
			@Override
			public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Skill skill = new Skill();
				while(rs.next()){
					skill.setSkillId(rs.getString("skill_id"));
					skill.setSkillInfo(rs.getString("skill_info"));
					skill.setSkillName(rs.getString("skill_name"));
					skill.setSkillType(rs.getString("skill_type"));
					skill.setUserId(rs.getString("user_id"));
				}
				return skill;
			}});
		}catch(Exception e){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		message.setData(new HashMap<String,List<Skill>>().put("skills", list));
		return message;
	}

	@Override
	public ResponseMsg addSkill(String userId, Skill skill) {
		String sql = "insert into skills(skill_name,skill_type,skill_info,skill_id,user_id) values()";
		ResponseMsg message = new ResponseMsg();
		int result = jdbcTemplate.update(sql, skill.getSkillName(),skill.getSkillType(),skill.getSkillInfo(),
				skill.getSkillId(),skill.getUserId());
		if(result == 0){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg removeSkill(String userId, String skillId) {
		ResponseMsg message = new ResponseMsg();
		String sql = "delete * from skills where user_id=? AND skill_id=?";
		int result = jdbcTemplate.update(sql, userId,skillId);
		if(0 == result){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg editSkill(String userId, Skill skill) {
		ResponseMsg message = new ResponseMsg();
		String sql = "update skill set skill_name=?,skill_info=?,skill_type=? from skills where skill_id=? AND skill_id=?";
		int result = jdbcTemplate.update(sql,skill.getSkillName(),skill.getSkillInfo(),skill.getSkillType(),skill.getSkillId(),skill.getUserId());
		if(0 == result){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg discussSkill(String skillId,String context,String userId) {
		ResponseMsg message = new ResponseMsg();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String sql = "insert skill_content(skill_id,content_context,userId,content_time) values(?,?,?,?)";
		int result = jdbcTemplate.update(sql,skillId,context,userId,dateFormat.format(System.currentTimeMillis()));
		if(0 == result){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg focusSkill(String userId, String skillId) {
		ResponseMsg message = new ResponseMsg();
		int focused = 1;
		String sql = "update skill_content set user_focus=? where userId=? AND skillId=?";
		int result = jdbcTemplate.update(sql,focused,userId,skillId);
		if(0 == result){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg addSkillType(String userId, String skillType) {
		ResponseMsg message = new ResponseMsg();
		String sql = "insert skill_type(skill_type_name) values(?)";
		int result = jdbcTemplate.update(sql,skillType);
		if(0 == result){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg removeSkillType(String userId, String skillType) {
		ResponseMsg message = new ResponseMsg();
		String sql = "delete * from skill_type where skill_type_name=?";
		int result = jdbcTemplate.update(sql,skillType);
		if(0 == result){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	
}
