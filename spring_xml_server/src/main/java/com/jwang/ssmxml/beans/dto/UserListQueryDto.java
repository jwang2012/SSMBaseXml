package com.jwang.ssmxml.beans.dto;

import com.jwang.ssmxml.beans.bo.PageInfo;

public class UserListQueryDto 
{
	/**
	 * 用账号作为筛选条件
	 */
	private String account;
	
	/**
	 * 分页信息作为查询条件
	 */
	private PageInfo pageInfo;

	
	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account) 
	{
		this.account = account;
	}

	public PageInfo getPageInfo() 
	{
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) 
	{
		this.pageInfo = pageInfo;
	}
	
}
