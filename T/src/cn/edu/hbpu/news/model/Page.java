package cn.edu.hbpu.news.model;

import java.util.List;

public class Page {
	private int pageNumber;
	private int pageSize=8;
	private int totalPageNum;
	private int totalRecordNumber;
	private int startIndex;
	private int prePageNumber;
	private int nextPageNumber;
	private String url;
	private List records;
	public Page(int pageNumber, int totalRecordNumber){
		this.pageNumber=pageNumber;
		this.totalRecordNumber=totalRecordNumber;
		this.totalPageNum=totalRecordNumber%pageSize==0
		?totalRecordNumber/pageSize:totalRecordNumber/pageSize+1;
		this.startIndex=(pageNumber-1)*pageSize;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalRecordNumber() {
		return totalRecordNumber;
	}
	public void setTotalRecordNumber(int totalRecordNumber) {
		this.totalRecordNumber = totalRecordNumber;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPrePageNumber() {
		prePageNumber=pageNumber-1;
		if(prePageNumber<1){
			prePageNumber=1;
		}

		return prePageNumber;
	}
	public void setPrePageNumber(int prePageNumber) {
		this.prePageNumber = prePageNumber;
	}
	public int getNextPageNumber() {
		nextPageNumber=pageNumber+1;
		if(nextPageNumber>totalPageNum){
			nextPageNumber=totalPageNum;
		}
		return nextPageNumber;
	}
	public void setNextPageNumber(int nextPageNumber) {
		this.nextPageNumber = nextPageNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}

}
