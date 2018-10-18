package com.jwang.ssmxml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwang.ssmxml.beans.dao.UserDao;
import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.beans.dto.UserListQueryDto;

@Repository
public interface UserMapper 
{
	int addUserInfo(@Param("userInfo") UserDto userinfo);
	
	UserDao getUserInfoById(@Param("id") Integer id);
	
	List<UserDao> getUserList(@Param("userListQueryDto") UserListQueryDto userListQueryDto);
	
	int getUserCount(@Param("userListQueryDto") UserListQueryDto userListQueryDto);
	
	int updateUserInfo(@Param("userDto") UserDto userDto);
	
	int deleteUser(@Param("id") Integer id);
	

}
