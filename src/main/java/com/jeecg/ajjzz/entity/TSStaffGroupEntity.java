package com.jeecg.ajjzz.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: t_s_staff_group
 * @author onlineGenerator
 * @date 2018-04-09 00:34:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_staff_group", schema = "")
@SuppressWarnings("serial")
public class TSStaffGroupEntity implements java.io.Serializable {
	/**id*/
	private Long id;
	/**组名*/
	@Excel(name="组名",width=15)
	private String name;
	/**所属地市*/
	@Excel(name="所属地市",width=15)
	private String company;
	/**上传时间*/
	@Excel(name="上传时间",width=15)
	private Date uploadDate;
	
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
	 *@return: java.lang.String  组名
	 */

	@Column(name ="NAME_",nullable=true,length=254)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属地市
	 */

	@Column(name ="COMPANY",nullable=true,length=63)
	public String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属地市
	 */
	public void setCompany(String company){
		this.company = company;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  上传时间
	 */

	@Column(name ="UPLOAD_DATE",nullable=true,length=19)
	public Date getUploadDate(){
		return this.uploadDate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  上传时间
	 */
	public void setUploadDate(Date uploadDate){
		this.uploadDate = uploadDate;
	}
}
