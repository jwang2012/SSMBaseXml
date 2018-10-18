package com.jwang.ssmxml.service;

import com.jwang.ssmxml.beans.dao.SubjectDao;
import com.jwang.ssmxml.beans.dto.SubjectDto;

public interface SubjectService 
{
	
	SubjectDao getSubjectById(Integer id);
	
	void addSubject(SubjectDto subjectDto);
	
	void updateSubject(SubjectDto subjectDto);
	
	void deleteSubject(Integer id);
}
