package com.jwang.ssmxml.service;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;

public interface UserService 
{
	void addUserInfo(UserDto userDto);
	
	UserDao getUserInfoById(Integer id);
}
