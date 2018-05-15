package org.jeecgframework.web.rest.controller;

import com.google.zxing.WriterException;
import com.jeecg.ajjzz.entity.TSStaffEntity;
import com.jeecg.ajjzz.service.TSStaffServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.digest.Md5Crypt;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.util.ImagesUtils;
import org.jeecgframework.p3.core.util.MD5Util;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TSUser的Restful API
 * 
 *  path/ POST    --> 新增 (CREATE)
 *  path/id  GET -->  查询 (READ)
 *  path/id  PUT  -->  更新 (UPDATE)
 *  path/id  DELETE --> 删除 (DELETE)
 * 
 * @author liuht
 */

@Api(value="code",description="验证证件",tags="CodeRestController")

@Controller
@RequestMapping(value = "/valid")
public class CodeRestController {

	@Autowired
	private TSStaffServiceI tSStaffService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String valid (String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
		TSStaffEntity staff = tSStaffService.findUniqueByProperty(TSStaffEntity.class, "id", new Long(code));
		if (staff == null) {
			return "验证未通过， 没有查找到信息!";
		}
		//获取请求协议
		String http = request.getScheme();        //返回"http"

		//获取请求域名(IP地址);
		String host = request.getServerName();    //返回"localhost"

		//获取请求端口号
		int port = request.getServerPort();    //返回"8080"
		String path = request.getRequestURI();
		String url = host + ":" + port + path ;
		if ("localhost".equals(host)) {
			response.sendRedirect("/jeecg/rest/valid/getQrCodeImage?id=" + staff.getId().toString());
		} else {
			response.sendRedirect("/rest/valid/getQrCodeImage?id=" + staff.getId().toString());
		}
		return "验证通过！";
	}

	/**print
	 * 获取二维码
	 *
	 * @return
	 */
	@RequestMapping(value = "/getQrCodeImage", method = RequestMethod.GET)
	@ResponseBody
	public void getQrCodeImage(String id,HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException {
		response.setDateHeader("Expires", 0L);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/png");
		ServletOutputStream out = null;
		out = response.getOutputStream();
		TSStaffEntity staff = tSStaffService.findUniqueByProperty(TSStaffEntity.class, "id", new Long(id));
		BufferedImage image = ImagesUtils.imagesSynthesis(id, staff, request);
		ImageIO.write(image, "png", out);
		out.flush();
		out.close();
	}

}
