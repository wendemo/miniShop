package cn.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.dao.GoodsParamMapper;
import cn.springmvc.dao.InboundMapper;
import cn.springmvc.dao.ShopMapper;
import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.Goods;
import cn.springmvc.model.GoodsInbound;
import cn.springmvc.model.GoodsParam;
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
	InboundMapper inboundDao;
	
	@Autowired
	GoodsParamMapper goodsParams;
    
	public int InboundProduct(List<GoodsInbound> inGoods){
		goodsDao.insertAll(inGoods);
		warehouseDao.insertAll(inGoods);
		inboundDao.insertAll(inGoods);
		goodsParams.insertAll(inGoods);
		return 0;
	}
}
