package com.jwang.sshxml.validate;

import org.springframework.util.StringUtils;

import com.jwang.sshxml.beans.dto.UserDto;
import com.jwang.sshxml.common.constant.ResultCode;
import com.jwang.sshxml.common.constant.ResultMsg;
import com.jwang.sshxml.common.exception.ValidateException;

public class UserValidate 
{
	private static final String LENGTH_REG = "^[a-zA-Z].{8,32}$";
	
	/**
	 * 校验account，长度介于8~32位
	 * @param userDto
	 * @throws ValidateException 
	 */
	public static void UsercheckForAdd(UserDto userDto) throws ValidateException
	{
		if(StringUtils.isEmpty(userDto.getAccount()))
		{
			throw new ValidateException(ResultCode.USER_ACCOUNT_NOT_EMPTY_CODE,
					ResultMsg.USER_ACCOUNT_NOT_EMPTY_MSG);
		}
		else
		{
			if(userDto.getAccount().matches(LENGTH_REG))
			{
				throw new ValidateException(ResultCode.USER_ACCOUNT_LENGTH_VALID_CODE,
						ResultMsg.USER_ACCOUNT_LENGTH_VALID_MSG);
			}
		}
	}
	
}
