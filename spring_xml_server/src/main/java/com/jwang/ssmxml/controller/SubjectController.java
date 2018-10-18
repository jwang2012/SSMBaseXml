package com.jwang.ssmxml.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jwang.ssmxml.beans.dao.SubjectDao;
import com.jwang.ssmxml.beans.dto.SubjectDto;
import com.jwang.ssmxml.common.constant.ResultCode;
import com.jwang.ssmxml.service.SubjectService;

/**
 * @author jwang
 * 课程信息
 */
@Controller
@RequestMapping(value="/subject")
public class SubjectController extends BaseController
{

	private static final Logger LOGGER = Logger.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	/**
	 * description:根据课程id获取课程信息
	 * @param response
	 * @param id
	 * @throws IOException 
	 */
	@RequestMapping(value="/getSubjectById/{id}", method=RequestMethod.GET)
	public void getSubjectById(HttpServletResponse response, @PathVariable("id") Integer id) throws IOException
	{
		LOGGER.info("get subject info by id start...");
		SubjectDao subjectDao = subjectService.getSubjectById(id);
		LOGGER.info("get subject info by id end...");
		returnToPage(response,gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, subjectDao)));
	} 
	
	/**
	 * description:新增课程信息
	 * @param response
	 * @param subjectDto
	 * @throws IOException 
	 */
	@RequestMapping(value="/addSubject", method=RequestMethod.PUT)
	public void addSubject(HttpServletResponse response, @RequestBody SubjectDto subjectDto) 
			throws IOException
	{
		LOGGER.info("add subject info start...");
		subjectService.addSubject(subjectDto);
		LOGGER.info("add subject info end...");
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, null)));
	}
	
	/**
	 * description：修改课程信息
	 * @param response
	 * @param subjectDto
	 * @throws IOException 
	 */
	@RequestMapping(value="/updateSubject", method=RequestMethod.POST)
	public void updateSubject(HttpServletResponse response, @RequestBody SubjectDto subjectDto)
			throws IOException
	{
		LOGGER.info("update subject info start...");
		subjectService.updateSubject(subjectDto);
		LOGGER.info("update subject info end...");
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, null)));
	}
	
	/**
	 * description:删除课程信息
	 * @param response
	 * @param id
	 * @throws IOException 
	 */
	@RequestMapping(value="/deleteSubject/{id}", method=RequestMethod.DELETE)
	public void deleteSubject(HttpServletResponse response, @PathVariable("id") Integer id)
			throws IOException
	{
		LOGGER.info("delete subject info by id start...");
		subjectService.deleteSubject(id);
		LOGGER.info("delete subject info by id end...");
		returnToPage(response, gson.toJson(bulidResultObj(ResultCode.SUCCESS_CODE, null, null)));
	}
	
}
