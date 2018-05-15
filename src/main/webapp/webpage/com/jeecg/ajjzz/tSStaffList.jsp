<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<%--<style>--%>

 <%--.staff{ width:1500px; height:800px; float:left; }--%>
 <%--.easyui-layout{--%>
  <%--margin-left:10px;--%>
  <%--overflow-y:scroll;--%>
  <%--overflow-x:scroll;}--%>
 <%--/* css注释说明：设置第二个盒子与第一个盒子间距为10px，并设置了横纵滚动条样式 */--%>
<%--</style>--%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px" >
   <a id="downloadLink"></a>
  <t:datagrid name="tSStaffList" checkbox="true" pagination="true" fitColumns="false" title="发证人员名单" actionUrl="tSStaffController.do?datagrid&company=${company}" idField="id" queryMode="group" fit="true">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="照片"  field="photo"  queryMode="group" image="true" imageSize="50,50" ></t:dgCol>
   <t:dgCol title="卡MAC码"  field="cardMac"  queryMode="group"  width="300" showLen = "300"></t:dgCol>
   <t:dgCol title="证号"  field="cardNo"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="姓名"  field="realName"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="证件标记"  field="printStatus" dictionary="card_state" queryMode="single" query="true"  width="400"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="证件状态"  field="checkType" dictionary="check_type" queryMode="single" query="true"  width="400"></t:dgCol>
   <t:dgCol title="联系电话"  field="phone"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="作业类型"  field="workType"  queryMode="group"  width="300" showLen = "300"></t:dgCol>
   <t:dgCol title="准操项目"  field="allowProject"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="培训单位"  field="trainCompany"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="发证机关"  field="certificateOffice"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="理论成绩"  field="theoryScore"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="实操成绩"  field="skillScore"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="初领日期"  field="firstGetDate"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="发证日期"  field="licenceDate"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="有效期从"  field="alidityPeriodStart"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="有效期到"  field="alidityPeriodEnd"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="本工种工龄"  field="workYears"  queryMode="group"  width="300"></t:dgCol>
   <t:dgCol title="期数标记"  field="periodSign"  queryMode="group"  width="300"></t:dgCol>

   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgFunOpt funname="downloadqrcode(id)" title="证件预览" urlclass="ace_button"  urlfont="fa-search"></t:dgFunOpt>
   <t:dgToolBar title="查看" icon="icon-search" url="tSStaffController.do?goUpdate" funname="detail"></t:dgToolBar>
   <c:if test="${show == 'show'}">
    <t:dgToolBar title="编辑" icon="icon-edit" url="tSStaffController.do?goUpdate" funname="update"></t:dgToolBar>
    <t:dgToolBar title="导入班级" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="上传头像" icon="icon-put" funname="upload(id)"></t:dgToolBar>
    <t:dgToolBar title="批量删除"  icon="icon-remove" url="tSStaffController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
    <t:dgToolBar title="打印"  icon="icon-print" url="tSStaffController.do?printAll" funname="printALLSelect"></t:dgToolBar>
   </c:if>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/ajjzz/tSStaffList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
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

 function downloadqrcode(id) {
     // window.open("tSStaffController.do?getQrCodeImage&id="+id);
     console.log(id);
     createwindow('证件预览', 'tSStaffController.do?print&id=' + id, 850, 550);
 }
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