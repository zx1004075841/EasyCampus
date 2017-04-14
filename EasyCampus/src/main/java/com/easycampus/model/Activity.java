package com.easycampus.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="activities")
public class Activity {

	@NotEmpty
	private String activityName;
	@NotEmpty
	private String activityAddress;
	@NotEmpty
	private String activityContent;
	@NotEmpty
	private long activityStartTime;
	@NotEmpty
	private long activityEndTime;
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityAddress() {
		return activityAddress;
	}
	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}
	public String getActivityContent() {
		return activityContent;
	}
	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}
	public long getActivityStartTime() {
		return activityStartTime;
	}
	public void setActivityStartTime(long activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	public long getActivityEndTime() {
		return activityEndTime;
	}
	public void setActivityEndTime(long activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
}
