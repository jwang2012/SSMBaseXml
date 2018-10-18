package com.jwang.ssmxml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jwang.ssmxml.beans.vo.ResultObjBulidModel;

/**
 * @author jwang
 * 该类为所有controller的父类，用于封装返回给前台的信息
 */
public class BaseController 
{
	
	public static final Gson gson = new Gson();
	/*
	 * msg为返回给前台的数据，包括业务数据，状态码，错误提示信息三个部分
	 * status为状态，该参数可省略
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
	 * resultCode:错误码
	 * resultMsg:错误提示信息
	 * resultObj：数据模型对象
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