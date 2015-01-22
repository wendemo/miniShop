package cn.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.Warehouse;

@Service
public class OutboundService {
    
	@Autowired
	WarehouseMapper warehouseDao;
	
	public Warehouse getWarehouseFromCode(String code){
		Warehouse warehouse = warehouseDao.getWarehouseFromCode(code);
		
		return warehouse;
	}
}
