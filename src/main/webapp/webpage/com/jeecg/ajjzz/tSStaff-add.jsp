<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>发证人员名单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tSStaffController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tSStaffPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							照片:
						</label>
					</td>
					<td class="value">
					     	 <input id="photo" name="photo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">照片</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							卡MAC码:
						</label>
					</td>
					<td class="value">
					     	 <input id="cardMac" name="cardMac" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卡MAC码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="cardNo" name="cardNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="realName" name="realName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
					     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							文化程度:
						</label>
					</td>
					<td class="value">
					     	 <input id="education" name="education" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文化程度</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工作单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="company" name="company" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							单位类别:
						</label>
					</td>
					<td class="value">
					     	 <input id="companyType" name="companyType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位类别</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							通讯地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">通讯地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							作业类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="workType" name="workType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作业类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							准操项目:
						</label>
					</td>
					<td class="value">
					     	 <input id="allowProject" name="allowProject" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">准操项目</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							培训单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="trainCompany" name="trainCompany" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">培训单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发证机关:
						</label>
					</td>
					<td class="value">
					     	 <input id="certificateOffice" name="certificateOffice" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发证机关</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							理论成绩:
						</label>
					</td>
					<td class="value">
					     	 <input id="theoryScore" name="theoryScore" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">理论成绩</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							实操成绩:
						</label>
					</td>
					<td class="value">
					     	 <input id="skillScore" name="skillScore" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实操成绩</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							初领日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="firstGetDate" name="firstGetDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初领日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发证日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="licenceDate" name="licenceDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发证日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							一次复审期:
						</label>
					</td>
					<td class="value">
					     	 <input id="firstRecheckDate" name="firstRecheckDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">一次复审期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							二次复审期:
						</label>
					</td>
					<td class="value">
					     	 <input id="secondRecheckDate" name="secondRecheckDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">二次复审期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							复审记录1:
						</label>
					</td>
					<td class="value">
					     	 <input id="firstRecheckRecord" name="firstRecheckRecord" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">复审记录1</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							复审记录2:
						</label>
					</td>
					<td class="value">
					     	 <input id="secondRecheckRecord" name="secondRecheckRecord" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">复审记录2</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							有效期从:
						</label>
					</td>
					<td class="value">
					     	 <input id="alidityPeriodStart" name="alidityPeriodStart" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效期从</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							有效期到:
						</label>
					</td>
					<td class="value">
					     	 <input id="alidityPeriodEnd" name="alidityPeriodEnd" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效期到</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							证件标识:
						</label>
					</td>
					<td class="value">
					     	 <input id="cardIdent" name="cardIdent" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件标识</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							复审标识:
						</label>
					</td>
					<td class="value">
					     	 <input id="recheckIdent" name="recheckIdent" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">复审标识</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本工种工龄:
						</label>
					</td>
					<td class="value">
					     	 <input id="workYears" name="workYears" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本工种工龄</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							期数标记:
						</label>
					</td>
					<td class="value">
					     	 <input id="periodSign" name="periodSign" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">期数标记</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发卡时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="certificateDate" name="certificateDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发卡时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建人单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="createCompany" name="createCompany" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="createUser" name="createUser" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="createDate" name="createDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/ajjzz/tSStaff.js"></script>		
