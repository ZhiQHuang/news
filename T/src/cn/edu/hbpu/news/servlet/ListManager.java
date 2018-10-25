package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;
import cn.edu.hbpu.news.Factory.NewsAdminFactory;
import cn.edu.hbpu.news.model.NewsAdmin;
import cn.edu.hbpu.news.model.Page;

public class ListManager extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op.equals("list")) {
			listManager(request, response);
		} else if (op.equals("delete")) {
			delete(request, response);
		} else if (op.equals("add")) {
			add(request, response);
		}

	}

	public void listManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		NewsAdminDAO newsAdminDAO = NewsAdminFactory.getNewsAdminDAOInstance();
		HttpSession session = request.getSession();
		String type = newsAdminDAO.getAdminType((String) session.getAttribute("adminUser"));
		if (!type.equals("1")) {
			out.print("<script>alert('�����ǳ�������Ա���޷����ʣ�');window.location.href='index.jsp'</script>");
			return;
		}
		String num = request.getParameter("num");// ��ȡ��Ҫ��ʾ��ҳ��
		// ��һ�β�ѯ��ÿҳ���ò�ѯ��ҳ�룬pagenum����1��
		int pageNum = 1;
		// ������ǵ�һ�β�ѯ���û������һҳ����һҳ�ĳ����ӵ�ʱ�򣬾���numҳ��
		if (num != null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		int totalRecordNum = newsAdminDAO.getTotalRecordNum();// ��ȡ�ܵļ�¼��
		Page page = new Page(pageNum, totalRecordNum);// ������ҳ����
		List<NewsAdmin> newsList = newsAdminDAO.getListByPage(page.getStartIndex(), page.getPageSize());// ��ҳ��ѯ
		page.setRecords(newsList);
		page.setUrl("/manager/ListManager?op=list");
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("changeManager.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("adminId");

		PrintWriter out = response.getWriter();
		NewsAdminDAO newsAdminDAO = NewsAdminFactory.getNewsAdminDAOInstance();
		int result = newsAdminDAO.delete(adminId);
		if (result == 0) {
			out.print("����ɾ��ʧ��");

		} else {
			out.print("����ɾ���ɹ�");
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		NewsAdminDAO newsAdminDAO = NewsAdminFactory.getNewsAdminDAOInstance();
		NewsAdmin newsAdmin = new NewsAdmin();
		newsAdmin.setUsername(username);
		newsAdmin.setPassword(password);
		newsAdmin.setType(type);

		PrintWriter out = response.getWriter();
		int result = newsAdminDAO.insert(newsAdmin);

		if (result == 0) {
			out.print("<script>alert('����Ա��Ϣ����ʧ��');window.location.href='addManager.jsp'</script>");

		} else {
			out.print("<script>alert('����Ա��Ϣ����ɹ�!');window.location.href='index.jsp'</script>");
		}

	}

}
