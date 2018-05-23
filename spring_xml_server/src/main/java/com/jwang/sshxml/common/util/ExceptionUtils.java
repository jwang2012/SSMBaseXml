
package com.jwang.sshxml.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.gson.Gson;
import com.jwang.sshxml.beans.vo.ResultObjBulidModel;
import com.jwang.sshxml.common.exception.RootException;

/**
 * @author jwang
 * �쳣������
 */
public class ExceptionUtils
{

    /**
     * ���ݸ������쳣��Ϣ�͸���ԭ�򹹽��쳣��Ϣ
     *
     * @param message�������쳣��Ϣ
     * @param cause ������ԭ��
     * @return �������쳣��Ϣ
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
     * ��ȡ�쳣��ջ��Ϣ
     *
     * @param e �쳣
     * @return �쳣��ջ��Ϣ
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
     * �����쳣����json���͵ķ�����Ϣ
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
