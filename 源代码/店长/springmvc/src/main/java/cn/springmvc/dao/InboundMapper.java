package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.GoodsInbound;
import cn.springmvc.model.Inbound;

public interface InboundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inbound record);
    
    int insertAll(List<GoodsInbound> record);

    int insertSelective(Inbound record);

    Inbound selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inbound record);

    int updateByPrimaryKey(Inbound record);
}