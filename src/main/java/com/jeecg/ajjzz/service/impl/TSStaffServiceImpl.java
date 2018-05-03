package com.jeecg.ajjzz.service.impl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.ajjzz.entity.TSStaffEntity;
import com.jeecg.ajjzz.service.TSStaffServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("tSStaffService")
@Transactional
public class TSStaffServiceImpl extends CommonServiceImpl implements TSStaffServiceI {

	
 	public void delete(TSStaffEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TSStaffEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TSStaffEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TSStaffEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(TSStaffEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(TSStaffEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TSStaffEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("photo_", t.getPhoto());
		map.put("card_mac", t.getCardMac());
		map.put("card_no", t.getCardNo());
		map.put("real_name", t.getRealName());
		map.put("sex_", t.getSex());
		map.put("education_", t.getEducation());
		map.put("company_", t.getCompany());
		map.put("company_type", t.getCompanyType());
		map.put("address_", t.getAddress());
		map.put("phone_", t.getPhone());
		map.put("work_type", t.getWorkType());
		map.put("allow_project", t.getAllowProject());
		map.put("train_company", t.getTrainCompany());
		map.put("certificate_office", t.getCertificateOffice());
		map.put("theory_score", t.getTheoryScore());
		map.put("skill_score", t.getSkillScore());
		map.put("first_get_date", t.getFirstGetDate());
		map.put("licence_date", t.getLicenceDate());
		map.put("first_recheck_date", t.getFirstRecheckDate());
		map.put("second_recheck_date", t.getSecondRecheckDate());
		map.put("first_recheck_record", t.getFirstRecheckRecord());
		map.put("second_recheck_record", t.getSecondRecheckRecord());
		map.put("alidity_period_start", t.getAlidityPeriodStart());
		map.put("alidity_period_end", t.getAlidityPeriodEnd());
		map.put("card_ident", t.getCardIdent());
		map.put("recheck_ident", t.getRecheckIdent());
		map.put("work_years", t.getWorkYears());
		map.put("period_sign", t.getPeriodSign());
		map.put("certificate_date", t.getCertificateDate());
		map.put("create_company", t.getCreateCompany());
		map.put("create_user", t.getCreateUser());
		map.put("create_date", t.getCreateDate());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TSStaffEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{photo_}",String.valueOf(t.getPhoto()));
 		sql  = sql.replace("#{card_mac}",String.valueOf(t.getCardMac()));
 		sql  = sql.replace("#{card_no}",String.valueOf(t.getCardNo()));
 		sql  = sql.replace("#{real_name}",String.valueOf(t.getRealName()));
 		sql  = sql.replace("#{sex_}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{education_}",String.valueOf(t.getEducation()));
 		sql  = sql.replace("#{company_}",String.valueOf(t.getCompany()));
 		sql  = sql.replace("#{company_type}",String.valueOf(t.getCompanyType()));
 		sql  = sql.replace("#{address_}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{phone_}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{work_type}",String.valueOf(t.getWorkType()));
 		sql  = sql.replace("#{allow_project}",String.valueOf(t.getAllowProject()));
 		sql  = sql.replace("#{train_company}",String.valueOf(t.getTrainCompany()));
 		sql  = sql.replace("#{certificate_office}",String.valueOf(t.getCertificateOffice()));
 		sql  = sql.replace("#{theory_score}",String.valueOf(t.getTheoryScore()));
 		sql  = sql.replace("#{skill_score}",String.valueOf(t.getSkillScore()));
 		sql  = sql.replace("#{first_get_date}",String.valueOf(t.getFirstGetDate()));
 		sql  = sql.replace("#{licence_date}",String.valueOf(t.getLicenceDate()));
 		sql  = sql.replace("#{first_recheck_date}",String.valueOf(t.getFirstRecheckDate()));
 		sql  = sql.replace("#{second_recheck_date}",String.valueOf(t.getSecondRecheckDate()));
 		sql  = sql.replace("#{first_recheck_record}",String.valueOf(t.getFirstRecheckRecord()));
 		sql  = sql.replace("#{second_recheck_record}",String.valueOf(t.getSecondRecheckRecord()));
 		sql  = sql.replace("#{alidity_period_start}",String.valueOf(t.getAlidityPeriodStart()));
 		sql  = sql.replace("#{alidity_period_end}",String.valueOf(t.getAlidityPeriodEnd()));
 		sql  = sql.replace("#{card_ident}",String.valueOf(t.getCardIdent()));
 		sql  = sql.replace("#{recheck_ident}",String.valueOf(t.getRecheckIdent()));
 		sql  = sql.replace("#{work_years}",String.valueOf(t.getWorkYears()));
 		sql  = sql.replace("#{period_sign}",String.valueOf(t.getPeriodSign()));
 		sql  = sql.replace("#{certificate_date}",String.valueOf(t.getCertificateDate()));
 		sql  = sql.replace("#{create_company}",String.valueOf(t.getCreateCompany()));
 		sql  = sql.replace("#{create_user}",String.valueOf(t.getCreateUser()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("t_s_staff",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}