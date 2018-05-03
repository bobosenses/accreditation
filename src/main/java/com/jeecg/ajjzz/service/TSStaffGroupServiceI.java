package com.jeecg.ajjzz.service;
import com.jeecg.ajjzz.entity.TSStaffGroupEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSStaffGroupServiceI extends CommonService{
	
 	public void delete(TSStaffGroupEntity entity) throws Exception;
 	
 	public Serializable save(TSStaffGroupEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSStaffGroupEntity entity) throws Exception;
 	
}
