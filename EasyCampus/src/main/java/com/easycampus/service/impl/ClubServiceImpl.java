package com.easycampus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.easycampus.model.Activity;
import com.easycampus.model.Club;
import com.easycampus.model.Club_User;
import com.easycampus.service.ClubService;
import com.easycampus.utils.ResponseMsg;

@Service
public class ClubServiceImpl implements ClubService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private ResponseMsg message;
	@Override
	public ResponseMsg jionClub(String userId, String clubId) {
		String sql = "insert into club_user(user_id,club_id) values(?,?)";
		int result = jdbcTemplate.update(sql,userId,clubId);
		if(result == 0){
			message.setCode(0);
			message.setMsg("failed");
			message.setData(null);
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		message.setData(null);
		return message;
	}

	@Override
	public ResponseMsg quitClub(String userId, String clubId) {
		String sql = "delete * from user_club where user_id=?";
		message = new ResponseMsg();
		int result = jdbcTemplate.update(sql,userId,clubId);
		if(result == 0){
			message.setCode(0);
			message.setMsg("failed");
			message.setData(null);
			return message;
		}
		message.setCode(1);
		message.setData(null);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg jionActivity(String userId, String clubId, String activityId) {
		String sql = "update user_club set activity_id=? where from user_id=? AND club_id=?";
		int result = jdbcTemplate.update(sql,activityId,userId,clubId);
		if(result == 0){
			message.setCode(0);
			message.setMsg("failed");
			message.setData(null);
		}
		message.setCode(1);
		message.setMsg("success");
		message.setData(null);
		return message;
	}

	@Override
	public ResponseMsg cancelActivity(String userId, String clubId, String activityId) {
		ResponseMsg message = new ResponseMsg();
		String sql = "delete * from user_activity where activity=? AND userId=? AND activity=?";
		int result = jdbcTemplate.update(sql,userId,activityId);
		if(result == 0){
			message.setCode(0);
			message.setMsg("该活动不存在");
			message.setData(null);
		}
		message.setCode(1);
		message.setData(null);
		message.setMsg("修改成功");
		return message;
	}

	@Override
	public ResponseMsg chooseClub() {
		message = new ResponseMsg();
		String sql = "";
		try{
			List<Club> users = jdbcTemplate.query(sql, new RowMapper<Club>(){
	
				@Override
				public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
					Club club = null;
					if(rs.next()){
						club = new Club();
						club.setClubName(rs.getString("club_name"));
						club.setClubInfo(rs.getString("club_info"));
						club.setClubId(rs.getString("club_id"));
					}
					return club;
				}				
			});
			message.setCode(1);
			message.setMsg("success");
			message.setData(users);
		}catch(Exception e){
			message.setCode(0);
			message.setMsg("failed");
			message.setData(null);
			return message;
		}
		return message;
	}

	@Override
	public ResponseMsg intro_club(String clubId) {
		message = new ResponseMsg();
		String sql = "select * from clubs where club_id=?";
		try{
			Club club = jdbcTemplate.queryForObject(sql, new Object[]{clubId},new RowMapper<Club>(){
				@Override
				public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
					Club club = new Club();
					if(rs.next()){
						club.setClubName(rs.getString("club_name"));
						club.setClubInfo(rs.getString("club_info"));
						club.setClubId(rs.getString("clubId"));
					}
					return club;
				}});
			message.setCode(1);
			message.setMsg("success");
			message.setData(club);
			return message;
		}catch(Exception e){
			message.setCode(0);
			message.setData(null);
			message.setMsg("failed");
			return message;
		}
	}

	@Override
	public ResponseMsg myActivities(String userId) {
		String sql = "select * from user_club where user_id=?";
		try{
			List<Activity> activities = jdbcTemplate.query(sql, new Object[]{userId},new RowMapper<Activity>(){
				@Override
				public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
					Activity activity = new Activity();
					if(rs.next()){
						activity.setActivityAddress(rs.getString("activity_address"));
						activity.setActivityContent(rs.getString("activity_content"));
						activity.setActivityEndTime(rs.getDate("activity_end_time").getTime());
						activity.setActivityName(rs.getString("activity_name"));
						activity.setActivityStartTime(rs.getDate("activity_start_time").getTime());
					}
					return activity;
				}});
			message.setCode(1);
			message.setData(activities);
			message.setMsg("success");
		}catch(Exception e){
			message.setCode(0);
			message.setMsg("falid");
			message.setData(null);
		}
		return message;
	}

	@Override
	public ResponseMsg roleControl(String adminId, String userId, String clubId, String userRole) {
		// TODO Auto-generated method stub
		message = new ResponseMsg();
		String sql = "update user_club set user_role=? where user_id=? AND club_id=?";
		int result = jdbcTemplate.update(sql,userRole,adminId,clubId);
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
	public ResponseMsg authorityControl(String adminId, String clubId, String userId, int authority) {
		message = new ResponseMsg();
		String sql = "select user_activity from club_user where user_id=?";
		int admin = jdbcTemplate.queryForObject(sql, new Object[]{adminId}, int.class);
		if(admin > authority){
			sql = "update club_user set user_authority=? where user_id=?";
			jdbcTemplate.update(sql,authority);
			message.setCode(1);
			message.setMsg("success");
			return message;
		}			
		message.setCode(0);
		message.setMsg("faild");
		return message;
	}

	@Override
	public ResponseMsg showUserByAuthority(String userId) {
		message = new ResponseMsg();
		String sql = "select user_authority from club_user where user_id = ?";
		int authority = jdbcTemplate.queryForObject(sql, new Object[]{userId}, Integer.class);
		sql = "select name,email,user_role from users inner join club_user on club_user.user_id=users.user_id where club_user.user_authority < ?";
		List<Club_User> users = jdbcTemplate.query(sql,new Object[]{authority},new RowMapper<Club_User>() {

			@Override
			public Club_User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Club_User club_User = new Club_User();
				club_User.setName(rs.getString("name"));
				club_User.setEmail(rs.getString("email"));
				club_User.setUser_role(rs.getString("user_role"));
				return club_User;
			}
		});
		message.setCode(1);
		message.setMsg("success");
		HashMap<String, List<Club_User>> map = new HashMap<String,List<Club_User>>();
		map.put("info",users);
		message.setData(map);
		return message;
	}

}
