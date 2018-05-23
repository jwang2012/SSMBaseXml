package com.jwang.sshxml.common.exception;

import com.jwang.sshxml.common.util.ExceptionUtils;

/**
 * 自定义异常类的根类
 * @author jwang
 *
 */
public abstract class RootException extends Exception
{
	private static final long serialVersionUID = 5488881574764958216L;
	
	private String errorCode;
	
	private String errorMessage;

	static
    {
        ExceptionUtils.class.getName();
    }

    public RootException() 
    {
        super();
    }

    public RootException(String message)
    {
        super(message);
    }
    
    public RootException(Throwable cause)
    {
        super(cause);
    }

    public RootException(String message, Throwable cause) 
    {
        super(message, cause);
    }
    
    public RootException(String errorCode, String errorMessage) 
    {
    	this.errorCode = errorCode;
    	this.errorMessage = errorMessage;
    }

    public RootException(String errorCode, String errorMessage, Throwable cause) 
    {
    	super(cause);
    	this.errorCode = errorCode;
    	this.errorMessage = errorMessage;
    }

    /**
     * 用于构建完整的错误
     * @return
     */
    public String getFullMessage() 
    {
    	String fullMessage = ExceptionUtils
    			.buildMessage(super.getMessage(), getCause());
        return fullMessage;
    }

    /**
     * 检索此异常的最根本原因（如果有的话）
     *
     * @return
     */
    public Throwable getRootCause() 
    {
        Throwable rootCause = null;
        Throwable cause = getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }

    /**
     * 检索此异常的最具体原因，即最内层的原因（根本原因）或本身的异常
     * <p>与{@link #getRootCause（）}不同，因为如果没有根本原因，它回退到当前异常
     * @return
     */
    public Throwable getMostSpecificCause()
    {
        Throwable rootCause = getRootCause();
        return (rootCause != null ? rootCause : this);
    }

    /**
     * 检查此异常是否包含给定类型的异常：它既可以是给定的类本身，也可以是给定类型的嵌套原因
     * @param exType
     * @return
     */
    public boolean contains(Class<?> exType) 
    {
        if (exType == null)
        {
            return false;
        }
        if (exType.isInstance(this)) 
        {
            return true;
        }
        Throwable cause = getCause();
        if (cause == this)
        {
            return false;
        }
        if (cause instanceof RootException) 
        {
            return ((RootException) cause).contains(exType);
        } 
        else 
        {
            while (cause != null) 
            {
                if (exType.isInstance(cause)) 
                {
                    return true;
                }
                if (cause.getCause() == cause)
                {
                    break;
                }
                cause = cause.getCause();
            }
            return false;
        }
    }

	public String getErrorCode() 
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	public String getErrorMessage() 
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}
    
}