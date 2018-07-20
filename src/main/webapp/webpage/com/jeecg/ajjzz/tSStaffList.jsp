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
 <object id="SmartOCX_Control" hidden = "true" width="" height="" classid="clsid:FC884443-1FDA-4A2F-A196-B245A4F5BFD3">
 </object>
 <div class="load" id="none">
  <div>正在打印 1/1 张照片...</div></div>
 <style>
  #none{
   display: none;
  }
  .load{
   position: absolute;
   width: 100%;
   background: rgba(255,255,255,0.5);
   /* left: 0; */
   height: 764px;
   z-index: 99;
   /* text-align: center; */
   /* line-height: 760px; */
  }
 .load div{
  background: #fff;
  margin: 300px auto;
  width: 189px;
  padding: 10px;
  border: 1px solid #438eb9;
  color: #296588;
  text-align: center;
 }
 </style>
  <div region="center" style="padding:0px;border:0px" >
   <a id="downloadLink"></a>
  <t:datagrid name="tSStaffList" checkbox="true" pagination="true" fitColumns="false" title="发证人员名单" actionUrl="tSStaffController.do?datagrid&company=${company}" idField="id" queryMode="group" fit="true">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="照片"  field="photo"  queryMode="group" image="true" imageSize="50,50" ></t:dgCol>
   <t:dgCol title="姓名"  field="realName"  queryMode="group"  width="50"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="50"></t:dgCol>
   <t:dgCol title="证号"  field="cardNo"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="联系电话"  field="phone"  queryMode="group"  width="150"></t:dgCol>
   <t:dgCol title="证件状态"  field="checkType" dictionary="check_type" queryMode="single" query="true"  width="100"></t:dgCol>
   <t:dgCol title="准操项目"  field="allowProject"  queryMode="single" query="true"  width="100"></t:dgCol>
   <t:dgCol title="培训单位"  field="trainCompany"  queryMode="single" query="true"  width="250"></t:dgCol>
   <t:dgCol title="发证机关"  field="certificateOffice"  queryMode="single" query="true"  width="250"></t:dgCol>
   <t:dgCol title="初领日期"  field="firstGetDate"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="复审日期"  field="firstRecheckDate"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="换卡日期"  field="alidityPeriodEnd"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="证件标记"  field="printStatus" dictionary="card_state" queryMode="single" query="true"  width="100"></t:dgCol>
   <t:dgCol title="作业类型"  field="workType"  queryMode="group"  width="100" showLen = "300"></t:dgCol>
   <t:dgCol title="卡MAC码"  field="cardMac"  queryMode="group"  width="100" showLen = "300"></t:dgCol>
   <t:dgCol title="理论成绩"  field="theoryScore"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="实操成绩"  field="skillScore"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="发证日期"  field="licenceDate"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="有效期从"  field="alidityPeriodStart"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="有效期到"  field="alidityPeriodEnd"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="本工种工龄"  field="workYears"  queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="期数标记"  field="periodSign"  queryMode="group"  width="100"></t:dgCol>

   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgFunOpt funname="downloadqrcode(id)" title="证件预览" urlclass="ace_button"  urlfont="fa-search"></t:dgFunOpt>
   <t:dgFunOpt funname="printOne(id)" title="打印证件" urlclass="ace_button"  urlfont="fa-check"></t:dgFunOpt>
   <t:dgToolBar title="批量打印" icon="icon-print" funname="aaa('tSStaffController.do?printAll')"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tSStaffController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<c:if test="${show == 'show'}">--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="tSStaffController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="导入班级" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="上传头像" icon="icon-put" funname="upload(id)"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tSStaffController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%--</c:if>--%>
  </t:datagrid>

  </div>
 </div>
 <script src = "webpage/com/jeecg/ajjzz/tSStaffList.js"></script>
