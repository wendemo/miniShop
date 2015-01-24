package cn.springmvc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.dao.InboundMapper;
import cn.springmvc.dao.WarehouseMapper;
import cn.springmvc.model.GoodsInbound;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-mybatis.xml"})
public class TestDao {

	@Autowired
	GoodsMapper goodsDao;
	
	@Autowired
	WarehouseMapper warehouseDao;
	
	@Autowired
	InboundMapper inboundDao;
	
	@Test
	public void testWarehouseDao(){
		List<GoodsInbound> goods = new ArrayList<GoodsInbound>();
		
		Integer i = 0;
		
		for(i = 0; i< 2; i++){
			GoodsInbound info = new GoodsInbound();
			
			info.setCode(String.valueOf(i + 1));
			info.setCompany("mini");
			info.setCount(1);
			info.setName("Hello Kitty");
			info.setPrice(1000);
			info.setPurchasePrice(100);
			info.setShopId(1);
			info.setTrademark("22");
			info.setType(1);
			info.setOperatorId(1);
			
			goods.add(info);
		}
		
		long tt = System.currentTimeMillis();
		goodsDao.insertAll(goods);
		warehouseDao.insertAll(goods);
		inboundDao.insertAll(goods);
		System.out.print("tt:" + String.valueOf(System.currentTimeMillis() - tt) + "\n");
	}
}
