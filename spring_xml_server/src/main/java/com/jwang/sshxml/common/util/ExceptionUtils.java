
package com.jwang.sshxml.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.gson.Gson;
import com.jwang.sshxml.beans.vo.ResultObjBulidModel;
import com.jwang.sshxml.common.exception.RootException;

/**
 * @author jwang
 * 异常工具类
 */
public class ExceptionUtils
{

    /**
     * 根据给定的异常信息和根本原因构建异常信息
     *
     * @param message：基础异常信息
     * @param cause ：根本原因
     * @return 完整的异常信息
     */
    public static String buildMessage(String message, Throwable cause)
    {
        if (cause != null)
        {
            StringBuilder sb = new StringBuilder();
            if (message != null)
            {
                sb.append(message).append("; ");
            }
            sb.append("nested exception is ").append(cause);
            return sb.toString();
        } 
        else 
        {
            return message;
        }
    }

    /**
     * 获取异常堆栈信息
     *
     * @param e 异常
     * @return 异常堆栈信息
     */
    public static String getExcTrace(Exception e)
    {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        writer.close();
        try
        {
            stringWriter.close();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
        return buffer.toString();
    }
    
    /**
     * 根据异常构建json类型的返回信息
     * @param e
     * @return
     */
    public static <T> String bulidErrorMsg(RootException e)
    {
    	ResultObjBulidModel<T> resultModel = new ResultObjBulidModel<T>();
    	resultModel.setResultCode(e.getErrorCode());
    	resultModel.setResultMsg(e.getErrorMessage());
    	Gson gson = new Gson();
    	return gson.toJson(resultModel);
    }
}
