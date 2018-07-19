package com.jwang.ssmxml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.mapper.UserMapper;
import com.jwang.ssmxml.service.UserService;

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
