package com.jwang.sshxml.beans.dto;

public class UserDto 
{
	/**
	 * id��������
	 */
	private Integer id;
	
	/**
	 * �û�ע����˺�
	 */
	private String account;
	
	/**
	 * �û���½���˺�����
	 */
	private String password;
	
	/**
	 * ��ɫ��1�������Ա��2�����ʦ��3����ѧ��
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
