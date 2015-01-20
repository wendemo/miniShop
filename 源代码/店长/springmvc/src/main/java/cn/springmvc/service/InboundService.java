package cn.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.Goods;
import cn.springmvc.model.Warehouse;

@Service
public class InboundService {
	
	@Autowired
	GoodsMapper goodsDao;
	
	@Autowired
	WarehouseMapper warehouseDao;
    
	public void InboundProduct(Goods info, Warehouse warehouse){
		
		if(info.getId() == null){
			// 插入商品数据
			goodsDao.insert(info);			
			
			// 插入库存数据
			warehouseDao.insert(warehouse);
		} else {
			// 更新库存数据
			warehouseDao.updateByPrimaryKey(warehouse);
		}
		
		// 插入进货流数据
	}
}
