package cn.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.dao.InboundMapper;
import cn.springmvc.dao.ShopMapper;
import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.Goods;
import cn.springmvc.model.Inbound;
import cn.springmvc.model.Shop;
import cn.springmvc.model.Warehouse;

@Service
public class InboundService {
	
	@Autowired
	GoodsMapper goodsDao;
	
	@Autowired
	WarehouseMapper warehouseDao;
	
	@Autowired
	ShopMapper shopDao;
	
	@Autowired
	InboundMapper inboundDao;
    
	public int InboundProduct(Goods info, Warehouse warehouse){
		
		Shop shopInfo = shopDao.selectByPrimaryKey(1);
		
		if(info.getId() == null){
			// 插入商品数据
			int res = goodsDao.insert(info);	
			
			if(res != 1){
				return -1;
			}
			
			warehouse.setShopId(shopInfo.getId());
			warehouse.setGoodsId(info.getId());
			
			// 插入库存数据
			warehouseDao.insert(warehouse);
		} else {
			// 更新库存数据
			warehouse.setShopId(shopInfo.getId());
			warehouse.setGoodsId(info.getId());
			warehouseDao.updateByGoodsId(warehouse);
		}
		
		// 插入进货流数据
		Inbound record = new Inbound();
		
		record.setCount(warehouse.getCount());
		record.setGoodsId(info.getId());
		record.setOperatorId(1);
		record.setPrice(warehouse.getPurchasePrice());
		
		inboundDao.insert(record);
		
		return 0;
	}
}
