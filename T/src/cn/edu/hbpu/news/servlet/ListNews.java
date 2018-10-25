package cn.edu.hbpu.news.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cn.edu.hbpu.news.DAO.NewsDAO;
import cn.edu.hbpu.news.DAO.NewsClassDAO;
import cn.edu.hbpu.news.Factory.NewsDAOFactory;
import cn.edu.hbpu.news.Factory.NewsclassDAOFactory;
import cn.edu.hbpu.news.Util.WebUtil;
import cn.edu.hbpu.news.model.Page;
import cn.edu.hbpu.news.model.News;
import cn.edu.hbpu.news.model.NewsClass;

public class ListNews extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 
		String op=request.getParameter("op");
		if(op.equals("listNews")){
			listNews(request,response);
		}else if (op.equals("preEdit")) {
			preEdit(request,response);
		}else if (op.equals("edit")) {
			edit(request,response);
		}else if (op.equals("add")) {
			add(request,response);
		}else if (op.equals("preAdd")) {
			preAdd(request,response);
		}else if (op.equals("verify")) {
			verify(request,response);
		}else if (op.equals("preVerify")) {
			preVerify(request,response);
		}else if (op.equals("delete")) {
			delete(request,response);
		}else if (op.equals("batchDel")) {
			batchDel(request,response);
		}else if (op.equals("query1")) {
			query1(request,response);
		}

}

	private void batchDel(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		String[] newsIds=request.getParameterValues("newsIds[]");
		NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
		int result=0;
		for(String id : newsIds){
			result=newsDao.delete(id);
		}
		PrintWriter out=response.getWriter();
		if (result==0) {
			out.print("批量删除失败");
		}else {
			out.print("批量删除成功");
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		String newsId=request.getParameter("newsId");
		NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
		int result=newsDao.delete(newsId);
		PrintWriter out=response.getWriter();
		if (result==0) {
			out.print("删除失败");
		}else {
			out.print("删除成功");
		}
	}

	private void preAdd(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		NewsClassDAO classDAO=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDAO.getList();
		request.setAttribute("classList",classList);
		request.getRequestDispatcher("form.jsp").forward(request,response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		boolean multipartContent=ServletFileUpload.isMultipartContent(request);
		if (!multipartContent) {
			throw new RuntimeException("the from is not multipart/form-data");			
		}
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu =new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		
		List<FileItem> items=new ArrayList<FileItem>();
		try{
		items=sfu.parseRequest(request);
		}catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		News news=new News();
		for(FileItem item:items){
			if(item.isFormField()){
			processFormField(item,news);
			}else {
				processUploadField(item,news);
			}
	   }
		
		NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
		int result=newsDao.update(news);
		if (result==0) {
			out.print("<script>alert('新闻修改失败');"+"window.location.href='ListNews?op=listNews'</script>");
		}else {
			out.print("<script>alert('新闻修改成功');"+"window.location.href='ListNews?op=listNews'</script>");
		}
	}

	private void preEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		String newsId=request.getParameter("newsId");
		NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
		News news =newsDao.getNewsById(newsId);
		request.setAttribute("news", news);
		NewsClassDAO classDAO=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDAO.getList();
		request.setAttribute("classList", classList);
		request.getRequestDispatcher("editNews.jsp").forward(request, response);
		
	}
	
	
	private void verify(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		boolean multipartContent=ServletFileUpload.isMultipartContent(request);
		if (!multipartContent) {
			throw new RuntimeException("the from is not multipart/form-data");			
		}
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu =new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		
		List<FileItem> items=new ArrayList<FileItem>();
		try{
		items=sfu.parseRequest(request);
		}catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		News news=new News();
		for(FileItem item:items){
			if(item.isFormField()){
			processFormField(item,news);
			}else {
				processUploadField(item,news);
			}
	   }
		
		NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
		int result=newsDao.update1(news);
		if (result==0) {
			out.print("<script>alert('新闻审核失败');"+"window.location.href='ListNews?op=listNews'</script>");
		}else {
			out.print("<script>alert('新闻审核成功');"+"window.location.href='ListNews?op=listNews'</script>");
		}
	}

	private void preVerify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		String newsId=request.getParameter("newsId");
		NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
		News news =newsDao.getNewsById(newsId);
		request.setAttribute("news", news);
		NewsClassDAO classDAO=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDAO.getList();
		request.setAttribute("classList", classList);
		request.getRequestDispatcher("verifyNews.jsp").forward(request, response);
		
	}
	

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		boolean multipartContent=ServletFileUpload.isMultipartContent(request);
		if (!multipartContent) {
			throw new RuntimeException("the from is not multipart/form-data");			
		}
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu =new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		
		List<FileItem> items=new ArrayList<FileItem>();
		try{
		items=sfu.parseRequest(request);
		}catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		News news=new News();
		for(FileItem item:items){
			if(item.isFormField()){
			processFormField(item,news);
			}else {
				processUploadField(item,news);
			}
	   }
		
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		int result=newsDAO.insert(news);				
		if (result==0) {
			out.print("<script>alert('新闻插入失败！');"+"window.location.href='ListNews?op=preAdd'</script>");
		}else {
			out.print("<script>alert('新闻插入成功！');"+"window.location.href='ListNews?op=listNews'</script>");
		}
	
	}


	private void processUploadField(FileItem item, News news) {
		// TODO Auto-generated method stub
		String storeDirectory=getServletContext().getRealPath("/images");
		File rootDirectory=new File(storeDirectory);
		if(!rootDirectory.exists()){
			rootDirectory.mkdirs();
			
		}
		String filename=item.getName();
		if (filename !=null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
			filename=sdf.format(new Date())+(int)(Math.random()*100)
			       +"."+FilenameUtils.getExtension(filename);
		    news.setPictures(filename);
		}
		try {
			item.write(new File(rootDirectory,filename));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	private void processFormField(FileItem item, News news) {
		// TODO Auto-generated method stub
		try {
			String fieldName=item.getFieldName();
			String fieldValue=item.getString("UTF-8");
			BeanUtils.setProperty(news, fieldName, fieldValue);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	private void listNews(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		  String num=request.getParameter("num");
	      int pageNum=1;
	      if (num!=null&&!num.equals("")) {
			pageNum=Integer.parseInt(num);
		}

	      NewsDAO newsDao=NewsDAOFactory.getNewsDAOInstance();
	      int totalRecordNum=newsDao.getTotalRecordNum();
	      Page page=new Page(pageNum, totalRecordNum);
	      List<News> newsList=newsDao.getListByPage(page.getStartIndex(),page.getPageSize());
	      page.setRecords(newsList);
	      page.setUrl("/manager/ListNews?op=listNews");
	      request.setAttribute("page", page);
	      request.getRequestDispatcher("newsList.jsp").forward(request, response);
	      
	      
		}
	
	
public void query1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		int PageNum = 1;
		if (num != null && !num.equals("")) {
			PageNum = Integer.parseInt(num);
		}
		String q = request.getParameter("q");
		NewsDAO newsDao = NewsDAOFactory.getNewsDAOInstance();
		int totalRecordNum = newsDao.getTotalRecordNumByTitle(q);
		Page page = new Page(PageNum, totalRecordNum);
		List<News> newsList = newsDao.getNewsByTitle(q, page.getStartIndex(), page.getPageSize());
		for (News news : newsList) {
			WebUtil.removeHtml(news);
		}

		page.setRecords(newsList);
		page.setUrl("/manager/ListNews?op=query&q=" + q);
		request.setAttribute("page", page);
		request.getRequestDispatcher("newsList.jsp").forward(request, response);

	}

		
	}

