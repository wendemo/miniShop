package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.ShopMapper;
import cn.springmvc.model.Shop;
import cn.springmvc.model.User;
import cn.springmvc.service.ShopService;


@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	ShopMapper info;
	
	public Shop getShop() {
		// TODO Auto-generated method stub
		return info.selectByName("迷你商店");
	}

}
