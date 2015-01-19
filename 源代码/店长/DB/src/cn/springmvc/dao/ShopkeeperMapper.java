package cn.springmvc.dao;

import cn.springmvc.model.Shopkeeper;

public interface ShopkeeperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shopkeeper record);

    int insertSelective(Shopkeeper record);

    Shopkeeper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shopkeeper record);

    int updateByPrimaryKey(Shopkeeper record);
}