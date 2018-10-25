package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;
import cn.edu.hbpu.news.DAO.NewsUserDAO;
import cn.edu.hbpu.news.model.Page;
import cn.edu.hbpu.news.Factory.NewsAdminFactory;
import cn.edu.hbpu.news.Factory.NewsuserDAOFactory;
import cn.edu.hbpu.news.model.NewsUser;

public class ListUser extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op.equals("listUser")) {
			listUser(request, response);
		} else if (op.equals("delete")) {
			delete(request, response);

		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		PrintWriter out = response.getWriter();

		NewsUserDAO newsUserDao = NewsuserDAOFactory.getNewsuserDAOInstance();
		int result = newsUserDao.delete(userId);

		if (result == 0) {
			out.print("新闻用户删除失败");

		} else {
			out.print("新闻用户删除成功");
		}
	}

	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		NewsAdminDAO newsAdminDAO = NewsAdminFactory.getNewsAdminDAOInstance();
		HttpSession session = request.getSession();

		String type = newsAdminDAO.getAdminType((String) session.getAttribute("adminUser"));
		if (type.equals("1") || type.equals("2")) {

		} else {
			out.print("<script>alert('您不是超级管理员或普通管理员，无法访问！');window.location.href='index.jsp'</script>");
			return;
		}

		String num = request.getParameter("num");// 获取需要显示的页码
		// 第一次查询，每页设置查询的页码，pagenum就是1；
		int pageNum = 1;
		// 如果不是第一次查询，用户点击上一页和下一页的超链接的时候，就有num页码
		if (num != null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		NewsUserDAO newsUserDAO = NewsuserDAOFactory.getNewsuserDAOInstance();

		int totalRecordNum = newsUserDAO.getTotalRecordNum();// 获取总的记录数
		Page page = new Page(pageNum, totalRecordNum);// 构建分页对象
		List<NewsUser> newsList = newsUserDAO.getListByPage(page.getStartIndex(), page.getPageSize());// 分页查询
		page.setRecords(newsList);
		page.setUrl("/manager/ListUser?op=listUser");
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("newsUserDetail.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
