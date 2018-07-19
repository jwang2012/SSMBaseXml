package com.jwang.ssmxml.common.exception;


/**
 * @author jwang
 * 校验异常类
 */
public class ValidateException extends RootException
{
	
	private static final long serialVersionUID = 3443442491299922445L;
    
	public ValidateException() 
    {
        super();
    }

    public ValidateException(String message)
    {
        super(message);
    }
    
    public ValidateException(Throwable cause)
    {
        super(cause);
    }

    public ValidateException(String message, Throwable cause) 
    {
        super(message, cause);
    }
    
    public ValidateException(String errorCode, String errorMessage) 
    {
    	 super(errorCode, errorMessage);
    }

    public ValidateException(String errorCode, String errorMessage, Throwable cause) 
    {
    	super(errorCode, errorMessage,cause);
    }

}