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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tSStaffGroupController.do?doAdd" >
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
                <td align="left">
                    <label class="Validform_label">
                            上传头像:
                    </label>
                </td>
				<!-- 文件路径对应的参数name为‘fileName1’、业务类型是‘photosucai’、自动上传、上传文件扩展名限制doc,txt,jpg、按钮风格：绿色大号按钮 -->
                <td class="value">
                    <t:webUploader type="image" displayTxt="true" bizType="staff-${groupId}" name="fileName1" auto="true" groupId="${groupId}" ></t:webUploader>
                    <span class="Validform_checktip Validform_right" style="display: none;">图片已上传</span>
                </td>
			</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/ajjzz/tSStaffGroup.js"></script>		
