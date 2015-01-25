package cn.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.model.Goods;

@Service
public class WarehouseAlarm {
	
	@Autowired
	GoodsMapper goodsDao;
    
	public List<Goods> getLackGoods(){
		return goodsDao.getLackGoods();
	}
	
}
