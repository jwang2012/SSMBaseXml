package com.jwang.sshxml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwang.sshxml.beans.dao.UserDao;
import com.jwang.sshxml.beans.dto.UserDto;
import com.jwang.sshxml.mapper.UserMapper;
import com.jwang.sshxml.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUserInfo(UserDto userDto)
	{
		userMapper.addUserInfo(userDto);
	}
	
	@Override
	public UserDao getUserInfoById(Integer id) 
	{
		return userMapper.getUserInfoById(id);
	}
}
