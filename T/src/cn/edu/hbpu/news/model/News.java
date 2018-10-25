package cn.edu.hbpu.news.model;

import java.sql.Date;

public class News {
	private int newsId;
	private int classId;
	private String headTitle;
	private String content;
	private String author;
	private String editor;
	private String newsFrom;
	private int top;
	private Date newsTime;
	private int hits;
	private String state;
	private String pictures;
	private int isDel;
	private String time;
	private String className;
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getHeadTitle() {
		return headTitle;
	}
	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getNewsFrom() {
		return newsFrom;
	}
	public void setNewsFrom(String newsFrom) {
		this.newsFrom = newsFrom;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public Date getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPictures() {
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassName() {
		return className;
	}
	
	/*public News(int newsId, int classId, String headTitle, String content,
			String author, String editor, String newsFrom, int top,
			Date newsTime, int hits, String state, String pictures, int isDel,
			String time) {
		super();
		this.newsId = newsId;
		this.classId = classId;
		this.headTitle = headTitle;
		this.content = content;
		this.author = author;
		this.editor = editor;
		this.newsFrom = newsFrom;
		this.top = top;
		this.newsTime = newsTime;
		this.hits = hits;
		this.state = state;
		this.pictures = pictures;
		this.isDel = isDel;
		this.time = time;
	}*/
	

}
