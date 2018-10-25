package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;
import cn.edu.hbpu.news.DAO.NewsUserDAO;
import cn.edu.hbpu.news.Factory.NewsAdminFactory;
import cn.edu.hbpu.news.Factory.NewsuserDAOFactory;
import cn.edu.hbpu.news.model.NewsAdmin;
import cn.edu.hbpu.news.model.NewsUser;

public class addUser extends HttpServlet {

	
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
		 String sex=request.getParameter("sex");
		 String question=request.getParameter("question");
		 String answer=request.getParameter("answer");
	     String emailAddr=request.getParameter("emailAddr");
	     String qq=request.getParameter("qq");
		 System.out.println(username);
		 System.out.println(password);
	     NewsUserDAO newsUserDao=NewsuserDAOFactory.getNewsuserDAOInstance();
	     NewsUser newsUser=new NewsUser();
		 newsUser.setUsername(username);
		 newsUser.setPassword(password);
		 newsUser.setSex(sex);
		 newsUser.setQuestion(question);
		 newsUser.setAnswer(answer);
		 newsUser.setEmailAddr(emailAddr);
		 newsUser.setQq(qq);
	
		 
		 PrintWriter out=response.getWriter();
		int result=newsUserDao.insert(newsUser);
		
		
		if(result==0){
			out.print("<script>alert('新闻用户增加失败');window.location.href='addUser.jsp'</script>");
			
		}else{
			out.print("<script>alert('新闻用户增加成功!');window.location.href='index.jsp'</script>");
		}
		
	
		
	}
		
	}


