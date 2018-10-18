package com.jwang.ssmxml.beans.bo;

import java.io.Serializable;

/**
 * @author jwang
 * 分页信息
 */
public class PageInfo implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 805836718307507891L;

	private int size;
	
	private int currentPage;
	
	private int total;
	
	private int from;

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getTotal() 
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getFrom()
	{
		return from;
	}

	public void setFrom(int currentPage, int size)
	{
		this.from = currentPage*size+1;;
	}
	
}
