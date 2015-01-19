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
import cn.springmvc.model.Goods;
import cn.springmvc.service.BarCodeService;

@Controller
public class TestController {
	
	Logger testLog = Logger.getLogger(TestController.class.getName());
	
	@Autowired
	BarCodeService barCodeSvc;
	
	@RequestMapping(value = "/testGetGoods", method = RequestMethod.GET)
	@ResponseBody	
	public String test(){
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
        
        return msg.toString();
	}
}
