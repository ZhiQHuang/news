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
		//销毁的方法

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//FilterChain chain 过滤器链，可能有多个过滤器，多个过滤器组成过滤器链
		//过滤器的核心方法，起到过滤的作用
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("adminUser");
		//拦截manager路径下的jsp、Serclet
		//1、不拦截login.jsp,AdminLogin,继续访问
		//2、已登录，访问manager路径下的jsp、Serclet，不拦截，继续访问
		//3、未登录，访问manager路径下的出Login.jsp,AdminLogin之外的jsp、Serclet
		//得到URL
		String uri=req.getRequestURI();
		//判断URL，如果URL以login.jsp或AdminLogin结尾的话，就不拦截
		if(uri.endsWith("login.jsp")||uri.endsWith("AdminLogin")
				||uri.endsWith("css")||uri.endsWith("png")||uri.endsWith("js")){
			//不拦截
			//FilterChain:doFilter是导致过滤器链的下一个过滤器执行，
			//如果当过滤器就是最后一个过滤器，直接访问请求的资源
			chain.doFilter(req,res);
		}
		else if(username!=null){
			//已登录，访问manager路径下的jsp、Serclet，不拦截，继续访问
			chain.doFilter(req,res);
		}else{
			//未登录，访问manager路径下的出Login.jsp,AdminLogin之外的jsp、Serclet
			//跳转到login.jsp
			res.sendRedirect("login.jsp");
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		//初始化的方法

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
