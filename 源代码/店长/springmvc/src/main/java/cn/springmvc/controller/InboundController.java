package cn.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSON;

import cn.springmvc.common.Message;
import cn.springmvc.common.MsgCode;
import cn.springmvc.model.Goods;
import cn.springmvc.model.GoodsInbound;
import cn.springmvc.model.Warehouse;
import cn.springmvc.service.BarCodeService;
import cn.springmvc.service.InboundService;
@Controller
public class InboundController {

	Logger mInboundLogger = Logger.getLogger(InboundController.class.getName());
	
	@Autowired
	BarCodeService barCodeSvc;
	
	@Autowired
	InboundService inboundSvc;
	
	@RequestMapping(value = "/getGoodsFromCode", method = RequestMethod.GET)
	@ResponseBody
	Message getGoodsFromCode(@RequestParam String code){
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
        
        return msg;
	}
	
	@RequestMapping(value = "/putInProduct", method = RequestMethod.POST)
	@ResponseBody
	Message postInProduct(@RequestParam String inGoods){
		
		Message msg = new Message();
	
		try {
			List<GoodsInbound> infos = JSON.parseArray(inGoods, GoodsInbound.class);
			
			int res = inboundSvc.InboundProduct(infos);

			if(res != 0){
				msg.setCode(MsgCode.EXCEPTION.getCode());
	        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
	        	msg.setContent("更新数据失败!");
			} else {
				msg.setCode(MsgCode.OK.getCode());
	        	msg.setDesc(MsgCode.OK.getDesc());
	        	msg.setContent("更新数据成功!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mInboundLogger.error(e.getMessage());
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		}
		
		return msg;
	}
}
