package cn.springmvc.controller;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.common.Message;
import cn.springmvc.common.MsgCode;
import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.model.Goods;
import cn.springmvc.service.BarCodeService;

@Controller
public class TestController {
	
	Logger testLog = Logger.getLogger(TestController.class.getName());
	
	@Autowired
	BarCodeService barCodeSvc;
	
	@Autowired
	GoodsMapper goodsDao;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody	
	public Message test(){
		Message msg = new Message();
		
		msg.setCode(MsgCode.OK.getCode());
    	msg.setDesc(MsgCode.OK.getDesc());
    	msg.setContent("成功");
		
		return msg;
	}
	
	@RequestMapping(value = "/testGetGoods", method = RequestMethod.GET)
	@ResponseBody	
	public Message testGetGoods(){
		Message msg = new Message();
	
		Goods info = null;
        try {
        	info = barCodeSvc.getGoodsInfo("6953392510388");
        	
        	msg.setCode(MsgCode.OK.getCode());
        	msg.setDesc(MsgCode.OK.getDesc());
        	msg.setContent(info);
        	
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			testLog.error(e.getMessage());
			
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			testLog.error(e.getMessage());
			
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			testLog.error(e.getMessage());
			
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		}
        
        return msg;
	}
	
	@RequestMapping(value = "/testInsertGoods", method = RequestMethod.GET)
	@ResponseBody
	Message testInsert(){
		
		Goods info = new Goods();
		
		info.setCode("123");
		info.setCompany("321");
		info.setName("H");
		info.setTrademark("o");
		info.setType(0);
		
		int res = goodsDao.insert(info);
		
		System.out.print("id:" + info.getId());
		
		Message msg = new Message();
		
		msg.setCode(MsgCode.OK.getCode());
    	msg.setDesc(MsgCode.OK.getDesc());
    	msg.setContent("OK");
    	
    	
		return msg;
	}
}
