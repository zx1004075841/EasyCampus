package com.easycampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="activities")
public class Activity {

	@NotEmpty(message="activity name is not empty")
	@Column(name="activity_name")
	private String activityName;
	
	@NotEmpty(message="activity content is not empty")
	@Column(name="activity_address")
	private String activityAddress;
	
	@NotEmpty(message="activity_content is not empty")
	@Column(name="activity_content")
	private String activityContent;
	
	@NotEmpty(message="activity_start_time")
	@Column(name="activity_start_time")
	private long activityStartTime;
	
	@NotEmpty(message="activity end time is not empty")
	@Column(name="activity_end_time")
	private long activityEndTime;
	
	@NotEmpty(message="club id is not empty")
	@Column(name="club_id")
	private String clubId;
	
	public String getClubId() {
		return clubId;
	}
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	
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
