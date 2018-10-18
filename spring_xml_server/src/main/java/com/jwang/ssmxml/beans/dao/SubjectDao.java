package com.jwang.ssmxml.beans.dao;

public class SubjectDao 
{
	/**
	 * 课程ID
	 */
	private int id;
	
	/**
	 * 课程名称
	 */
	private String subjectName;
	
	/**
	 * 课程描述
	 */
	private String subjectDescription;

	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getSubjectName()
	{
		return subjectName;
	}

	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}

	public String getSubjectDescription() 
	{
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) 
	{
		this.subjectDescription = subjectDescription;
	}
	
}
