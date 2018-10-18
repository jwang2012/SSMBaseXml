package com.jwang.ssmxml.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jwang.ssmxml.beans.dao.SubjectDao;
import com.jwang.ssmxml.beans.dto.SubjectDto;
import com.jwang.ssmxml.mapper.SubjectMapper;
import com.jwang.ssmxml.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService
{
	private static final Logger LOGGER = Logger.getLogger(SubjectServiceImpl.class);

	@Autowired
	private SubjectMapper subjectMapper;
	
	/**
	 * 说明：
	 * （1）value指的是将数据缓存在哪一个cache对象中。我们一般都为不同的方法指定不同的域（cache对象）
	 * 	        配置在ehcache.xml文件中。
	 * （2）key属性是用来指定Spring缓存方法的返回结果时对应的key的。该属性支持SpringEL表达式。
	 * 	       当我们没有指定该属性时，Spring将使用默认策略生成key。我们这里先来看看自定义策略，至于默认策略会在后文单独介绍。
	 * （3）condition是缓存执行的条件，下面的意思是当传入的参数为偶数时将结果进行缓存
	 */
	@Cacheable(value="subject",key="#id",condition="#id%2==0")
	@Override
	public SubjectDao getSubjectById(Integer id) 
	{
		LOGGER.info("get data from database!");
		return subjectMapper.getSubjectById(id);
	}

	@Override
	public void addSubject(SubjectDto subjectDto)
	{
		int key = subjectMapper.addSubject(subjectDto);
		LOGGER.info("this add the primary key is:"+key);
	}

	@Override
	public void updateSubject(SubjectDto subjectDto) 
	{
		subjectMapper.updateSubject(subjectDto);
	}

	@Override
	public void deleteSubject(Integer id) 
	{
		subjectMapper.deleteSubject(id);
	}

}
