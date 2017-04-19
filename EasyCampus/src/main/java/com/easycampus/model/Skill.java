package com.easycampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="skills")
public class Skill {

	@Column(name="skill_name")
	@NotEmpty(message="skill_name is not empty")
	private String skillName;
	@Column(name="skill_info")
	@NotEmpty(message="skill_info is not empty")
	private String skillInfo;
	@Column(name="skill_id")
	@NotEmpty(message="skill_id is not empty")
	private String skillId;
	@Column(name="skill_type")
	@NotEmpty(message="skill_type is not empty")
	private String skillType;
	@Column(name="user_id")
	@NotEmpty(message="user_id is not empty")
	private String userId;
	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillInfo() {
		return skillInfo;
	}
	public void setSkillInfo(String skillInfo) {
		this.skillInfo = skillInfo;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
