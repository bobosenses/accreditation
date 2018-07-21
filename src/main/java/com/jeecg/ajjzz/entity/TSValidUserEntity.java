package com.jeecg.ajjzz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 发证人员名单
 * @author onlineGenerator
 * @date 2018-04-07 11:29:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_valid_user", schema = "")
@SuppressWarnings("serial")
public class TSValidUserEntity implements java.io.Serializable {
	/**id*/
	private Long id;
	//用户名
	private String userName;
	//密码
	private String passWord;
	//创建时间
	private Long createDate;

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

	@Column(name ="user_name",nullable=false,length=63)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name ="pass_word",nullable=false,length=127)
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name ="create_date",nullable=false,length=19)
	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
}
