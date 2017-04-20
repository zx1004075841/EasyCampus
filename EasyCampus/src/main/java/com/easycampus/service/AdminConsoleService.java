package com.easycampus.service;

import com.easycampus.model.Club;
import com.easycampus.utils.ResponseMsg;

public interface AdminConsoleService {

	/**
	 * this method is used to add a new club
	 * @param userId	this id is used to identify user whether has power to add a new club
	 * @param club		this value contains all information of this new club
	 * @return
	 */
	public ResponseMsg addClub(String userId,Club club);
	
	/**
	 * this method is used to remove a club
	 * @param userId	identify of user
	 * @param clubId	identity of club
	 * @return
	 */
	public ResponseMsg removeClub(String userId,String clubId);
	
	/**
	 * this method is used to show all clubs
	 * @return
	 */
	public ResponseMsg showClub();
	
	/**
	 * this method is used to edit a club information
	 * @param userId	identity of user
	 * @param club		identity of club
	 * @return
	 */
	public ResponseMsg editClub(String userId,Club club);
	
	/**
	 * this method id used to add a new skillType
	 * @param userId	identity of user
	 * @param type		a new type of skill 
	 * @return
	 */
	public ResponseMsg addSkillType(String userId,int type);
	
	/**
	 * this method is used to remove a assigned skill`s type
	 * @param userId	identity of user
	 * @param type		a new type of skill 
	 * @return
	 */
	public ResponseMsg removeSkillType(String userId,String type);
	
	/**
	 * if user has enough power,user cloud examine all user`s type
	 * @param userId identity of user
	 * @return
	 */
	public ResponseMsg showskillType(String userId);
	
	/**
	 * this method is used to edit the old type of skill
	 * @param userId		userId identity of user
	 * @param oldType		old skill type
	 * @param newType		new skill type
	 * @return
	 */
	public ResponseMsg editSkillType(String userId ,String oldType,String newType);
	
	/**
	 * this method is used to add a authority,which will be assgin a clubUser
	 * @param userId		identify of user
	 * @param clubUserId		a club`s user
	 * @param authority		this authority is assigned a user of user
	 * @return
	 */
	public ResponseMsg addClubUserAuthority(String adminId,String clubUserId,String authority);
	
	/**
	 * remove 
	 * @param userId
	 * @param club
	 * @param clubUserId
	 * @return
	 */
	public ResponseMsg removeClubUserAuthority(String userId,String clubId,String clubUserId);
	
	/**
	 * 
	 * @param userId
	 * @param clubId
	 * @return
	 */
	public ResponseMsg showClubUserAuthority(String userId,String clubId);
	
	/**
	 * 
	 * @param adminId
	 * @param userId
	 * @param authority
	 * @return
	 */
	public ResponseMsg editClubUserAuthority(String adminId,String userId,String authority);
	/**
	 * 
	 * @param clubUserId
	 * @param userId
	 * @param Role
	 * @return
	 */
	public ResponseMsg addClubUserRole(String clubUserId,String userId,String Role);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseMsg showClubUserRole(String userId);
	
	/**
	 * 
	 * @param clubUserId
	 * @param userId
	 * @return
	 */
	public ResponseMsg removeClubUserRole(String clubUserId,String userId);
	
	/**
	 * 这个方法主要实现用户的登陆
	 * @param userName		用户名
	 * @param password		密码
	 * @return				返回的是用户的登陆结果
	 */
	public ResponseMsg login(String userName,String password);
}