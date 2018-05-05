package com.jwang.sshxml.beans.vo;


/**
 * @author jwang
 * 构建返回结果对象
 * @param <T>
 */
public class ResultObjBulidModel <T>
{
	
	/**
	 * 返回码
	 */
	private String resultCode;
	
	/**
	 * 返回信息/错误信息
	 */
	private String resultMsg;
	
	/**
	 * 返回的数据对象
	 */
	private T resultObj;

	public String getResultCode() 
	{
		return resultCode;
	}

	public void setResultCode(String resultCode) 
	{
		this.resultCode = resultCode;
	}

	public String getResultMsg() 
	{
		return resultMsg;
	}

	public void setResultMsg(String resultMsg)
	{
		this.resultMsg = resultMsg;
	}

	public T getResultObj()
	{
		return resultObj;
	}

	public void setResultObj(T resultObj)
	{
		this.resultObj = resultObj;
	}

}
