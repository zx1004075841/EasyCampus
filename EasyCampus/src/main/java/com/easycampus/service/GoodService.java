package com.easycampus.service;

import com.easycampus.model.Goods;
import com.easycampus.utils.ResponseMsg;

public interface GoodService {

	/**
	 * this method is used to show all kinds of goods
	 * @return	this value contians all goods.
	 */
	public ResponseMsg showAllGoods();
	
	/**
	 * this method show assigned goods,which is user choose
	 * @param goodsId 	this string is a identify of goods of user assign
	 * @return	this value contains a assigned goods
	 */
	public ResponseMsg showAssignGoods(String goodsId);
	
	/**
	 * if you want to add a goods,you will choose this method
	 * @param userId		identify of user
	 * @param goodsType		the type of goods
	 * @param goods			the method is that user want to add
	 * @return				this return contains this method`s result
	 */
	public ResponseMsg addGoods(String userId,Goods goods);
	
	/**
	 * this method is used to remove assigned goods
	 * @param userId	identify of user
	 * @param goodsId	identify of goods
	 * @return			
	 */
	public ResponseMsg removeGoods(String userId,String goodsId);
}
