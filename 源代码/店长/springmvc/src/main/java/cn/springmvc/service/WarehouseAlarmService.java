package cn.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.WarehouseAlarmMapper;
import cn.springmvc.model.WarehouseAlarm;

@Service
public class WarehouseAlarmService {
	
	@Autowired
	WarehouseAlarmMapper alarmDao;
    
	public List<WarehouseAlarm> getLackGoods(){
		return alarmDao.getLackGoods();
	}
	
	public List<WarehouseAlarm> getBacklogGoods(){
		return alarmDao.getBacklogGoods();
	}
	
}
