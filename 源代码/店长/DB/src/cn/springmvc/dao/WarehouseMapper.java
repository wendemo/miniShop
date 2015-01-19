package cn.springmvc.dao;

import cn.springmvc.model.Warehouse;

public interface WarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
}