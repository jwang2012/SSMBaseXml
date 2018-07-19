package com.jwang.ssmxml.beans.dao;

public class UserDao
{
	/**
	 * id自增主键
	 */
	private Integer id;
	
	/**
	 * 用户注册的账号
	 */
	private String account;
	
	/**
	 * 用户登陆账号的密码
	 */
	private String password;
	
	/**
	 * 角色：1代表管理员，2代表教师，3代表学生
	 */
	private Integer role;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getAccount() 
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}
	
	@Override
	public String toString()
	{
		return "id="+id
				+";account="+account
				+";password="+password
				+";role="+role;
	}
}
