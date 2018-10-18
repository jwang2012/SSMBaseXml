package com.jwang.ssmxml.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.beans.dto.UserListQueryDto;
import com.jwang.ssmxml.beans.vo.UserInfoVo;
import com.jwang.ssmxml.common.exception.BusinessException;
import com.jwang.ssmxml.common.redis.RedisUtils;
import com.jwang.ssmxml.mapper.UserMapper;
import com.jwang.ssmxml.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUserInfo(UserDto userDto)
	{
		userMapper.addUserInfo(userDto);
		
		//新增完成，释放redis中所有资源
		RedisUtils.flushAll();
	}
	
	@Override
	public UserDao getUserInfoById(Integer id) 
	{
		UserDao userInfo = null;
		
		//从redis中获取数据
		userInfo = (UserDao)RedisUtils.getObject("userInfoKey");
		
		if(userInfo == null)
		{
			//redis中不存在数据，从数据库获取
			userInfo = userMapper.getUserInfoById(id);
			
			//将数据库获取的数据缓存到redis
			RedisUtils.setObject("userInfoKey", userInfo);
		}
		
		return userInfo;
	}

	@Override
	public UserInfoVo getUserList(UserListQueryDto userListQueryDto) 
	{
		//先查询redis，如果有直接从redis中取，没有则查询数据库，然后写入redis
		
		UserInfoVo userInfoVo = null;
		
		userInfoVo = (UserInfoVo)RedisUtils.getObject("userInfoListKey");
		
		if(userInfoVo == null)
		{
			LOGGER.info("redis中无数据从数据库中获取......");
			userInfoVo = new UserInfoVo();
			//获取记录条数
			int count = userMapper.getUserCount(userListQueryDto);
			
			userListQueryDto.getPageInfo().setFrom(userListQueryDto.getPageInfo().getCurrentPage(),
					userListQueryDto.getPageInfo().getSize());
			
			userListQueryDto.getPageInfo().setTotal(count);
			
			List<UserDao> userList = userMapper.getUserList(userListQueryDto);
			
			userInfoVo.setPageInfo(userListQueryDto.getPageInfo());
			
			userInfoVo.setUserList(userList);
		
			RedisUtils.setObject("userInfoListKey", userInfoVo);
		}
		else
		{
			LOGGER.info("redis中有数据，从redis中获取数据......");
		}
		
		return userInfoVo;
	}

	@Override
	public void updateUserInfo(UserDto userDto) 
	{
		
	}

	@Override
	@Transactional
	public void deleteUserInfoById(Integer id) throws BusinessException
	{
		UserDao userInfo = userMapper.getUserInfoById(id+1);
		
		if(userInfo != null)
		{
			int result = userMapper.deleteUser(id);
			
			if(result == 1)
			{
				throw new BusinessException("","");
			}
			userMapper.deleteUser(id+1);
		}
		
	}
}
