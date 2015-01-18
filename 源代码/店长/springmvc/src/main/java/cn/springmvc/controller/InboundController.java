package cn.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.springmvc.model.Goods;
import cn.springmvc.model.ServiceItem;
import cn.springmvc.model.Shop;
import cn.springmvc.service.impl.BarCodeService;
import cn.springmvc.service.impl.ShopServiceImpl;

@Controller
public class InboundController {

	@Autowired
	BarCodeService barCodeSvc;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody	
	public String test(){
        try {
			Goods info = barCodeSvc.getGoodsInfo("6953392510388");
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        
        return "123";
	}

	
}
