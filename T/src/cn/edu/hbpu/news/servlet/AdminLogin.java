package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import sun.security.mscapi.RSASignature.MD5;*/

import cn.edu.hbpu.news.DAO.NewsAdminDAO;
import cn.edu.hbpu.news.Util.MD5Util;
import cn.edu.hbpu.news.model.NewsAdmin;

public class AdminLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����get����
		doPost(request,response);//�����get����ִ��doPost����

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����post����
		/*1����ȡ�û���login.jspҳ��������û���������
		2���ж��û����������Ƿ���ȷ
		3���û�����������ȷ����ת��index.jsp
		4���û��������벻��ȷ����ʾ�û�����ȷ��ͣ����login.jspҳ��*/
		
		
		NewsAdminDAO a=new  NewsAdminDAO();
		//response.setContentType("text/html;charset=utf-8");
		//�����������Ӧ�ı����Լ�����
		PrintWriter out1=response.getWriter();
		//request.setCharacterEncoding("utf-8");
		
		//1����ȡ�û���login.jspҳ��������û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2���ж��û����������Ƿ���ȷ
		if(username!=null&&!username.equals("")&&!password.equals("")&&password!=null){
			String passString=MD5Util.encoder(password);
			if(a.isExist(username, password)){
				//3���û�����������ȷ����ת��index.jsp
				request.getRequestDispatcher("main.jsp").forward(request, response);
				//��ȡsession
				HttpSession session=request.getSession();
				//session�����¼��Ϣ
				session.setAttribute("adminUser", username);
				//�����Ի�����ʾ�û�
//				out1.print("<script>alert('��¼�ɹ���');" +
//						"window.location.href='index.jsp'</script>");
				//response.sendRedirect("index.jsp");
			}
			else{
				//4���û��������벻��ȷ����ʾ�û�����ȷ��ͣ����login.jspҳ��
//				out1.print("<script>alert('��¼ʧ�ܣ���������û�������������');" +
//				"window.location.href='login.jsp'</script>");
				//�����Ի���,��ʾ�û�
				request.setAttribute("msg", "��������û�������������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}else{
			out1.print("<script>alert('���������û��������룡');" +
			"window.location.href='login.jsp'</script>");
		}
		
	}

}
