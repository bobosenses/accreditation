<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>t_s_staff_group</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tSStaffGroupController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tSStaffGroupPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								组名:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSStaffGroupPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">组名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属地市:
							</label>
						</td>
						<td class="value">
						    <input id="company" name="company" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSStaffGroupPage.company}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属地市</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								上传时间:
							</label>
						</td>
						<td class="value">
						    <input id="uploadDate" name="uploadDate" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${tSStaffGroupPage.uploadDate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上传时间</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/ajjzz/tSStaffGroup.js"></script>		
