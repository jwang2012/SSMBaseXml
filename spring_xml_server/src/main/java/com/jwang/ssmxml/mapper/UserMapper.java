package com.jwang.ssmxml.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;

@Repository
public interface UserMapper 
{
	int addUserInfo(@Param("userInfo") UserDto userinfo);
	
	UserDao getUserInfoById(@Param("id") Integer id);
}
