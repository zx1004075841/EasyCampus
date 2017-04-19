package com.easycampus.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="club_user")
public class Club_User {

	private String name;
	private String email;
	private String user_role;
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
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	
}
