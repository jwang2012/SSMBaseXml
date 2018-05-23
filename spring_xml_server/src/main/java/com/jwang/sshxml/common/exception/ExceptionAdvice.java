package com.jwang.sshxml.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwang.sshxml.common.util.ExceptionUtils;

/**
 * ��������controller�е��쳣
 * @author jwang
 *
 */
@ControllerAdvice(basePackages="com.jwang.sshxml.controller")
@ResponseBody
public class ExceptionAdvice 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * ����controller�е������쳣
     * Ŀǰֻ����Exception���Ƿ�Ҫ����Error����������
     *
     * @param e �쳣����
     * @return �쳣��ʾ
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) 
    {
    	boolean isRuntimeEcxeption = false;
        //���Զ����쳣ֱ�Ӵ�ӡ�쳣��ջ��Ϣ
        if (!(e instanceof RootException))
        {
        	isRuntimeEcxeption = true;
            LOGGER.error(ExceptionUtils.getExcTrace(e));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", "text/plain;charset=UTF-8");
        headers.add("icop-content-type", "exception");
        String message = isRuntimeEcxeption ? "ϵͳ�쳣!!!" 
        		: ExceptionUtils.bulidErrorMsg((RootException)e);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