<script src="js/fakeloader.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 function printOne(id) {
     var url = 'tSStaffController.do?printAll';
     var gname = 'tSStaffList';
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     $.dialog.setting.zIndex = getzIndex(true);
     $.dialog.confirm('你确定打印该数据吗?', function(r) {
         if (r) {
             ids.push(id);
             // for (var i = 0; i < rows.length; i++) {
             //     ids.push(rows[i].id);
             //     // $.showPopTip(asdasda);
             // }
             $.ajax({
                 url: url,
                 type: 'post',
                 data: {
                     ids: ids.join(',')
                 },
                 cache: false,
                 success: function (data) {
                     var d = $.parseJSON(data);
                     if (d.success) {
                         // $(".fakeloader").fakeLoader();
                         setInterval()
                         var msg = d.msg;
                         var arr = [];
                         var load = document.getElementById('none');
                         for (var i in d.obj) {
                             console.log(i);
                             load.style.display = "block";
                             var j = parseInt(i)+1
                             console.log(d)
                             load.getElementsByTagName('div')[0].innerHTML="正在打印" + j + '/' +  ids.length + '张照片...'
                             setTimeout(3000);
                             var realName = d.obj[i].realName;
                             var cardNo = d.obj[i].cardNo;
                             var sex = d.obj[i].sex;
                             var workType = d.obj[i].workType;
                             var allowProject = d.obj[i].allowProject;
                             var firstGetDate = d.obj[i].firstGetDate;
                             var firstRecheckDate = d.obj[i].firstRecheckDate;
                             var photo = d.obj[i].photo;
                             var QRcode = d.obj[i].code;
                             CardIn();
                             setTimeout(5000);
                             // Read();
                             setTimeout(Write(realName, cardNo), 3000);
                             console.log(realName, cardNo, sex, workType,
                                 allowProject, firstGetDate, firstRecheckDate, QRcode, photo);
                             CardPrint(realName, cardNo, sex, workType,
                                 allowProject, firstGetDate, firstRecheckDate, QRcode, photo);
                             setTimeout(8000);
                             CardOut();
                             // arr.push(d.obj[i]); //属性
                             //arr.push(object[i]); //值

                         }
                         load.style.display = "none";
                         tip(msg);
                         // reloadTable();
                         $("#" + gname).datagrid('unselectAll');
                         ids = '';
                     }
                 }
             });
         }
     });
 }
 /**
  * icon="icon-print" url="tSStaffController.do?printAll"
  * '打印', 'tSStaffController.do?printAll', '1111'
  * @param title
  * @param url
  * @param gname
  * @return
  */
 function aaa(url) {
     var gname = 'tSStaffList';
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     var dataObj = [];
     function inCard (msg, rows, dIndex) {

         var load = document.getElementById('none');
         load.style.display = "block";
         console.log('下表是', dIndex)
         var j = parseInt(dIndex) + 1
         load.getElementsByTagName('div')[0].innerHTML="正在打印" + j + '/' +  ids.length + '张照片...'
         console.log(rows);
         var realName = rows[dIndex].realName;
         var cardNo = rows[dIndex].cardNo;
         var sex = rows[dIndex].sex;
         var workType = rows[dIndex].workType;
         var allowProject = rows[dIndex].allowProject;
         var firstGetDate = rows[dIndex].firstGetDate;
         var firstRecheckDate = rows[dIndex].firstRecheckDate;
         var photo = rows[dIndex].photo;
         var QRcode = rows[dIndex].code;
         //进卡
         CardIn();
         setTimeout(function () {
             Write(rows[dIndex].realName, rows[dIndex].cardNo)
             setTimeout(function () {
                 //打印
                 CardPrint(rows[dIndex].realName, rows[dIndex].cardNo, rows[dIndex].sex, rows[dIndex].workType,
                     rows[dIndex].allowProject, rows[dIndex].firstGetDate, rows[dIndex].firstRecheckDate, rows[dIndex].QRcode, rows[dIndex].photo);
                 setTimeout(function () {
                     $.ajax({
                         url: 'tSStaffController/printState.do?cardNo='+rows[dIndex].cardNo+'&batch='+ msg,
                         type: 'get',
                         cache: false,
                         success: function (data){
                             var d = JSON.parse(data)
                             var size = d.obj
                             console.log('返回数据是', d)
                             if (size === 0 || rows.length === 1) {
                                 CardOut();
                                 $("#" + gname).datagrid('unselectAll');
                                 ids = '';
                                 tip('打印已完成')
                                 load.style.display = "none";
                                 return false
                             }
                             CardOut();
                             dIndex = rows.length - size
                             console.log(size, dIndex)
                             inCard(msg, rows, dIndex)
                         }
                     })
                 }, 2000)
             }, 5000)
         }, 3000); // 如不是必须，可以不写setTimeout


         // console.log(realName, cardNo, sex, workType,
         //     allowProject, firstGetDate, firstRecheckDate, QRcode, photo);

     }
     // function callback (dataObj, dIndex = 0) {
     //     let t = null
     //     if (dIndex >= rows.length) {
     //         $("#" + gname).datagrid('unselectAll');
     //         ids = '';
     //         tip('打印已完成')
     //         clearInterval(t)
     //         return false
     //     }
     //     inCard(dIndex,dataObj)
     //
     //     t = setInterval(function () {
     //         $.ajax({
     //             url: 'tSStaffController.do?printState', // 打印状态
     //             type: 'GET',
     //             cache: false,
     //             success: function (data) {
     //                 let msg = data.msg
     //                 dIndex ++
     //                 // setTimeout(8000);
     //                 //退卡
     //                 CardOut();
     //                 clearInterval(t)
     //                 load.style.display = "none";
     //                 tip(msg);
     //                 setTimeout(function () {
     //                     callback(dataObj, dIndex)
     //                 }, 3000)
     //
     //                 // reloadTable();
     //                 // if (dIndex === rows.length - 1) {
     //                 //     $("#" + gname).datagrid('unselectAll');
     //                 //     ids = '';
     //                 // }
     //             }
     //         })
     //     },1000)
     // }
     if (rows.length > 0) {
         $.dialog.setting.zIndex = getzIndex(true);
         $.dialog.confirm('你确定打印该数据吗?', function(r) {
             if (r) {
                 for (let i = 0; i < rows.length; i++) {
                     ids.push(rows[i].id);
                     // $.showPopTip(asdasda);
                 }
                 console.log(ids);
                 $.ajax({
                     url: url,
                     type: 'post',
                     data: {
                         ids: ids.join(',')
                     },
                     cache: false,
                     success: function (data) {
                         var d = $.parseJSON(data); // 只要发送成功就返回success
                         dataObj = d.obj
                         if (d.success) {
                             console.log('拿到了什么',d.obj)
                             inCard(d.msg, d.obj,0)



                             // callback(dataObj)
                             //  console.log(d.obj);
                             //  // $(".fakeloader").fakeLoader();
                             //  var msg = d.msg;
                             //  var arr = [];
                             //  var load = document.getElementById('none');
                             //  for (var i in d.obj) {

                             //      setTimeout(5000);
                             //      // Read();
                             //      setTimeout(Write(realName, cardNo), 3000);
                             //      console.log(realName, cardNo, sex, workType,
                             //          allowProject, firstGetDate, firstRecheckDate, QRcode, photo);
                             //      //打印
                             //      CardPrint(realName, cardNo, sex, workType,
                             //          allowProject, firstGetDate, firstRecheckDate, QRcode, photo);
                             //      setTimeout(8000);
                             //      //退卡
                             //      CardOut();
                             // arr.push(d.obj[i]); //属性
                             //arr.push(object[i]); //值

                         }
                         //  load.style.display = "none";
                         //  tip(msg);
                         // reloadTable();
                         //  $("#" + gname).datagrid('unselectAll');
                         //  ids = '';
                         //  }
                     }
                 });
             }
         });
     } else {
         tip("请选择需要打印的数据");
     }
 }
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
//读卡
function Read() {

 var ocx = document.getElementById("SmartOCX_Control");
 var data = ocx.OpenComm(10, 115200);
 if(data!=0) {
     console.log(" 打开端口失败");
     return "打开端口失败！";
 }
 data =  ocx.readCard(1, "ffffffffffff");
 if(data!=0) {
     console.log(" 读卡失败");
     return "读卡失败";
 }

 var a = ocx.GetReadInfo();
 ocx.ClosePort();
 if (a !== null) {
     return "success";
 }

}
//写卡
function Write(realName, cardNo){
 var ocx = document.getElementById("SmartOCX_Control");
 var data = ocx.OpenComm(10, 115200);
 if(data!=0)
     console.log(" 打开端口失败");
 //ocx.WriteByteData(1, "ffffffffffff","11223344556677889900112233445566");
 // 第一个扇区写名字 第四、五、六 身份证号   密钥 十位
 ocx.WriteData(1, "ffffffffffff",realName);
 ocx.WriteData(4, "ffffffffffff",cardNo.substring(0,8));
 ocx.WriteData(5, "ffffffffffff",cardNo.substring(8,16));
 ocx.WriteData(6, "ffffffffffff",cardNo.substring(16,18));
 // ocx.WriteData(7, "ffffffffffff","001122334455FF078069001122334455");//密钥为001122334455 ff078069不变，前面为A秘钥后面为B秘钥，为了省事设置成一样
 ocx.ClosePort();
}
function ChangeKey(){
 var ocx = document.getElementById("SmartOCX_Control");
 var data = ocx.OpenComm(10, 115200);
 if(data!=0)
     console.log(" 打开端口失败");
 ocx.ChangeKey(1,"112233445566","ffffffffffff");
 ocx.ClosePort();
}
//进卡
function CardIn(){
 var ocx = document.getElementById("SmartOCX_Control");
 ocx.CardMove(2);

}
//出卡
function CardOut(){
 var ocx = document.getElementById("SmartOCX_Control");
 ocx.CardOut();

}
//打印
function CardPrint(realName, cardId, sex, job, pro, date, da, QRcode, photo){
 var ocx = document.getElementById("SmartOCX_Control");
 var name =(realName + "|黑体|加粗|39|250|115.4");
 var cardID =(cardId + "|黑体|加粗|39|250|47");
 var sex =(sex + "|黑体|加粗|39|550|115.4");
 var job =(job + "|黑体|加粗|39|250|183.8");
 var pro =(pro + "|黑体|加粗|39|250|252.2");
 var date =(date + "|黑体|加粗|39|250|320.6");
    // C:\\temp.png|70|500|100|100
 var da =(da + "|黑体|加粗|39|250|389");
 var QRcode = "C:\\temp.png" + "|90|485|100|100)";
 var photo = photo + "|700|66|220|293";
 var sztext = name + "||" + cardID + "||" + sex + "||" + job + "||" + pro + "||" + date + "||" + da;
 var ret = ocx.CardPrint(sztext,QRcode,photo);

 console.log(ret);
}

 function sleepmill(numberMillis) {
     var now = new Date();
     var exitTime = now.getTime() + numberMillis;
     while (true) {
         now = new Date();
         if (now.getTime() > exitTime)
             return;
     }
 }
 </script>