package cn.edu.hbpu.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;

/**
 * Servlet implementation class changePassword
 */
public class changePassword extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out= response.getWriter();
		 System.out.println("1");
	     NewsAdminDAO newsAdminDAO=new NewsAdminDAO();
       HttpSession session=request.getSession();
       String username=(String)session.getAttribute("adminUser");
       String password=request.getParameter("password");
       String password2=request.getParameter("password2");
       String repassword=request.getParameter("repassword");
       if (password!=null&&!password.equals("")&&
       		password2!=null&&!password2.equals("")&&
       		repassword!=null&&!repassword.equals("")) {
       				   	
		
       if(newsAdminDAO .isExist(username, password))
       {
       	if (password2.equals(repassword)) {
       		
       		  newsAdminDAO.changePassword(username, repassword);
       		  System.out.println(repassword);
       		 //session�����¼��Ϣ
				   session.setAttribute("adminUser", username);
        		   out.print("<script>alert('�޸ĳɹ�');"+
    					"window.location.href='index.jsp'</script>");			   
    	  
				
				 
			}
       	else {
       		out.print("<script>alert('�������벻һ��');"+
   					"window.location.href='changePassword.jsp'</script>");			   
   	  
			}
			
		
       }else {
			out.print("<script>alert('ԭ���벻��ȷ');"+
					"window.location.href='changePassword.jsp'</script>");			   
	  
		}
    
       }else {
       	out.print("<script>alert('�������޸���Ϣ��');"+
					"window.location.href='changePassword.jsp'</script>");			   
	  
		}
		
		
	}
	}


