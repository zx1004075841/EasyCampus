package com.easycampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="clubs")
public class Club {
	
	@NotNull(message="club name is not null")
	@Column(name="club_name")
	private String clubName;
	
	@NotNull(message="club id is not null")
	@Column(name="club_id")
	private String clubId;
	
	@NotNull(message="club info is not null")
	@Column(name="club_info")
	private String clubInfo;
	
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubId() {
		return clubId;
	}
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	public String getClubInfo() {
		return clubInfo;
	}
	public void setClubInfo(String clubInfo) {
		this.clubInfo = clubInfo;
	}

}
