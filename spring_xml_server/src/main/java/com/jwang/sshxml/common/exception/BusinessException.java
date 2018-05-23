package com.jwang.sshxml.common.exception;

/**
 * @author jwang
 * ҵ���쳣��
 */
public class BusinessException extends RootException 
{
    
	private static final long serialVersionUID = 8284164474119891530L;

	public BusinessException() 
    {
        super();
    }

    public BusinessException(String message)
    {
        super(message);
    }
    
    public BusinessException(Throwable cause)
    {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) 
    {
        super(message, cause);
    }
    
    public BusinessException(String errorCode, String errorMessage) 
    {
    	 super(errorCode, errorMessage);
    }

    public BusinessException(String errorCode, String errorMessage, Throwable cause) 
    {
    	super(errorCode, errorMessage,cause);
    }
}
