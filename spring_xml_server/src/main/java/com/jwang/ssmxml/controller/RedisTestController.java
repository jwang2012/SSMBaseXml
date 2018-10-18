package com.jwang.ssmxml.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jwang.ssmxml.common.constant.ResultCode;
import com.jwang.ssmxml.common.redis.RedisUtils;

@Controller
@RequestMapping("/redis")
public class RedisTestController extends BaseController
{
	/*private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);*/
	
	@RequestMapping(value="/getRedis",method=RequestMethod.GET)
	public void getUserInfoById(HttpServletResponse response)
			throws IOException
	{
		RedisUtils.setObject("third", "huihui");
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, RedisUtils.getObject("forth"))));
	}
}
