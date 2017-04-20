package com.easycampus.service;


import com.easycampus.utils.ResponseMsg;

/**
 * 这个接口主要定义了用户club的一些行为
 * @author zhangxing
 *
 */
public interface ClubService {

	/**
	 * 这个方法定义了加入社团功能
	 * @param userId	用户的唯一标示
	 * @param clubId	社团的唯一标示
	 * @return			返回加入社团的结果
	 */
	public ResponseMsg jionClub(String userId,String clubId);
	
	/**
	 * 这个方法定义了退出社团的功能
	 * @param userId	用户的唯一标示
	 * @param clubId	社团的唯一标示
	 * @return			返回退出社团的结果
	 */
	public ResponseMsg quitClub(String userId,String clubId);
	
	/**
	 *这个方法定义了加入活动的功能 
	 * @param userId		用户的唯一标示
	 * @param clubId		社团的唯一标示
	 * @param activityId	活动的唯一标示
	 * @return				返回加入活动的结果
	 */
	public ResponseMsg jionActivity(String userId,String clubId,String activityId);
	
	/**
	 * 这个方法定义了取消活动的功能
	 * @param userId		用户的唯一标示
	 * @param clubId		社团的唯一标示
	 * @param activityId	活动的唯一标示
	 * @return				返回取消活动的结果
	 */
	public ResponseMsg cancelActivity(String userId,String clubId,String activityId);
	
	/**
	 * 这个方法定义了选择社团的功能
	 * 主要是拉取所有所有社团列表
	 * @return		返回包含所有社团列表的结果
	 */
	public ResponseMsg chooseClub();
	
	/**
	 * 这个方法定义了展示一个社团详细信息的功能
	 * @param clubId		社团的唯一标示
	 * @return				返回社团简介的结果
	 */
	public ResponseMsg intro_club(String clubId);
	
	/**
	 * 这个方法定义了用户所选择的正在进行的所有活动
	 * @param userId		用户的唯一标示
	 * @return				返回包含所有正在进行的活动的结果
	 */
	public ResponseMsg myActivities(String userId);
}
