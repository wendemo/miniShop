package cn.springmvc.service;

import org.springframework.stereotype.Service;

import cn.springmvc.model.Goods;

@Service
public class InboundService {
    
	public void InboundProduct(Goods info, Integer id){
		
		if(id == null){
			// 插入商品数据
			
			// 插入库存数据
			
		} else {
			// 更新库存数据
			
		}
		
		// 插入进货流数据
	}
}
