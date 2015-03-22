package cn.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.springmvc.common.SmtpMail;
import cn.springmvc.dao.OutboundMapper;
import cn.springmvc.dao.ShopMapper;
import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.Outbound;
import cn.springmvc.model.Warehouse;

@Service
public class OutboundService {
    
	SmtpMail mail = new SmtpMail();
	
	@Autowired
	ShopMapper shopInfo;
	
	@Autowired
	WarehouseMapper warehouseDao;
	
	@Autowired
	OutboundMapper outboundDao;
	
	public Warehouse getWarehouseFromCode(String code){
		Warehouse warehouse = warehouseDao.getWarehouseFromCode(code);
		
		return warehouse;
	}
	
	public int saveOutbound(List<Outbound> goodsList) {		
		warehouseDao.updateAll(goodsList);
		outboundDao.insertAll(goodsList);
		
		mail.sendMail("出货:" + JSON.toJSONString(shopInfo.select()), 
				JSON.toJSONString(goodsList));
		
		return 0;
	}
}
