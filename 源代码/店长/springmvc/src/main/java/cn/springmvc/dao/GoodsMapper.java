package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Goods;
import cn.springmvc.model.GoodsInbound;

public interface GoodsMapper {
	int insertAll(List<GoodsInbound> record);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    Goods getByCode(String code);
}