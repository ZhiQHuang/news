package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbpu.news.DAO.NewsClassDAO;
import cn.edu.hbpu.news.Factory.NewsclassDAOFactory;
import cn.edu.hbpu.news.model.NewsClass;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class PreAddNews extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NewsClassDAO classDAO=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDAO.getList();
		request.setAttribute("classList",classList);
		request.getRequestDispatcher("addNews.jsp").forward(request,response);
	}

}
