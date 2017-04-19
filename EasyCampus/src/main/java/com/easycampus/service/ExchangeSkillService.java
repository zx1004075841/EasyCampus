package com.easycampus.service;

import com.easycampus.model.Skill;
import com.easycampus.utils.ResponseMsg;

public interface ExchangeSkillService {

	/**
	 * this method is used to show all skills,which is user selected 
	 * @param userId	Identify of user
	 * @return			this value contains my skills
	 */
	public ResponseMsg mySkill(String userId);
	
	/**
	 * this method aims to add a new skill
	 * @param userId	identify of user
	 * @param skill		this skill will be created
	 * @return
	 */
	public ResponseMsg addSkill(String userId,Skill skill);
	
	/**
	 * this method is removed to a assigned skill
	 * @param userId		identify of user
	 * @param skillId		identify of skill
	 * @return
	 */
	public ResponseMsg removeSkill(String userId,String skillId);
	
	/**
	 * edit skill info
	 * @param userId		identify of user
	 * @param skill			new skill
	 * @return
	 */
	public ResponseMsg editSkill(String userId,Skill skill);
	/**
	 * this method is contented a assigned skill
	 * @param skillId  It is this id of skill that you want to content
	 * @return
	 */
	public ResponseMsg discussSkill(String skillId,String context,String userId);
	
	/**
	 * if you want to focus on a your favorite skill 
	 * @param userId		identify of user
	 * @param skillId		identify of skill
	 * @return
	 */
	public ResponseMsg focusSkill(String userId,String skillId);
	
	/**
	 * this method is used to add a new skill-type
	 * @param userId		identify of user
	 * @param SkillType		skill type
	 * @return
	 */
	public ResponseMsg addSkillType(String userId,String skillType);
	
	/**
	 * if you want to remove a assign-skill type,you would like to select this method 
	 * @param userId			identify of user
	 * @param SkillType			skill-type identify
	 * @return
	 */
	public ResponseMsg removeSkillType(String userId,String skillType);
}
