package com.jwang.sshxml.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwang.sshxml.beans.dao.UserDao;
import com.jwang.sshxml.beans.dto.UserDto;

@Repository
public interface UserMapper 
{
	int addUserInfo(@Param("userInfo") UserDto userinfo);
	
	UserDao getUserInfoById(@Param("id") Integer id);
}
