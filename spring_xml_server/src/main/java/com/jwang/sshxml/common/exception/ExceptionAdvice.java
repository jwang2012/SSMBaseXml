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
 * 拦截所有controller中的异常
 * @author jwang
 *
 */
@ControllerAdvice(basePackages="com.jwang.sshxml.controller")
@ResponseBody
public class ExceptionAdvice 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 拦截controller中的所有异常
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     * @return 异常提示
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) 
    {
    	boolean isRuntimeEcxeption = false;
        //非自定义异常直接打印异常堆栈信息
        if (!(e instanceof RootException))
        {
        	isRuntimeEcxeption = true;
            LOGGER.error(ExceptionUtils.getExcTrace(e));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", "text/plain;charset=UTF-8");
        headers.add("icop-content-type", "exception");
        String message = isRuntimeEcxeption ? "系统异常!!!" 
        		: ExceptionUtils.bulidErrorMsg((RootException)e);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
