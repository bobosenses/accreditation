package com.jeecg.ajjzz.entity;

import java.lang.String;
import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 发证人员名单
 * @author onlineGenerator
 * @date 2018-04-07 11:29:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_staff", schema = "")
@SuppressWarnings("serial")
public class TSStaffEntity implements java.io.Serializable {
	/**id*/
	private Long id;
	/**照片*/
	@Excel(name="照片",width=15)
	private String photo;
	/**卡MAC码*/
	@Excel(name="卡MAC码",width=15)
	private String cardMac;
	/**证号*/
	@Excel(name="证号",width=15)
	private String cardNo;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private String realName;
	/**性别*/
	@Excel(name="性别",width=15)
	private String sex;
	/**文化程度*/
	@Excel(name="文化程度",width=15)
	private String education;
	/**工作单位*/
	@Excel(name="工作单位",width=15)
	private String company;
	/**单位类别*/
	@Excel(name="单位类别",width=15)
	private String companyType;
	/**通讯地址*/
	@Excel(name="通讯地址",width=15)
	private String address;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private String phone;
	/**作业类型*/
	@Excel(name="作业类型",width=15)
	private String workType;
	/**准操项目*/
	@Excel(name="准操项目",width=15)
	private String allowProject;
	/**培训单位*/
	@Excel(name="培训单位",width=15)
	private String trainCompany;
	/**发证机关*/
	@Excel(name="发证机关",width=15)
	private String certificateOffice;
	/**理论成绩*/
	@Excel(name="理论成绩",width=15)
	private String theoryScore;
	/**实操成绩*/
	@Excel(name="实操成绩",width=15)
	private String skillScore;
	/**初领日期*/
	@Excel(name="初领日期",width=15)
	private String firstGetDate;
	/**发证日期*/
	@Excel(name="发证日期",width=15)
	private String licenceDate;
	/**一次复审期*/
	@Excel(name="一次复审期",width=15)
	private String firstRecheckDate;
	/**二次复审期*/
	@Excel(name="二次复审期",width=15)
	private String secondRecheckDate;
	/**复审记录1*/
	@Excel(name="复审记录1",width=15)
	private String firstRecheckRecord;
	/**复审记录2*/
	@Excel(name="复审记录2",width=15)
	private String secondRecheckRecord;
	/**有效期从*/
	@Excel(name="有效期从",width=15)
	private String alidityPeriodStart;
	/**有效期到*/
	@Excel(name="有效期到",width=15)
	private String alidityPeriodEnd;
	/**证件标识*/
	@Excel(name="证件标识",width=15)
	private String cardIdent;
	/**复审标识*/
	@Excel(name="复审标识",width=15)
	private String recheckIdent;
	/**本工种工龄*/
	@Excel(name="本工种工龄",width=15)
	private Integer workYears;
	/**期数标记*/
	@Excel(name="期数标记",width=15)
	private Integer periodSign;
	/**发卡时间*/
	@Excel(name="发卡时间",width=15)
	private String certificateDate;
	/**创建人单位*/
	@Excel(name="创建人单位",width=15)
	private String createCompany;
	/**创建人姓名*/
	@Excel(name="创建人姓名",width=15)
	private String createUser;
	/**创建时间*/
	@Excel(name="创建时间",width=15)
	private String createDate;

	private String printStatus;

	private String status;

	private String companyName;

	private Long groupId;

	private String checkType;

