package com.jwang.sshxml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.jwang.sshxml.beans.vo.ResultObjBulidModel;

/**
 * @author jwang
 * ����Ϊ����controller�ĸ��࣬���ڷ�װ���ظ�ǰ̨����Ϣ
 */
public class BaseController 
{
	/*
	 * msgΪ���ظ�ǰ̨�����ݣ�����ҵ�����ݣ�״̬�룬������ʾ��Ϣ��������
	 * statusΪ״̬���ò�����ʡ��
	 */
	public void returnToPage(HttpServletResponse response, String msg) 
			throws IOException
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("contentType", "text/html;");
		PrintWriter out  = response.getWriter();
		out.print(msg);
		out.close();
	}
	
	/*
	 * resultCode:������
	 * resultMsg:������ʾ��Ϣ
	 * resultObj������ģ�Ͷ���
	 */
	public <T> ResultObjBulidModel<T> bulidResultObj(String resultCode, String resultMsg, T resultObj)
	{
		ResultObjBulidModel<T> resultObjBulidModel = new ResultObjBulidModel<T>();
		resultObjBulidModel.setResultCode(resultCode);
		resultObjBulidModel.setResultMsg(resultMsg);
		resultObjBulidModel.setResultObj(resultObj);
		return resultObjBulidModel;
	}
}
