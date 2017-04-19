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
}
