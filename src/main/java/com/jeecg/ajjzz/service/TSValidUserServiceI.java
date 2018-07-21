package com.jeecg.ajjzz.service;

import com.jeecg.ajjzz.entity.TSValidUserEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSValidUserServiceI extends CommonService{
	
 	public void delete(TSValidUserEntity entity) throws Exception;
 	
 	public Serializable save(TSValidUserEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSValidUserEntity entity) throws Exception;
 	
}
