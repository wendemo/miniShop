package cn.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.OutboundMapper;
import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.Goods;
import cn.springmvc.model.Outbound;
import cn.springmvc.model.Warehouse;

@Service
public class OutboundService {
    
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
		
		return 0;
	}
}
