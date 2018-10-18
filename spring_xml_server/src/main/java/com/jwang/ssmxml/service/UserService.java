package com.jwang.ssmxml.service;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.beans.dto.UserListQueryDto;
import com.jwang.ssmxml.beans.vo.UserInfoVo;
import com.jwang.ssmxml.common.exception.BusinessException;

public interface UserService 
{
	void addUserInfo(UserDto userDto);
	
	UserDao getUserInfoById(Integer id);
	
	UserInfoVo getUserList(UserListQueryDto userListQueryDto);
	
	void updateUserInfo(UserDto userDto);
	
	void deleteUserInfoById(Integer id) throws BusinessException;
}
