package com.jwang.sshxml.service;

import com.jwang.sshxml.beans.dao.UserDao;
import com.jwang.sshxml.beans.dto.UserDto;

public interface UserService 
{
	void addUserInfo(UserDto userDto);
	
	UserDao getUserInfoById(Integer id);
}
