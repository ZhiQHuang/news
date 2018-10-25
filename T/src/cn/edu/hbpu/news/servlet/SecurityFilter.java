package cn.edu.hbpu.news.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		//���ٵķ���

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//FilterChain chain ���������������ж���������������������ɹ�������
		//�������ĺ��ķ������𵽹��˵�����
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("adminUser");
		//����manager·���µ�jsp��Serclet
		//1��������login.jsp,AdminLogin,��������
		//2���ѵ�¼������manager·���µ�jsp��Serclet�������أ���������
		//3��δ��¼������manager·���µĳ�Login.jsp,AdminLogin֮���jsp��Serclet
		//�õ�URL
		String uri=req.getRequestURI();
		//�ж�URL�����URL��login.jsp��AdminLogin��β�Ļ����Ͳ�����
		if(uri.endsWith("login.jsp")||uri.endsWith("AdminLogin")
				||uri.endsWith("css")||uri.endsWith("png")||uri.endsWith("js")){
			//������
			//FilterChain:doFilter�ǵ��¹�����������һ��������ִ�У�
			//������������������һ����������ֱ�ӷ����������Դ
			chain.doFilter(req,res);
		}
		else if(username!=null){
			//�ѵ�¼������manager·���µ�jsp��Serclet�������أ���������
			chain.doFilter(req,res);
		}else{
			//δ��¼������manager·���µĳ�Login.jsp,AdminLogin֮���jsp��Serclet
			//��ת��login.jsp
			res.sendRedirect("login.jsp");
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		//��ʼ���ķ���

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
