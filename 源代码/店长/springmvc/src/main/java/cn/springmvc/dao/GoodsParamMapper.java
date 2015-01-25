package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.GoodsInbound;
import cn.springmvc.model.GoodsParam;

public interface GoodsParamMapper {
	int insertAll(List<GoodsInbound> record);
	
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsParam record);

    int insertSelective(GoodsParam record);

    GoodsParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsParam record);

    int updateByPrimaryKey(GoodsParam record);
}