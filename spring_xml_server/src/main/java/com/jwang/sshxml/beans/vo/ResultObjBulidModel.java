package com.jwang.sshxml.beans.vo;


/**
 * @author jwang
 * �������ؽ������
 * @param <T>
 */
public class ResultObjBulidModel <T>
{
	
	/**
	 * ������
	 */
	private String resultCode;
	
	/**
	 * ������Ϣ/������Ϣ
	 */
	private String resultMsg;
	
	/**
	 * ���ص����ݶ���
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
