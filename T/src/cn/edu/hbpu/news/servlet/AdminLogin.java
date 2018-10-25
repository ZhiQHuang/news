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
		//处理get请求
		doPost(request,response);//如果是get请求，执行doPost方法

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理post请求
		/*1、获取用户在login.jsp页面输入的用户名和密码
		2、判断用户名和密码是否正确
		3、用户名和密码正确，跳转到index.jsp
		4、用户名和密码不正确，提示用户不正确，停留在login.jsp页面*/
		
		
		NewsAdminDAO a=new  NewsAdminDAO();
		//response.setContentType("text/html;charset=utf-8");
		//代表服务器相应的编码以及类型
		PrintWriter out1=response.getWriter();
		//request.setCharacterEncoding("utf-8");
		
		//1、获取用户在login.jsp页面输入的用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2、判断用户名和密码是否正确
		if(username!=null&&!username.equals("")&&!password.equals("")&&password!=null){
			String passString=MD5Util.encoder(password);
			if(a.isExist(username, password)){
				//3、用户名和密码正确，跳转到index.jsp
				request.getRequestDispatcher("main.jsp").forward(request, response);
				//获取session
				HttpSession session=request.getSession();
				//session存入登录信息
				session.setAttribute("adminUser", username);
				//弹出对话框，提示用户
//				out1.print("<script>alert('登录成功！');" +
//						"window.location.href='index.jsp'</script>");
				//response.sendRedirect("index.jsp");
			}
			else{
				//4、用户名和密码不正确，提示用户不正确，停留在login.jsp页面
//				out1.print("<script>alert('登录失败，你输入的用户名或密码有误！');" +
//				"window.location.href='login.jsp'</script>");
				//弹出对话框,提示用户
				request.setAttribute("msg", "你输入的用户名或密码有误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}else{
			out1.print("<script>alert('请您输入用户名和密码！');" +
			"window.location.href='login.jsp'</script>");
		}
		
	}

}
