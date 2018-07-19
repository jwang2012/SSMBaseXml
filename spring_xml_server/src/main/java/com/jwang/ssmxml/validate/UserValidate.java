package com.jwang.ssmxml.validate;

import org.springframework.util.StringUtils;

import com.jwang.ssmxml.beans.dto.UserDto;
import com.jwang.ssmxml.common.constant.ResultCode;
import com.jwang.ssmxml.common.constant.ResultMsg;
import com.jwang.ssmxml.common.exception.ValidateException;

public class UserValidate 
{
	
	private static final String LENGTH_REG = "^[a-zA-Z].{8,32}$";

	/**
	 * 用户新增校验
	 * @param userDto
	 * @throws ValidateException
	 */
	public static void UsercheckForAdd(UserDto userDto) throws ValidateException 
	{
		if (StringUtils.isEmpty(userDto.getAccount())) 
		{
			throw new ValidateException(ResultCode.USER_ACCOUNT_NOT_EMPTY_CODE,
					ResultMsg.USER_ACCOUNT_NOT_EMPTY_MSG);
		} 
		else 
		{
			if (!userDto.getAccount().matches(LENGTH_REG)) 
			{
				throw new ValidateException(ResultCode.USER_ACCOUNT_LENGTH_VALID_CODE,
						ResultMsg.USER_ACCOUNT_LENGTH_VALID_MSG);
			}
		}
	}
	
}
