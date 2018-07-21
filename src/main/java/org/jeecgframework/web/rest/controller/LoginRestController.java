package org.jeecgframework.web.rest.controller;

import com.jeecg.ajjzz.entity.TSStaffEntity;
import com.jeecg.ajjzz.entity.TSValidUserEntity;
import com.jeecg.ajjzz.service.TSStaffServiceI;
import com.jeecg.ajjzz.service.TSValidUserServiceI;
import com.jeecg.ajjzz.service.impl.TSValidUserServiceImpl;
import io.swagger.annotations.Api;
import org.jeecgframework.core.util.AESUtil;
import org.jeecgframework.core.util.ImagesUtils;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

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

@Api(value="login",description="验证登录",tags="LoginRestController")

@Controller
@RequestMapping(value = "/login")
public class LoginRestController {

	@Autowired
	private TSValidUserServiceI tSValidUserService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson valid (String userName, String passWord) throws Exception{
		AjaxJson json = new AjaxJson();
		json.setMsg("登录成功！");
		json.setSuccess(Boolean.TRUE);
		if (userName == null || passWord == null) {
			json.setMsg("用户名或密码不能为空！");
			json.setSuccess(Boolean.FALSE);
			return json;
		}
		TSValidUserEntity user = tSValidUserService.findUniqueByProperty(TSValidUserEntity.class, "userName", userName);
		if (user == null) {
			json.setMsg("用户不存在！");
			json.setSuccess(Boolean.FALSE);
			return json;
		}
		String realPassWord = AESUtil.encodeId(passWord);
		if (!realPassWord.equals(user.getPassWord())) {
			json.setMsg("用户名和密码不匹配！");
			json.setSuccess(Boolean.FALSE);
			return json;
		}
		return json;
	}
}
