package com.example.demo.pojo;

public class PageParam {
	private int currPage;
	private int totalPage;
	private int rowCount;
	public static int pageSize=3;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		int totalPage=rowCount /pageSize;
		if(rowCount % pageSize >0)
		{
			totalPage+=1;
		}
		setTotalPage(totalPage);
		this.rowCount = rowCount;
	}
	
	public static int getPageSize() {
		return pageSize;
	}
	public static void setPageSize(int pageSize) {
		PageParam.pageSize = pageSize;
	}
	
}
