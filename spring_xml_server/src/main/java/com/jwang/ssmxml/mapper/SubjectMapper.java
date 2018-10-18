package com.jwang.ssmxml.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwang.ssmxml.beans.dao.SubjectDao;
import com.jwang.ssmxml.beans.dto.SubjectDto;

@Repository
public interface SubjectMapper 
{
	SubjectDao getSubjectById(@Param("id")Integer id);
	
	int addSubject(@Param("subjectDto")SubjectDto subjectDto);
	
	void updateSubject(@Param("subjectDto")SubjectDto subjectDto);
	
	void deleteSubject(@Param("id")Integer id);

}
