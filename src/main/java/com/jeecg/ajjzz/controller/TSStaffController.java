package com.jeecg.ajjzz.controller;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.kisso.common.encrypt.MD5;
import com.google.zxing.WriterException;
import com.jeecg.ajjzz.entity.TSStaffGroupEntity;
import com.jeecg.ajjzz.service.TSStaffGroupServiceI;
import org.apache.log4j.Logger;
import com.jeecg.ajjzz.entity.TSStaffEntity;
import com.jeecg.ajjzz.service.TSStaffServiceI;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.enums.StoreUploadFilePathEnum;
import org.jeecgframework.core.util.*;
import org.jeecgframework.p3.core.util.MD5Util;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 发证人员名单
 * @author onlineGenerator
 * @date 2018-04-07 11:29:12
 * @version V1.0   
 *
 */
@Api(value="TSStaff",description="发证人员名单",tags="tSStaffController")
@Controller
@RequestMapping("/tSStaffController")
public class TSStaffController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSStaffController.class);

	@Autowired
	private TSStaffServiceI tSStaffService;
	@Autowired
	private TSStaffGroupServiceI tsStaffGroupService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UserService userService;


	/**
	 * 发证人员名单列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "print")
	public ModelAndView print(HttpServletRequest request) {
		System.out.println("-----------------------");
		return new ModelAndView("com/jeecg/ajjzz/print");
	}

	/**print
	 * 获取二维码
	 *
	 * @return
	 */
	@RequestMapping(params = "getQrCodeImage")
	public void getQrCodeImage(String id,HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException {
		response.setDateHeader("Expires", 0L);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/png");
		ServletOutputStream out = null;
		out = response.getOutputStream();

		BufferedImage image = ImagesUtils.imagesSynthesis(id, "李文搏", "男", "国际大都会", "2018-3-6", "132135");
		ImageIO.write(image, "png", out);
		out.flush();
		out.close();


	}


	/**
	 * 发证人员名单列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "alllist")
	public ModelAndView alllist(HttpServletRequest request) {
		TSUser u = ResourceUtil.getSessionUser();
		TSDepart depart = systemService.findUniqueByProperty(TSDepart.class,"id",u.getDepartid());
		if (depart.getTSPDepart() == null) {
			request.setAttribute("show", "show");
		}
		String company = request.getParameter("company");
		request.setAttribute("company", company);
		System.out.println(company);
		return new ModelAndView("com/jeecg/ajjzz/tSStaffList");
	}

	/**
	 * 发证人员名单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		TSUser u = ResourceUtil.getSessionUser();
		TSDepart depart = systemService.findUniqueByProperty(TSDepart.class,"id",u.getDepartid());
		if (u.getRealName().equals("shanxi")) {
			request.setAttribute("show", "show");
		}
		String company = request.getParameter("company");
		request.setAttribute("company", company);
		System.out.println(company);
		return new ModelAndView("com/jeecg/ajjzz/tSStaffList");
	}

	/**
	 * 发证人员名单列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "stafflist")
	public ModelAndView depart_staff(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/ajjzz/depart_staff");
	}

	/**goStaff
	 * 发证人员名单列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goStaff")
	public ModelAndView goStaff(HttpServletRequest request) {
		String groupId = request.getParameter("groupId");
		request.setAttribute("groupId", groupId);
		return new ModelAndView("com/jeecg/ajjzz/group_staffList");
	}

	/**goStaff
	 * 发证人员名单列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goStaffgroup")
	public ModelAndView goStaffgroup(HttpServletRequest request) {
		String groupId = request.getParameter("groupId");
		request.setAttribute("groupId", groupId);
		return new ModelAndView("com/jeecg/ajjzz/group_staff");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TSStaffEntity tSStaff, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	    //company不为空表示是省局角色
		if (StringUtil.isNotEmpty(tSStaff.getCompany())) {
            TSDepart depart = systemService.findUniqueByProperty(TSDepart.class,"id",tSStaff.getCompany());
            if (depart != null) {
            	if (depart.getTSPDepart() == null) {
					if("quanbu".equals(depart.getCreateName())) {
						tSStaff.setCompany(null);
					} else {
						tSStaff.setCompany(depart.getId());
					}
				} else {
					TSDepart departgroup = systemService.findUniqueByProperty(TSDepart.class,"id",tSStaff.getCompany());
					tSStaff.setGroupOrg(departgroup.getId());
					tSStaff.setCompany(null);
				}
            }
            if ("all".equals(tSStaff.getCompany())) {
				tSStaff.setCompany(null);
			}
        } else {
            TSUser u = ResourceUtil.getSessionUser();
            TSDepart depart = systemService.findUniqueByProperty(TSDepart.class,"id",u.getDepartid());
            if (depart != null) {
                tSStaff.setCompany(depart.getId());
            }
        }

		CriteriaQuery cq = new CriteriaQuery(TSStaffEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSStaff, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSStaffService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "groupdatagrid")
	public void groupdatagrid(TSStaffEntity tSStaff, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//company不为空表示是省局角色
//		if (StringUtil.isNotEmpty(tSStaff.getCompany())) {
//			TSDepart depart = systemService.findUniqueByProperty(TSDepart.class,"id",tSStaff.getCompany());
//			if (depart != null && depart.getTSPDepart() == null) {
//				tSStaff.setCompany(depart.getId());
//			}
//		} else {
//			TSUser u = ResourceUtil.getSessionUser();
//			TSDepart depart = systemService.findUniqueByProperty(TSDepart.class,"id",u.getDepartid());
//			if (depart != null) {
//				tSStaff.setCompany(depart.getId());
//			}
//		}

		CriteriaQuery cq = new CriteriaQuery(TSStaffEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSStaff, request.getParameterMap());
		try{
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSStaffService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除发证人员名单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSStaffEntity tSStaff, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tSStaff = systemService.getEntity(TSStaffEntity.class, tSStaff.getId());
		message = "发证人员名单删除成功";
		try{
			tSStaffService.delete(tSStaff);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发证人员名单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除发证人员名单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "发证人员名单删除成功";
		try{
			for(String id:ids.split(",")){
				TSStaffEntity tSStaff = systemService.getEntity(TSStaffEntity.class, 
				Integer.parseInt(id)
				);
				tSStaffService.delete(tSStaff);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "发证人员名单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发证人员名单
	 *
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSStaffEntity tSStaff, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "发证人员名单添加成功";
		try{
			tSStaffService.save(tSStaff);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发证人员名单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新发证人员名单
	 *
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSStaffEntity tSStaff, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "发证人员名单更新成功";
		TSStaffEntity t = tSStaffService.get(TSStaffEntity.class, tSStaff.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSStaff, t);
			tSStaffService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "发证人员名单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 发证人员名单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSStaffEntity tSStaff, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSStaff.getId())) {
			tSStaff = tSStaffService.getEntity(TSStaffEntity.class, tSStaff.getId());
			req.setAttribute("tSStaffPage", tSStaff);
		}
		return new ModelAndView("com/jeecg/ajjzz/tSStaff-add");
	}
	/**
	 * 发证人员名单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSStaffEntity tSStaff, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSStaff.getId())) {
			tSStaff = tSStaffService.getEntity(TSStaffEntity.class, tSStaff.getId());
			req.setAttribute("tSStaffPage", tSStaff);
		}
		return new ModelAndView("com/jeecg/ajjzz/tSStaff-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("company", req.getParameter("company"));
		req.setAttribute("controller_name","tSStaffController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSStaffEntity tSStaff,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSStaffEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSStaff, request.getParameterMap());
		List<TSStaffEntity> tSStaffs = this.tSStaffService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"发证人员名单");
		modelMap.put(NormalExcelConstants.CLASS,TSStaffEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("发证人员名单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tSStaffs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TSStaffEntity tSStaff,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"发证人员名单");
    	modelMap.put(NormalExcelConstants.CLASS,TSStaffEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("发证人员名单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response, String company) throws Exception{
		AjaxJson j = new AjaxJson();
		if (company == null) {
			j.setMsg("请选择地市之后再进行导入！");
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//			entity.getValue().getOriginalFilename()
			TSStaffGroupEntity group = new TSStaffGroupEntity();
			String name1 = entity.getValue().getOriginalFilename();
			String name = name1;
			if (name.contains(".xls")) {
				name = name.replace(".xls", "");
			}
			if (name.contains("xlsx")) {
				name = name.replace(".xlsx", "");
			}
			group.setName(name);
			group.setCompany(company);
			group.setUploadDate(new Date());
			tsStaffGroupService.save(group);
			TSDepart departParent = systemService.findUniqueByProperty(TSDepart.class,"id",company);
			TSDepart departNew = new TSDepart();
			departNew.setTSPDepart(departParent);
			departNew.setDepartname(name);
			departNew.setDescription(name);
			departNew.setOrgType("1");
			departNew.setMobile("");
			departNew.setCreateName("");
			String localMaxCode  = getMaxLocalCode(null);
			departNew.setOrgCode(YouBianCodeUtil.getNextYouBianCode(localMaxCode));
			userService.save(departNew);
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<T> result = new ArrayList<T>();
				Workbook book = null;
				boolean isXSSFWorkbook = true;
				InputStream inputStream = file.getInputStream();
				if (!(inputStream.markSupported())) {
					inputStream = new PushbackInputStream(inputStream, 8);
				}
				if (POIFSFileSystem.hasPOIFSHeader(inputStream)) {
					book = new HSSFWorkbook(inputStream);
					isXSSFWorkbook = false;
				} else if (POIXMLDocument.hasOOXMLHeader(inputStream)) {
					book = new XSSFWorkbook(OPCPackage.open(inputStream));
				}
				createErrorCellStyle(book);
				Sheet sheet = book.getSheetAt(0);
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
					String correct = null;
					Row row = sheet.getRow(i);
					TSStaffEntity staff = new TSStaffEntity();
					//设置所属小组
					staff.setGroupOrg(departNew.getId());
					//设置所属单位
					staff.setCompany(company);
					//设置证号
					if (row.getCell(0) != null) {
						row.getCell(0).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setCardNo(row.getCell(0).getStringCellValue());
					}
					//设置姓名
					if (row.getCell(1) != null) {
						row.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setRealName(row.getCell(1).getStringCellValue());
					}
					//设置性别
					if (row.getCell(2) != null) {
						row.getCell(2).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setSex(row.getCell(2).getStringCellValue());
					}
					//设置文化程度
					if (row.getCell(3) != null) {
						row.getCell(3).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setEducation(row.getCell(3).getStringCellValue());
					}
					//设置工作单位
					if (row.getCell(4) != null) {
						row.getCell(4).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setCompanyName(row.getCell(4).getStringCellValue());
					}
					//设置单位类别
					if (row.getCell(5) != null) {
						row.getCell(5).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setCompanyType(row.getCell(5).getStringCellValue());
					}
					//设置通讯地址
					if (row.getCell(6) != null) {
						row.getCell(6).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setAddress(row.getCell(6).getStringCellValue());
					}
					//设置联系电话
					if (row.getCell(7) != null) {
						row.getCell(7).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setPhone(row.getCell(7).getStringCellValue());
					}
					//设置作业类别
					if (row.getCell(8) != null) {
						row.getCell(8).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setWorkType(row.getCell(8).getStringCellValue());
					}
					//设置准操项目
					if (row.getCell(9) != null) {
						row.getCell(9).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setAllowProject(row.getCell(9).getStringCellValue());
					}
					//设置培训单位
					if (row.getCell(10) != null) {
						row.getCell(10).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setTrainCompany(row.getCell(10).getStringCellValue());
					}
					//设置发证机关
					if (row.getCell(11) != null) {
						row.getCell(11).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setCertificateOffice(row.getCell(11).getStringCellValue());
					}
					//设置理论成绩
					if (row.getCell(12) != null) {
						row.getCell(12).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setTheoryScore(row.getCell(12).getStringCellValue());
					}
					//设置实操成绩
					if (row.getCell(13) != null) {
						row.getCell(13).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setSkillScore(row.getCell(13).getStringCellValue());
					}
					//设置初领日期
					if (row.getCell(14) != null) {
						row.getCell(14).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setFirstGetDate(row.getCell(14).getStringCellValue());
					}
					//设置发证日期
					if (row.getCell(15) != null) {
						row.getCell(15).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setLicenceDate(row.getCell(15).getStringCellValue());
					}
					//设置本工种工龄
					if (row.getCell(16) != null) {
						row.getCell(16).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setWorkYears(StringUtil.isEmpty(row.getCell(16).getStringCellValue()) ? 0 : new Integer(row.getCell(16).getStringCellValue()));
					}
					//设置一次复审期
					if (row.getCell(17) != null) {
						row.getCell(17).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setFirstRecheckDate(row.getCell(17).getStringCellValue());
					}
					//设置二次复审期
					if (row.getCell(18) != null) {
						row.getCell(18).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setSecondRecheckDate(row.getCell(18).getStringCellValue());
					}
					//设置复审记录1
					if (row.getCell(19) != null) {
						row.getCell(19).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setFirstRecheckRecord(row.getCell(19).getStringCellValue());
					}
					//设置复审记录2
					if (row.getCell(20) != null) {
						row.getCell(20).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setSecondRecheckRecord(row.getCell(20).getStringCellValue());
					}
					//设置有效期从
					if (row.getCell(21) != null) {
						row.getCell(21).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setAlidityPeriodStart(row.getCell(21).getStringCellValue());
					}
					//设置有效期到
					if (row.getCell(22) != null) {
						row.getCell(22).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setAlidityPeriodEnd(row.getCell(22).getStringCellValue());
					}
					//设置证件标识
					if (row.getCell(23) != null) {
						row.getCell(23).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setCardIdent(row.getCell(23).getStringCellValue());
					}
					//设置复审标识
					if (row.getCell(24) != null) {
						row.getCell(24).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setRecheckIdent(row.getCell(24).getStringCellValue());
					}
//设置一审培训
					if (row.getCell(25) != null) {
						row.getCell(25).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(25).getStringCellValue());
					}
//设置二审培训
					if (row.getCell(26) != null) {
						row.getCell(26).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(26).getStringCellValue());
					}
//设置备用3
					if (row.getCell(27) != null) {
						row.getCell(27).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(27).getStringCellValue());
					}
//设置备用4
					if (row.getCell(28) != null) {
						row.getCell(28).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(28).getStringCellValue());
					}
//设置是否连续
					if (row.getCell(29) != null) {
						row.getCell(29).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(29).getStringCellValue());
					}
//设置用工类型
					if (row.getCell(30) != null) {
						row.getCell(30).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(30).getStringCellValue());
					}
					//设置身体状况
					if (row.getCell(31) != null) {
						row.getCell(31).setCellType(HSSFCell.CELL_TYPE_STRING);
						staff.setStatus(row.getCell(31).getStringCellValue());
					}
//设置准考证号
					if (row.getCell(32) != null) {
						row.getCell(32).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(32).getStringCellValue());
					}
//设置办理号
					if (row.getCell(33) != null) {
						row.getCell(33).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(33).getStringCellValue());
					}
//设置记录号
					if (row.getCell(34) != null) {
						row.getCell(34).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(34).getStringCellValue());
					}
//设置违章记录
					if (row.getCell(35) != null) {
						row.getCell(35).setCellType(HSSFCell.CELL_TYPE_STRING);
//						staff.setCardNo(row.getCell(35).getStringCellValue());
					}

					//设置头像
					staff.setPhoto("upload/" + staff.getRealName() + "_" +staff.getCardNo() + ".jpg");
					//设置状态为未打印
					staff.setPrintStatus("not_print");
					//设置创建时间
					staff.setCreateDate(DateUtils.formatDate(new Date()).replace("-", ""));
					staff.setGroupId(group.getId());
					tSStaffService.save(staff);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}

	private void createErrorCellStyle(Workbook workbook) {
		Font font = workbook.createFont();
		font.setColor(Font.COLOR_RED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="发证人员名单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TSStaffEntity>> list() {
		List<TSStaffEntity> listTSStaffs=tSStaffService.getList(TSStaffEntity.class);
		return Result.success(listTSStaffs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取发证人员名单信息",notes="根据ID获取发证人员名单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TSStaffEntity task = tSStaffService.get(TSStaffEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取发证人员名单信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建发证人员名单")
	public ResponseMessage<?> create(@ApiParam(name="发证人员名单对象")@RequestBody TSStaffEntity tSStaff, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TSStaffEntity>> failures = validator.validate(tSStaff);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tSStaffService.save(tSStaff);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("发证人员名单信息保存失败");
		}
		return Result.success(tSStaff);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新发证人员名单",notes="更新发证人员名单")
	public ResponseMessage<?> update(@ApiParam(name="发证人员名单对象")@RequestBody TSStaffEntity tSStaff) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TSStaffEntity>> failures = validator.validate(tSStaff);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tSStaffService.saveOrUpdate(tSStaff);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新发证人员名单信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新发证人员名单信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除发证人员名单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tSStaffService.deleteEntityById(TSStaffEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("发证人员名单删除失败");
		}

		return Result.success();
	}

    @RequestMapping(value = "aaa", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="发证人员名单列表信息",produces="application/json",httpMethod="GET")
    public ResponseMessage<List<TSStaffEntity>> list1() {
        List<TSStaffEntity> listTSStaffs=tSStaffService.getList(TSStaffEntity.class);
        return Result.success(listTSStaffs);
    }

	private synchronized String getMaxLocalCode(String parentCode){
		if(oConvertUtils.isEmpty(parentCode)){
			parentCode = "";
		}
		int localCodeLength = parentCode.length() + YouBianCodeUtil.zhanweiLength;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT org_code FROM t_s_depart");

		if(ResourceUtil.getJdbcUrl().indexOf(JdbcDao.DATABSE_TYPE_SQLSERVER)!=-1){
			sb.append(" where LEN(org_code) = ").append(localCodeLength);
		}else{
			sb.append(" where LENGTH(org_code) = ").append(localCodeLength);
		}

		if(oConvertUtils.isNotEmpty(parentCode)){
			sb.append(" and  org_code like '").append(parentCode).append("%'");
		} else {

			sb.append(" and LEFT(org_code,1)='A'");

		}

		sb.append(" ORDER BY org_code DESC");
		List<Map<String, Object>> objMapList = systemService.findForJdbc(sb.toString(), 1, 1);
		String returnCode = null;
		if(objMapList!=null && objMapList.size()>0){
			returnCode = (String)objMapList.get(0).get("org_code");
		}

		return returnCode;
	}
}
