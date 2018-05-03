<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div id="main_question_list" class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tSStaffGroupList" checkbox="false" pagination="true" fitColumns="true" title="未打印班级列表" actionUrl="tSStaffGroupController.do?datagrid&company=${company}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="组名"  field="name"  queryMode="group"  width="600"></t:dgCol>
   <%--<t:dgCol title="所属地市"  field="company"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="上传时间"  field="uploadDate"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tSStaffGroupController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%--<t:dgFunOpt funname="queryTypeValue(id)" title="查看成员" urlclass="ace_button"  urlfont="fa-search"></t:dgFunOpt>--%>
      <t:dgFunOpt funname="upload(id)" title="上传头像" urlclass="ace_button"  urlfont="fa-search"></t:dgFunOpt>
      <t:dgToolBar title="查看" icon="icon-search" url="tSStaffGroupController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入班级" icon="icon-put" funname="ImportXls"></t:dgToolBar>
      <t:dgToolBar title="上传头像" icon="icon-put" funname="upload(id)"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
<div data-options="region:'east',
	title:'班级成员',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
     style="width: 400px; overflow: hidden;" id="eastPanel">
 <div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="userListpanel"></div>
</div>
 <script type="text/javascript">

 $(function() {
     var li_east = 0;
 });

 /**
  * 创建上传页面窗口
  *
  * @param title
  * @param addurl
  * @param saveurl
  */
 function upload(id) {
     var title = '上传头像';
     var url = 'tSStaffGroupController.do?goUpload&groupId='+ id;
     var name = '上传头像';
     gridname=name;
     $.dialog({
         content: 'url:'+url,
         zIndex: getzIndex(),
         height:600,
         width:800,
         cache:false,
         button : [ {
             name : '关闭',
             callback : function() {
             iframe = this.iframe.contentWindow;
             }
         } ]
     });
 }

 function queryTypeValue(groupId){
     if(li_east == 0){
         $('#main_question_list').layout('expand','east');
     }
     $('#userListpanel').panel("refresh", "tSStaffController.do?goStaff&groupId=" + groupId);
 }
 function loadSuccess() {
     $('#main_question_list').layout('panel','east').panel('setTitle', "");
     $('#main_question_list').layout('collapse','east');
     $('#userListpanel').empty();
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tSStaffGroupController.do?upload', "tSStaffGroupList");
}


//导出
function ExportXls() {
	JeecgExcelExport("tSStaffGroupController.do?exportXls","tSStaffGroupList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tSStaffGroupController.do?exportXlsByT","tSStaffGroupList");
}

 </script>