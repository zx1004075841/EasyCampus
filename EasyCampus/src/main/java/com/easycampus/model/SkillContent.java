package com.easycampus.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author zhangxing
 */
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="skill_content")
public class SkillContent {

	@NotEmpty
	@Column(name="user_id")
	private String userId;
	
	@NotEmpty
	@Column(name="user_focus")
	private String userFocus;
	
	@NotEmpty
	@Column(name="content_context")
	private String contentContext;
	
	@NotEmpty
	@Column(name="content_time")
	private Date contentTime;
	
	@NotEmpty
	@Column(name="skill_id")
	private String skillId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserFocus() {
		return userFocus;
	}

	public void setUserFocus(String userFocus) {
		this.userFocus = userFocus;
	}

	public String getContentContext() {
		return contentContext;
	}

	public void setContentContext(String contentContext) {
		this.contentContext = contentContext;
	}

	public Date getContentTime() {
		return contentTime;
	}

	public void setContent_time(Date contentTime) {
		this.contentTime = contentTime;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	
}