	private String groupOrg;
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name ="ID",nullable=false,length=19)
	public Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(Long id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  照片
	 */

	@Column(name ="PHOTO_",nullable=true,length=255)
	public String getPhoto(){
		return this.photo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  照片
	 */
	public void setPhoto(String photo){
		this.photo = photo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卡MAC码
	 */

	@Column(name ="CARD_MAC",nullable=true,length=64)
	public String getCardMac(){
		return this.cardMac;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卡MAC码
	 */
	public void setCardMac(String cardMac){
		this.cardMac = cardMac;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证号
	 */

	@Column(name ="CARD_NO",nullable=true,length=63)
	public String getCardNo(){
		return this.cardNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证号
	 */
	public void setCardNo(String cardNo){
		this.cardNo = cardNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="REAL_NAME",nullable=true,length=63)
	public String getRealName(){
		return this.realName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setRealName(String realName){
		this.realName = realName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX_",nullable=true,length=16)
	public String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文化程度
	 */

	@Column(name ="EDUCATION_",nullable=true,length=63)
	public String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化程度
	 */
	public void setEducation(String education){
		this.education = education;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作单位
	 */

	@Column(name ="COMPANY_",nullable=true,length=127)
	public String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作单位
	 */
	public void setCompany(String company){
		this.company = company;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位类别
	 */

	@Column(name ="COMPANY_TYPE",nullable=true,length=63)
	public String getCompanyType(){
		return this.companyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位类别
	 */
	public void setCompanyType(String companyType){
		this.companyType = companyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通讯地址
	 */

	@Column(name ="ADDRESS_",nullable=true,length=255)
	public String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通讯地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="PHONE_",nullable=true,length=16)
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作业类型
	 */

	@Column(name ="WORK_TYPE",nullable=true,length=64)
	public String getWorkType(){
		return this.workType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作业类型
	 */
	public void setWorkType(String workType){
		this.workType = workType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  准操项目
	 */

	@Column(name ="ALLOW_PROJECT",nullable=true,length=64)
	public String getAllowProject(){
		return this.allowProject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  准操项目
	 */
	public void setAllowProject(String allowProject){
		this.allowProject = allowProject;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训单位
	 */

	@Column(name ="TRAIN_COMPANY",nullable=true,length=127)
	public String getTrainCompany(){
		return this.trainCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训单位
	 */
	public void setTrainCompany(String trainCompany){
		this.trainCompany = trainCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发证机关
	 */

	@Column(name ="CERTIFICATE_OFFICE",nullable=true,length=127)
	public String getCertificateOffice(){
		return this.certificateOffice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发证机关
	 */
	public void setCertificateOffice(String certificateOffice){
		this.certificateOffice = certificateOffice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  理论成绩
	 */

	@Column(name ="THEORY_SCORE",nullable=true,length=10)
	public String getTheoryScore(){
		return this.theoryScore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  理论成绩
	 */
	public void setTheoryScore(String theoryScore){
		this.theoryScore = theoryScore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实操成绩
	 */

	@Column(name ="SKILL_SCORE",nullable=true,length=10)
	public String getSkillScore(){
		return this.skillScore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实操成绩
	 */
	public void setSkillScore(String skillScore){
		this.skillScore = skillScore;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  初领日期
	 */

	@Column(name ="FIRST_GET_DATE",nullable=true,length=19)
	public String getFirstGetDate(){
		return this.firstGetDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  初领日期
	 */
	public void setFirstGetDate(String firstGetDate){
		this.firstGetDate = firstGetDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发证日期
	 */

	@Column(name ="LICENCE_DATE",nullable=true,length=19)
	public String getLicenceDate(){
		return this.licenceDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发证日期
	 */
	public void setLicenceDate(String licenceDate){
		this.licenceDate = licenceDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  一次复审期
	 */

	@Column(name ="FIRST_RECHECK_DATE",nullable=true,length=19)
	public String getFirstRecheckDate(){
		return this.firstRecheckDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  一次复审期
	 */
	public void setFirstRecheckDate(String firstRecheckDate){
		this.firstRecheckDate = firstRecheckDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  二次复审期
	 */

	@Column(name ="SECOND_RECHECK_DATE",nullable=true,length=19)
	public String getSecondRecheckDate(){
		return this.secondRecheckDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  二次复审期
	 */
	public void setSecondRecheckDate(String secondRecheckDate){
		this.secondRecheckDate = secondRecheckDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  复审记录1
	 */

	@Column(name ="FIRST_RECHECK_RECORD",nullable=true,length=255)
	public String getFirstRecheckRecord(){
		return this.firstRecheckRecord;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  复审记录1
	 */
	public void setFirstRecheckRecord(String firstRecheckRecord){
		this.firstRecheckRecord = firstRecheckRecord;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  复审记录2
	 */

	@Column(name ="SECOND_RECHECK_RECORD",nullable=true,length=255)
	public String getSecondRecheckRecord(){
		return this.secondRecheckRecord;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  复审记录2
	 */
	public void setSecondRecheckRecord(String secondRecheckRecord){
		this.secondRecheckRecord = secondRecheckRecord;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  有效期从
	 */

	@Column(name ="ALIDITY_PERIOD_START",nullable=true,length=19)
	public String getAlidityPeriodStart(){
		return this.alidityPeriodStart;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  有效期从
	 */
	public void setAlidityPeriodStart(String alidityPeriodStart){
		this.alidityPeriodStart = alidityPeriodStart;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  有效期到
	 */

	@Column(name ="ALIDITY_PERIOD_END",nullable=true,length=19)
	public String getAlidityPeriodEnd(){
		return this.alidityPeriodEnd;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  有效期到
	 */
	public void setAlidityPeriodEnd(String alidityPeriodEnd){
		this.alidityPeriodEnd = alidityPeriodEnd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件标识
	 */

	@Column(name ="CARD_IDENT",nullable=true,length=127)
	public String getCardIdent(){
		return this.cardIdent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件标识
	 */
	public void setCardIdent(String cardIdent){
		this.cardIdent = cardIdent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  复审标识
	 */

	@Column(name ="RECHECK_IDENT",nullable=true,length=127)
	public String getRecheckIdent(){
		return this.recheckIdent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  复审标识
	 */
	public void setRecheckIdent(String recheckIdent){
		this.recheckIdent = recheckIdent;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  本工种工龄
	 */

	@Column(name ="WORK_YEARS",nullable=true,length=10)
	public Integer getWorkYears(){
		return this.workYears;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  本工种工龄
	 */
	public void setWorkYears(Integer workYears){
		this.workYears = workYears;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  期数标记
	 */

	@Column(name ="PERIOD_SIGN",nullable=true,length=10)
	public Integer getPeriodSign(){
		return this.periodSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  期数标记
	 */
	public void setPeriodSign(Integer periodSign){
		this.periodSign = periodSign;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发卡时间
	 */

	@Column(name ="CERTIFICATE_DATE",nullable=true,length=19)
	public String getCertificateDate(){
		return this.certificateDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发卡时间
	 */
	public void setCertificateDate(String certificateDate){
		this.certificateDate = certificateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人单位
	 */

	@Column(name ="CREATE_COMPANY",nullable=true,length=127)
	public String getCreateCompany(){
		return this.createCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人单位
	 */
	public void setCreateCompany(String createCompany){
		this.createCompany = createCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人姓名
	 */

	@Column(name ="CREATE_USER",nullable=true,length=63)
	public String getCreateUser(){
		return this.createUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人姓名
	 */
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  创建时间
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=19)
	public String getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  创建时间
	 */
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	@Column(name ="print_status",nullable=true,length=19)
	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	@Column(name ="status",nullable=true,length=19)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name ="company_name",nullable=true,length=19)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name ="group_id",nullable=true,length=19)
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "check_type",nullable=true,length=63)
	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	@Column(name = "group_org", nullable = true, length = 127)
	public String getGroupOrg() {
		return groupOrg;
	}

	public void setGroupOrg(String groupOrg) {
		this.groupOrg = groupOrg;
	}
}
