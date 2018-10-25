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
			out.print("�����û�ɾ��ʧ��");

		} else {
			out.print("�����û�ɾ���ɹ�");
		}
	}

	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		NewsAdminDAO newsAdminDAO = NewsAdminFactory.getNewsAdminDAOInstance();
		HttpSession session = request.getSession();

		String type = newsAdminDAO.getAdminType((String) session.getAttribute("adminUser"));
		if (type.equals("1") || type.equals("2")) {

		} else {
			out.print("<script>alert('�����ǳ�������Ա����ͨ����Ա���޷����ʣ�');window.location.href='index.jsp'</script>");
			return;
		}

		String num = request.getParameter("num");// ��ȡ��Ҫ��ʾ��ҳ��
		// ��һ�β�ѯ��ÿҳ���ò�ѯ��ҳ�룬pagenum����1��
		int pageNum = 1;
		// ������ǵ�һ�β�ѯ���û������һҳ����һҳ�ĳ����ӵ�ʱ�򣬾���numҳ��
		if (num != null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		NewsUserDAO newsUserDAO = NewsuserDAOFactory.getNewsuserDAOInstance();

		int totalRecordNum = newsUserDAO.getTotalRecordNum();// ��ȡ�ܵļ�¼��
		Page page = new Page(pageNum, totalRecordNum);// ������ҳ����
		List<NewsUser> newsList = newsUserDAO.getListByPage(page.getStartIndex(), page.getPageSize());// ��ҳ��ѯ
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
