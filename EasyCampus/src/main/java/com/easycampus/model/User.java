package com.easycampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users",catalog="easy_campus")
public class User {

	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="brirf_introduction")
	private String briefIntroduction;
	@Column(name="user_id")
	private String userId;
	@Column(name="user_type")
	private int userType;
	@Column(name="activity_status")
	private int activityStatus;
	@Column(name="image_path")
	private String imagepPath;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBriefIntroduction() {
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(int activityStatus) {
		this.activityStatus = activityStatus;
	}
	public String getImagepPath() {
		return imagepPath;
	}
	public void setImagepPath(String imagepPath) {
		this.imagepPath = imagepPath;
	}
}
