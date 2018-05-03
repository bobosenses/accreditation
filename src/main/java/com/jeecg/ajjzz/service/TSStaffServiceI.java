package com.jeecg.ajjzz.service;
import org.jeecgframework.core.common.service.CommonService;
import com.jeecg.ajjzz.entity.TSStaffEntity;

import java.io.Serializable;

public interface TSStaffServiceI extends CommonService{
	
 	public void delete(TSStaffEntity entity) throws Exception;
 	
 	public Serializable save(TSStaffEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSStaffEntity entity) throws Exception;
 	
}
