package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.GoodsInbound;
import cn.springmvc.model.Outbound;
import cn.springmvc.model.Warehouse;

public interface WarehouseMapper {
	int insertAll(List<GoodsInbound> record);
	
	int updateAll(List<Outbound> recod);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);
    
    Warehouse getWarehouseFromCode(String code);

    int updateByGoodsId(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
}