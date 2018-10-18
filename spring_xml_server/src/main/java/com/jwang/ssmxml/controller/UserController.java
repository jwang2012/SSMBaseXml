package com.jwang.ssmxml.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.beans.dto.UserListQueryDto;
import com.jwang.ssmxml.beans.vo.UserInfoVo;
import com.jwang.ssmxml.common.constant.ResultCode;
import com.jwang.ssmxml.common.exception.BusinessException;
import com.jwang.ssmxml.common.exception.ValidateException;
import com.jwang.ssmxml.service.UserService;
import com.jwang.ssmxml.validate.UserValidate;

/**
 * @author jwang
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController
{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 新增用户信息
	 * @param response
	 * @param userDto
	 * @throws IOException
	 * @throws ValidateException
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public void addUserInfo(HttpServletResponse response,@RequestBody UserDto userDto)
			throws IOException, ValidateException
	{
		//参数校验
		UserValidate.usercheckForAdd(userDto);
		
		//开始新增
		userService.addUserInfo(userDto);
		
		//返回结果
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, "ok", userDto)));
	}
	
	/**
	 * 根据id获取用户信息
	 * @param response
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value="/getUserById/{id}",method=RequestMethod.GET)
	public void getUserInfoById(HttpServletResponse response, @PathVariable("id") Integer id)
			throws IOException
	{
		UserDao userDao = userService.getUserInfoById(id);
			
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, userDao)));
	}
	
	/**
	 * 分页查询用户列表
	 * @param response
	 * @param userListQueryDto
	 * @throws IOException 
	 */
	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
	public void getUserList(HttpServletResponse response, @RequestBody
			UserListQueryDto userListQueryDto) throws IOException
	{
		UserInfoVo userInfoVo = userService.getUserList(userListQueryDto);
		
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, userInfoVo)));
	}
	
	/**
	 * 更新用户信息
	 * @param response
	 * @param userDto
	 * @throws IOException 
	 */
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public void updateUserInfo(HttpServletResponse response, @RequestBody UserDto userDto) throws IOException
	{
		userService.updateUserInfo(userDto);
		
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, null)));

	}
	
	/**
	 * 更新用户信息
	 * @param response
	 * @param userDto
	 * @throws IOException 
	 * @throws BusinessException 
	 */
	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
	public void deleteUserInfo(HttpServletResponse response, @PathVariable("id") Integer id) throws IOException, BusinessException
	{
		userService.deleteUserInfoById(id);
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, null)));
	}
	
}