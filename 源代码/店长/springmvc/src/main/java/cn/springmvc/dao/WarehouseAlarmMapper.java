package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.WarehouseAlarm;

public interface WarehouseAlarmMapper {
	List<WarehouseAlarm> getLackGoods();
	List<WarehouseAlarm> getBacklogGoods();
}
