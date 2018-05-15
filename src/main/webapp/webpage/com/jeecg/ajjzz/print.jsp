<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>jeecg_demo</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="jeecgListDemoController.do?doCheck" >
					<input id="id" name="id" type="hidden" value="${jeecgDemoPage.id }">
            <input id="realName" name="realName" type="hidden" value="${realName}">
            <input id="cardNo" name="cardNo" type="hidden" value="${cardNo}">
		<table style="width:320px;" cellpadding="0" cellspacing="1" class="formtable">
            <img alt="image" width="800" height="500" src="upload/${realName}_${cardNo}_print.jpg" />
			</table>
		</t:formvalid>
 </body>
