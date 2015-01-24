package cn.springmvc.dao;

import cn.springmvc.model.GoodsParam;

public interface GoodsParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsParam record);

    int insertSelective(GoodsParam record);

    GoodsParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsParam record);

    int updateByPrimaryKey(GoodsParam record);
}