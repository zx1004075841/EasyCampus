package com.easycampus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.easycampus.model.Club;
import com.easycampus.model.User;
import com.easycampus.service.AdminConsoleService;
import com.easycampus.utils.ResponseMsg;

@Service
public class AdminConsoleServiceImpl implements AdminConsoleService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ResponseMsg addClub(String userId, Club club) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int userType = jdbcTemplate.queryForObject(sql, new Object[]{userId}, int.class);
		if(0 == userType){
			message.setCode(0);
			message.setMsg("user has not auithority to add this club");
			return message;
		}
		sql = "insert club(club_info,club_name,club_id) values(?,?,?)";
		String clubId = UUID.randomUUID().toString().replaceAll("-", "");
		int result = jdbcTemplate.update(sql,club.getClubInfo(),club.getClubName(),clubId);
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
	public ResponseMsg removeClub(String userId, String clubId) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int userType = jdbcTemplate.queryForObject(sql, new Object[]{userId}, int.class);
		if(0 == userType){
			message.setCode(0);
			message.setMsg("user has not auithority to remove this club");
			return message;
		}
		sql = "delete * from clubs where club_id=?";
		int result = jdbcTemplate.update(sql,clubId);
		if(0 == result){
			message.setCode(0);
			message.setMsg("this club is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("remove club");
		return message;
	}

	@Override
	public ResponseMsg showClub() {
		ResponseMsg message = new ResponseMsg();
		String sql = "select * from clubs";
		RowMapper<Club> rowMapper = BeanPropertyRowMapper.newInstance(Club.class);
		List<Club> list = jdbcTemplate.query(sql, rowMapper);
		message.setCode(1);
		message.setMsg("search success");
		message.setData(list);
		return message;
	}

	@Override
	public ResponseMsg editClub(String userId, Club club) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int userType = jdbcTemplate.queryForObject(sql, new Object[]{userId}, int.class);
		if(0 == userType){
			message.setCode(0);
			message.setMsg("user has not auithority to remove this club");
			return message;
		}
		sql = "update clubs set club_info=?,club_name=? where club_id=?";
		int result = jdbcTemplate.update(sql,club.getClubInfo(),club.getClubName(),club.getClubId());
		if(0 == result){
			message.setCode(0);
			message.setMsg("this club is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("edit success");
		return message;
	}

	@Override
	public ResponseMsg addSkillType(String userId, int type) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{userId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql = "insert into skill_type(skill_type) values(?)";
		result = jdbcTemplate.update(sql,type);
		if(0 == result){
			message.setCode(0);
			message.setMsg("skill type is exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("skill type is succeed");
		return message;
	}

	@Override
	public ResponseMsg removeSkillType(String userId, String type) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{userId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql = "delete * from skill_type where skill_type=?";
		result = jdbcTemplate.update(sql,type);
		if(0 == result){
			message.setCode(0);
			message.setMsg("skill type is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("remove succeed");
		return message;
	}

	@Override
	public ResponseMsg showskillType(String userId) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{userId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql = "select skill_type from skill_type";
		List<String> list = jdbcTemplate.query(sql,new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String skill = ""; 
				if(rs.next())
					skill = rs.getString("skill_type");
				return skill;
			}});
		if(list.isEmpty()){
			message.setCode(0);
			message.setMsg("skill type is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("search success");
		message.setData(list);
		return message;
	}

	@Override
	public ResponseMsg editSkillType(String userId, String oldType, String newType) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{userId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql = "update skill_type set skill_type=? where skill_type=?";
		result = jdbcTemplate.update(sql,newType,oldType);
		if(0 == result){
			message.setCode(0);
			message.setMsg("old type is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("edit success");
		return message;
	}

	@Override
	public ResponseMsg addClubUserAuthority(String adminId, String clubUserId, String authority) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{adminId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql = "update club_user set user_authority=? where clubUserId=?";
		result = jdbcTemplate.update(sql,authority,clubUserId);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("add success");
		return message;
	}

	@Override
	public ResponseMsg removeClubUserAuthority(String userId, String clubId, String clubUserId) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{userId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql="delete * from club_user where club_id=? AND user_id=?";
		result = jdbcTemplate.update(sql,clubId,userId);
		if(0 == result){
			message.setCode(0);
			message.setMsg("Authority is not exist");
			return message;
		}
		message.setCode(1);
		message.setMsg("remove success");
		return message;
	}

	@Override
	public ResponseMsg showClubUserAuthority(String userId, String clubId) {
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int result = jdbcTemplate.queryForObject(sql, new Object[]{userId},int.class);
		if(0 == result){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql="select user_authority from club_user where club_id=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{clubId},new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String authority = "";
				if(rs.next()){
					authority = rs.getString("user_authority");
				}
				return authority;
			}});
		if(list.isEmpty()){
			message.setCode(0);
			message.setMsg("authority of this club is empty");
			return message;
		}
		message.setCode(1);
		message.setMsg("query success");
		message.setData(list);
		return message;
	}

	@Override
	public ResponseMsg editClubUserAuthority(String adminId, String userId, String authority) {
		// TODO Auto-generated method stub
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int user_type = jdbcTemplate.queryForObject(sql, new Object[]{adminId},int.class);
		if(0 == user_type){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		sql = "update club set club_authority=? from club where user_id=?";
		int result = jdbcTemplate.update(sql,authority,userId);
		if(0 == result){
			message.setCode(0);
			message.setMsg("can not edit authority");
			return message;
		}
		message.setCode(0);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg addClubUserRole(String clubUserId, String userId, String Role) {
		// TODO Auto-generated method stub
		ResponseMsg message = new ResponseMsg();
		String sql = "select user_type from users where user_id=?";
		int user_type = jdbcTemplate.queryForObject(sql, new Object[]{},int.class);
		if(0 == user_type){
			message.setCode(0);
			message.setMsg("user has not authority to add skill type");
			return message;
		}
		
		return null;
	}

	@Override
	public ResponseMsg showClubUserRole(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg removeClubUserRole(String clubUserId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg login(String userName, String password) {
		ResponseMsg msg = new ResponseMsg();
		String sql = "select * from users where user_name=? and password=?";
		RowMapper<User> bean= BeanPropertyRowMapper.newInstance(User.class);
		List<User> users = this.jdbcTemplate.query(sql, new Object[]{userName,password}, bean);
		User user = null;
		if(users.size() > 0){
			user = users.get(0);
		System.out.println(user.getUserType());
			if(0 == user.getUserType()){
				msg.setCode(0);
				msg.setMsg("用户没有权限");
				msg.setData(user);
				return msg;
			}
			msg.setCode(1);
			msg.setMsg("登陆成功");
			msg.setData(user);
			return msg;
		}else{
			msg.setCode(0);
			msg.setMsg("用户名或密码错误");
			msg.setData(user);
			return msg;
		}
	}

}
