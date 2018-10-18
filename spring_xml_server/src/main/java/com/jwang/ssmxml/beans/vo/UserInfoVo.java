package com.jwang.ssmxml.beans.vo;

import java.io.Serializable;
import java.util.List;

import com.jwang.ssmxml.beans.bo.PageInfo;
import com.jwang.ssmxml.beans.dao.UserDao;


/**
 * @author jwang
 * 用于封装返回用户列表及分页信息给前端
 */
public class UserInfoVo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9176581926531041882L;

	private PageInfo pageInfo;
	
	private List<UserDao> userList;

	public PageInfo getPageInfo()
	{
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo)
	{
		this.pageInfo = pageInfo;
	}

	public List<UserDao> getUserList()
	{
		return userList;
	}

	public void setUserList(List<UserDao> userList)
	{
		this.userList = userList;
	}	
	
}
