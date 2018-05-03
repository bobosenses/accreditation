<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div class="easyui-layout" fit="true">
  <div class = "staff" region="center" style="padding:0px;border:0px">
  <t:datagrid name="tSStaffList" checkbox="true" pagination="true" fitColumns="true" title="发证人员名单" actionUrl="tSStaffController.do?groupdatagrid&groupId=${groupId}" idField="id" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证号"  field="cardNo"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="姓名"  field="realName"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="联系电话"  field="phone"  queryMode="group"  width="300"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="tSStaffController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/ajjzz/tSStaffList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tSStaffController.do?upload&company=${company}', "tSStaffList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tSStaffController.do?exportXls","tSStaffList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tSStaffController.do?exportXlsByT","tSStaffList");
}

 </script>