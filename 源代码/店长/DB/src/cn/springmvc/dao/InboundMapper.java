package cn.springmvc.dao;

import cn.springmvc.model.Inbound;

public interface InboundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inbound record);

    int insertSelective(Inbound record);

    Inbound selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inbound record);

    int updateByPrimaryKey(Inbound record);
}