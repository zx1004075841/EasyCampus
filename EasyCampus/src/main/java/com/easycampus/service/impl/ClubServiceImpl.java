package com.easycampus.service.impl;

import org.springframework.stereotype.Service;

import com.easycampus.service.ClubService;
import com.easycampus.utils.ResponseMsg;

@Service
public class ClubServiceImpl implements ClubService {

	@Override
	public ResponseMsg jionClub(String userId, String clubId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg quitClub(String userId, String clubId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg jionActivity(String userId, String clubId, String activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg cancelActivity(String userId, String clubId, String activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg chooseClub() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg intro_club(String clubId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg myActivities(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg roleControl(String adminId, String userId, String clubId, String userRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg authorityControl(String adminId, String clubId, String userId, String authority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMsg showUserByAuthority(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
