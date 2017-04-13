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
	
	/**
	 * 这个方法定义了用户角色分配的方法
	 * @param adminId		角色分配人的唯一标示
	 * @param userId		将要被分配角色的用户的唯一标示
	 * @param clubId		社团的唯一标示
	 * @param userRole		将要分配用户的角色
	 * @return				返回包含所有正在进行的活动的结果
	 */
	public ResponseMsg roleControl(String adminId,String userId,String clubId,String userRole);
	
	/**
	 * 这个方法定了用户的权限控制
	 * @param adminId		管理员的id
	 * @param clubId		社团的id
	 * @param userId		用户的id
	 * @param authority		修改的权限
	 * @return
	 */
	public ResponseMsg authorityControl(String adminId,String clubId,String userId,String authority);
	
	/**
	 * 这个方法定义了查看当前用户权限下所有的用户的角色权限
	 * @param userId	当前用户的id
	 * @return			返回包含当前用户权限下所有的用户的角色权限的结果
	 */
	public ResponseMsg showUserByAuthority(String userId);
}
