package com.easycampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users",catalog="easy_campus")
public class User {
	
	@NotEmpty(message="用户名不能为空")
	@Length(min=8,max=20,message="长度在8-20个字符之内")
	@Column(name="user_name")
	private String userName;
	
	@NotEmpty(message="密码不能为空")
	@Length(min=8,max=20,message="长度在8-20个字符之内")
	@Column(name="password")
	private String password;
	
	@NotEmpty(message="昵称不能为空")
	@Length(min=8,max=20,message="长度在8-20个字符之内")
	@Column(name="name")
	private String name;
	
	@Email(message="邮箱的格式不正确")
	@Column(name="email")
	private String email;
	
	@Length(max=50,message="个性签名最多不能超过50个字符")
	@Column(name="brirf_introduction")
	private String briefIntroduction;
	
	@NotEmpty(message="学号不能为空")
	@Length(min=8,max=8,message="学号长度必须为8为数字")
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
