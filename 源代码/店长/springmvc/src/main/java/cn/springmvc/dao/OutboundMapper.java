package cn.springmvc.dao;

import cn.springmvc.model.Outbound;

public interface OutboundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Outbound record);

    int insertSelective(Outbound record);

    Outbound selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Outbound record);

    int updateByPrimaryKey(Outbound record);
}