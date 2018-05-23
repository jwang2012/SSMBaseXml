package com.jwang.sshxml.common.exception;

import com.jwang.sshxml.common.util.ExceptionUtils;

/**
 * �Զ����쳣��ĸ���
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
     * ���ڹ��������Ĵ���
     * @return
     */
    public String getFullMessage() 
    {
    	String fullMessage = ExceptionUtils
    			.buildMessage(super.getMessage(), getCause());
        return fullMessage;
    }

    /**
     * �������쳣�������ԭ������еĻ���
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
     * �������쳣�������ԭ�򣬼����ڲ��ԭ�򣨸���ԭ�򣩻�����쳣
     * <p>��{@link #getRootCause����}��ͬ����Ϊ���û�и���ԭ�������˵���ǰ�쳣
     * @return
     */
    public Throwable getMostSpecificCause()
    {
        Throwable rootCause = getRootCause();
        return (rootCause != null ? rootCause : this);
    }

    /**
     * �����쳣�Ƿ�����������͵��쳣�����ȿ����Ǹ������౾��Ҳ�����Ǹ������͵�Ƕ��ԭ��
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