package com.jwang.sshxml.common.exception;

public class ValidateException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String msg;
	
	public ValidateException()
	{
		
	}
	public ValidateException(String code, String msg)
	{
		this.code = code;
		
		this.msg = msg;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}
