package cn.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.springmvc.model.DateTime_yym;
import cn.springmvc.model.ServiceItem;
import cn.springmvc.model.Shop;
import cn.springmvc.model.User;
import cn.springmvc.service.impl.ShopServiceImpl;

@Controller
public class MainController {

	@Autowired
	ShopServiceImpl shopimp;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody	
	public String test(){
		Shop shop = shopimp.getShop();
		return shop.toString();
	}

	
}
