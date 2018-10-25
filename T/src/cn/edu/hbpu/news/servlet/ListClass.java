package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;
import cn.edu.hbpu.news.DAO.NewsClassDAO;
import cn.edu.hbpu.news.Factory.NewsAdminFactory;
import cn.edu.hbpu.news.Factory.NewsclassDAOFactory;
import cn.edu.hbpu.news.model.NewsClass;
import cn.edu.hbpu.news.model.Page;

public class ListClass extends BaseServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op.equals("listClass")) {
			listClass(request, response);
		} else if (op.equals("delete")) {
			delete(request, response);
		} else if (op.equals("add")) {
			add(request, response);
		}

	}

	public void listClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		NewsAdminDAO newsAdminDAO = NewsAdminFactory.getNewsAdminDAOInstance();
		HttpSession session = request.getSession();

		String type = newsAdminDAO.getAdminType((String) session.getAttribute("adminUser"));
		if (type.equals("1") || type.equals("2")) {

		} else {
			out.print("<script>alert('�����ǳ�������Ա����ͨ����Ա���޷����ʣ�');window.location.href='index.jsp'</script>");
			return;
		}
		NewsClassDAO newsClassDAO = NewsclassDAOFactory.getNewsclassDAOInstance();
		String num = request.getParameter("num");// ��ȡ��Ҫ��ʾ��ҳ��
		// ��һ�β�ѯ��ÿҳ���ò�ѯ��ҳ�룬pagenum����1��
		int pageNum = 1;
		// ������ǵ�һ�β�ѯ���û������һҳ����һҳ�ĳ����ӵ�ʱ�򣬾���numҳ��
		if (num != null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		int totalRecordNum = newsClassDAO.getTotalRecordNum();// ��ȡ�ܵļ�¼��
		Page page = new Page(pageNum, totalRecordNum);// ������ҳ����
		List<NewsClass> newsList = newsClassDAO.getListByPage(page.getStartIndex(), page.getPageSize());// ��ҳ��ѯ
		page.setRecords(newsList);
		page.setUrl("/manager/ListClass?op=listClass");
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("classList.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");

		PrintWriter out = response.getWriter();
		NewsClassDAO newsClassDAO = NewsclassDAOFactory.getNewsclassDAOInstance();
		int result = newsClassDAO.delete(classId);
		if (result == 0) {
			out.print("���ŷ���ɾ��ʧ��");

		} else {
			out.print("���ŷ���ɾ���ɹ�");
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String content = request.getParameter("content");
		NewsClassDAO newsClassDAO = NewsclassDAOFactory.getNewsclassDAOInstance();
		NewsClass newsClass = new NewsClass();

		newsClass.setContent(content);

		PrintWriter out = response.getWriter();
		int result = newsClassDAO.insert(newsClass);

		if (result == 0) {
			out.print("<script>alert('������������ʧ��');window.location.href='addClass.jsp'</script>");

		} else {
			out.print("<script>alert('�����������ӳɹ�!');window.location.href='index.jsp'</script>");
		}

	}

}
