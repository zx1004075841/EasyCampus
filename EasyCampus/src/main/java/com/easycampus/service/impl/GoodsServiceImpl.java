package com.easycampus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.easycampus.model.Goods;
import com.easycampus.service.GoodService;
import com.easycampus.utils.ResponseMsg;

@Service
public class GoodsServiceImpl implements GoodService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private ResponseMsg message;

	@Override
	public ResponseMsg showAllGoods() {
		message = new ResponseMsg();
		String sql = "select * from goods";
		List<Goods> list = jdbcTemplate.query(sql,new RowMapper<Goods>(){

			@Override
			public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
				Goods goods = new Goods();
				while(rs.next()){
					goods.setGoodsContent(rs.getString("goods_content"));
					goods.setGoodsId(rs.getString("goods_id"));
					goods.setGoodsImage(rs.getString("goods_image"));
					goods.setGoodsName(rs.getString("goods_name"));
					goods.setGoodsPrice(rs.getString("goods_price"));
					goods.setGoodsType(rs.getString("goods_type"));
				}
				return goods;
			}});
		message.setCode(1);
		message.setMsg("success");
		HashMap<String, List<Goods>> data = new HashMap<String,List<Goods>>();
		data.put("goodsInfo", list);
		message.setData(data);
		return message;
	}

	@Override
	public ResponseMsg showAssignGoods(String goodsId) {
		message = new ResponseMsg();
		String sql = "select * from goods where goods_id=?";
		Goods goods = null;
		try{
		goods = jdbcTemplate.queryForObject(sql, new Object[]{goodsId}, Goods.class);
		}catch(Exception e){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		message.setData(new HashMap<String,Goods>().put("goodsInfo", goods));
		return message;
	}

	@Override
	public ResponseMsg addGoods(String userId, Goods goods) {
		String sql = "insert goods(user_id,goods_content,goods_id,goods_image"
				+ ",goods_name,goods_price,goods_type) values(?,?,?,?,?,?,?)";
		message = new ResponseMsg();
		int resultNum = jdbcTemplate.update(sql,new Object[]{userId,goods.getGoodsContent(),goods.getGoodsId(),
				goods.getGoodsImage(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsType()});
		if(0 == resultNum){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}

	@Override
	public ResponseMsg removeGoods(String userId, String goodsId) {
		message = new ResponseMsg();
		String sql = "delete * from goods where user_id=? AND goods_id=?";
		int resultNum = jdbcTemplate.update(sql,new Object[]{userId,goodsId});
		if(0 == resultNum){
			message.setCode(0);
			message.setMsg("faild");
			return message;
		}
		message.setCode(1);
		message.setMsg("success");
		return message;
	}
	
	
}
