package com.easycampus.service.impl;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;
import java.util.UUID;

import javax.mail.MessageAware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.easycampus.model.Club;
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

}
