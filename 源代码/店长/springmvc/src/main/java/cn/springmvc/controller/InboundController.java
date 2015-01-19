package cn.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.common.Message;
import cn.springmvc.common.MsgCode;
import cn.springmvc.model.Goods;
import cn.springmvc.service.BarCodeService;
@Controller
public class InboundController {

	Logger mInboundLogger = Logger.getLogger(InboundController.class.getName());
	
	@Autowired
	BarCodeService barCodeSvc;
	
	@RequestMapping(value = "/getGoodsFromCode", method = RequestMethod.GET)
	@ResponseBody
    String getGoodsFromCode(@RequestParam String code){
		Message msg = new Message();
		
		Goods info = null;
        try {
        	info = barCodeSvc.getGoodsInfo(code);
        	
        	msg.setCode(MsgCode.OK.getCode());
        	msg.setDesc(MsgCode.OK.getDesc());
        	msg.setContent(info);
        	
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			mInboundLogger.error(e.getMessage());
			
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			mInboundLogger.error(e.getMessage());
			
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			mInboundLogger.error(e.getMessage());
			
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		}
        
        return msg.toString();
	}
	
	@RequestMapping(value = "/putInProduct", method = RequestMethod.POST)
	@ResponseBody
    String postGoodsFromCode(@RequestParam String code,
    		                 @RequestParam String name,
    		                 @RequestParam String company,
    		                 @RequestParam String trademark,
    		                 @RequestParam Integer type,
    		                 @RequestParam(required=false) Integer id){
		
		Message msg = new Message();
		
		// 
		
		return "";
	}
}
