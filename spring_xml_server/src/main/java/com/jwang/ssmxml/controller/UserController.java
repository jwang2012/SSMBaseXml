package com.jwang.ssmxml.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.common.constant.ResultCode;
import com.jwang.ssmxml.common.exception.ValidateException;
import com.jwang.ssmxml.service.UserService;
import com.jwang.ssmxml.validate.UserValidate;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController
{
	public static final Gson gson = new Gson();
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public void addUserInfo(HttpServletResponse response,@RequestBody UserDto userDto)
			throws IOException, ValidateException
	{
		//参数校验
		UserValidate.UsercheckForAdd(userDto);
		
		//开始新增
		userService.addUserInfo(userDto);
		
		//返回结果
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, "xxx", userDto)));
	}
	
	@RequestMapping(value="/getUserById/{id}",method=RequestMethod.GET)
	public void getUserInfoById(HttpServletResponse response, @PathVariable("id") Integer id)
			throws IOException
	{
		UserDao userDao = userService.getUserInfoById(id);
			
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, userDao)));
	}
}