package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Outbound;

public interface OutboundMapper {
	int insertAll(List<Outbound> record);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Outbound record);

    int insertSelective(Outbound record);

    Outbound selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Outbound record);

    int updateByPrimaryKey(Outbound record);
}