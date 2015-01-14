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
import cn.springmvc.model.User;
import cn.springmvc.service.impl.UserServiceImpl;

@Controller
public class MainController {

	//@Autowired
	//UserServiceImpl userimp;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody	
	public String test(){
		
		DateTime_yym test = new DateTime_yym();
		
		test.setDateCotent("20150105");
		test.setTimeCotent("23.57");
		
		String datetime = test.getDateCotent() + test.getTimeCotent();
		return datetime;
		
		/*List<ServiceItem> items = new ArrayList<ServiceItem>();
		
		ServiceItem item = new ServiceItem();
						
		item.setName("1");
		item.setUrl("http://pic.6188.com/upload_6188s/flashAll/20120418/1334712634dSWgFb.jpg");
		items.add(item);
		
        item = new ServiceItem();
		
		item.setName("2");
		item.setUrl("http://img0.imgtn.bdimg.com/it/u=3460819234,80635250&fm=23&gp=0.jpg");
		items.add(item);
		
		item = new ServiceItem();
		item.setName("3");
		item.setUrl("http://img3.imgtn.bdimg.com/it/u=3375071276,1425080177&fm=21&gp=0.jpg");
		items.add(item);*/
		
	//	return JSON.toJSONString(items);		
	}

	
}
