package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;
import cn.edu.hbpu.news.Factory.NewsAdminFactory;
import cn.edu.hbpu.news.model.NewsAdmin;

public class insertManager extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  doPost(request, response);
		  
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String type=request.getParameter("type");
		
		 
		 NewsAdminDAO newsAdminDAO=NewsAdminFactory.getNewsAdminDAOInstance();
		 NewsAdmin newsAdmin=new NewsAdmin();
		 newsAdmin.setUsername(username);
		 newsAdmin.setPassword(password);
		 newsAdmin.setType(type);
		 
		 PrintWriter out=response.getWriter();
		int result=newsAdminDAO.insert(newsAdmin);
		
		
		if(result==0){
			out.print("<script>alert('管理员信息插入失败');window.location.href='addManager.jsp'</script>");
			
		}else{
			out.print("<script>alert('管理员信息插入成功!');window.location.href='index.jsp'</script>");
		}
		
	
		
	}

}
