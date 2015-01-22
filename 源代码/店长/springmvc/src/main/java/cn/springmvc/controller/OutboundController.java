package cn.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.common.Message;
import cn.springmvc.common.MsgCode;
import cn.springmvc.model.Warehouse;
import cn.springmvc.service.OutboundService;

@Controller
public class OutboundController {

	@Autowired
	OutboundService outboundSvc;
	
	@RequestMapping(value = "/getWarehouseFromCode", method = RequestMethod.GET)
	@ResponseBody
	String getWasehouseFromCode(@RequestParam String code){
		Message msg = new Message();
		
		Warehouse warehouse = outboundSvc.getWarehouseFromCode(code);
		
		if(warehouse == null){
			msg.setCode(MsgCode.EXCEPTION.getCode());
			msg.setDesc(MsgCode.EXCEPTION.getDesc());
			msg.setContent("Failed");
		} else {
			msg.setCode(MsgCode.OK.getCode());
			msg.setDesc(MsgCode.OK.getDesc());
			msg.setContent(warehouse);			
		}
		
		return msg.toString();
	}
	
	
	@RequestMapping(value = "/getWarehouseFromCode", method = RequestMethod.GET)
	@ResponseBody
	String postOutProduct(@RequestBody String goodsList){
		return "";
	}
}
