package cn.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.springmvc.common.Message;
import cn.springmvc.common.MsgCode;
import cn.springmvc.model.Goods;
import cn.springmvc.model.GoodsInbound;
import cn.springmvc.model.Outbound;
import cn.springmvc.model.Warehouse;
import cn.springmvc.service.OutboundService;
import cn.springmvc.service.WarehouseAlarm;

@Controller
public class OutboundController {

	@Autowired
	OutboundService outboundSvc;
	
	@Autowired
	WarehouseAlarm warehouseAlarm;
	
	@RequestMapping(value = "/getWarehouseFromCode", method = RequestMethod.GET)
	@ResponseBody
	Message getWasehouseFromCode(@RequestParam String code){
		Message msg = new Message();
		
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			msg.setCode(MsgCode.EXCEPTION.getCode());
			msg.setDesc(MsgCode.EXCEPTION.getDesc());
			msg.setContent(e.getMessage());
		}
		
		return msg;
	}
	
	@RequestMapping(value = "/getLackProduct", method = RequestMethod.GET)
	@ResponseBody
	Message getLackProduct(){
		Message msg = new Message();
		
		try {
			List<Goods> info = warehouseAlarm.getLackGoods();
			msg.setCode(MsgCode.OK.getCode());
        	msg.setDesc(MsgCode.OK.getDesc());
        	msg.setContent(info);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		}
		
		return msg;
	}
	
	@RequestMapping(value = "/putOutProduct", method = RequestMethod.POST)
	@ResponseBody
	Message postOutProduct(@RequestParam String outGoods){
		Message msg = new Message();
		
		try {
			List<Outbound> infos = JSON.parseArray(outGoods, Outbound.class);
			
			int res = outboundSvc.saveOutbound(infos);

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
			//mInboundLogger.error(e.getMessage());
			msg.setCode(MsgCode.EXCEPTION.getCode());
        	msg.setDesc(MsgCode.EXCEPTION.getDesc());
        	msg.setContent(e.getMessage());
		}
		
		return msg;
	}
}
