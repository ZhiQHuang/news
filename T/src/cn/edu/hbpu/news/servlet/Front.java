package cn.edu.hbpu.news.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.edu.hbpu.news.DAO.NewsDAO;
import cn.edu.hbpu.news.DAO.NewsClassDAO;
import cn.edu.hbpu.news.DAO.NewsUserDAO;
import cn.edu.hbpu.news.DAO.NoteDAO;
import cn.edu.hbpu.news.Factory.NewsDAOFactory;
import cn.edu.hbpu.news.Factory.NewsclassDAOFactory;
import cn.edu.hbpu.news.Factory.NewsuserDAOFactory;
import cn.edu.hbpu.news.Factory.NoteDAOFactory;
import cn.edu.hbpu.news.Util.MD5Util;
import cn.edu.hbpu.news.Util.WebUtil;
import cn.edu.hbpu.news.model.News;
import cn.edu.hbpu.news.model.NewsClass;
import cn.edu.hbpu.news.model.NewsUser;
import cn.edu.hbpu.news.model.Note;
import cn.edu.hbpu.news.model.Page;

//编写Servlet继承BaseServlet
public class Front extends BaseServlet {
	//访问路径：http://127.0.0.1:8090/news/Front?op=main
	public String main(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsClassDAO classDao = NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList = classDao.getList();
		request.setAttribute("classList", classList);

		NewsDAO newsDao = NewsDAOFactory.getNewsDAOInstance();

		// 显示置顶新闻
		News topNews = newsDao.getTopNews();
		topNews.setTime(WebUtil.formatTime(topNews.getNewsTime()));
		WebUtil.removeHtml(topNews);
		request.setAttribute("topNews", topNews);

		// 显示最新新闻
		List<News> recentNews = newsDao.getRecentNews(5);
		for(int i = 0;i<recentNews.size();i++){
			WebUtil.removeHtml(recentNews.get(i));
			}
		request.setAttribute("recentNews", recentNews);

		List<News> newsList1 = newsDao.getNewsByClassId(5, classList.get(0)
				.getClassId());
		WebUtil.removeHtml(newsList1.get(0));
		request.setAttribute("newsList1", newsList1);
		
		List<News> newsLista = newsDao.getNewsByClassId(5, classList.get(1)
				.getClassId());
		WebUtil.removeHtml(newsLista.get(0));
		request.setAttribute("newsLista", newsLista);

		List<List<News>> newsList2 = new ArrayList<List<News>>();
		int length = 5;
		if (classList.size() < 6) {
			length = classList.size() - 1;
		}
		for (int i = 1; i <= length; i++) {
			List<News> newsByClassId = newsDao.getNewsByClassId(8, classList
					.get(i).getClassId());
			for (News news : newsByClassId) {
				WebUtil.removeHtml(news);
			}
			newsList2.add(newsByClassId);
		}
		request.setAttribute("newsList2", newsList2);

		return "/index.jsp";

	}

	
	
	public String listAll(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//显示新闻分类
		//访问NewsclassDAO getList方法，将newsclass表的新闻分类信息存放到request对象里
		NewsClassDAO classDao=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDao.getList();
		request.setAttribute("classList", classList);
		
		String num=request.getParameter("num");//获取需要显示的页码
		//第一次查询，没有设置查询的页码，pageNum的值就是1
		int pageNum=1;
		//如果不是第一次查询，用户点击上一页和下一页超链接时，就有num页码
		if(num!=null&&!num.equals("")){
			pageNum=Integer.parseInt(num);
		}
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		int totalRecordNum=newsDAO.getVerifiedTotalRecordNum();//获取总的记录数
		Page page=new Page(pageNum, totalRecordNum);
		List<News> newsList=newsDAO.getVerifiedListByPage(page.getStartIndex(), page.getPageSize());//分页查询
		for(News news : newsList){
			WebUtil.removeHtml(news);
		}
		page.setRecords(newsList);//设置pageNum页显示的记录
		page.setUrl("/Front?op=listAll");//点击超链接跳转的url
		request.setAttribute("page", page);//将分页对象保存在request对象中，方便在页面显示
		//跳转到allnewsList.jsp分页显示新闻列表
		return "/allnewsList.jsp";
	}
	
	
	public String listByClass(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//显示新闻分类
		//访问NewsclassDAO getList方法，将newsclass表的新闻分类信息存放到request对象里
		NewsClassDAO classDao=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDao.getList();
		request.setAttribute("classList", classList);
		
		String num=request.getParameter("num");//获取需要显示的页码
		int pageNum=1;
		if(num!=null&&!num.equals("")){
			pageNum=Integer.parseInt(num);
		}
		String classId=request.getParameter("classId");
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		int totalRecordNum=newsDAO.getTotalRecordNumByClassId(classId);//获取总的记录数
		Page page=new Page(pageNum, totalRecordNum);
		List<News> newsList=newsDAO.getNewsByClassId(classId,page.getStartIndex(), page.getPageSize());//分页查询
		for(News news : newsList){
			WebUtil.removeHtml(news);
		}
		page.setRecords(newsList);//设置pageNum页显示的记录
		page.setUrl("/Front?op=listByClass&classId="+classId);//点击超链接跳转的url
		request.setAttribute("page", page);//将分页对象保存在request对象中，方便在页面显示
		//跳转到newsList.jsp分页显示新闻列表
		return "/newsList.jsp";
	}
	
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsClassDAO classDao = NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList = classDao.getList();
		request.setAttribute("classList", classList);

		String num = request.getParameter("num");
		int PageNum = 1;
		if (num != null && !num.equals("")) {
			PageNum = Integer.parseInt(num);
		}
		String q = request.getParameter("q");
		NewsDAO newsDao = NewsDAOFactory.getNewsDAOInstance();
		int totalRecordNum = newsDao.getTotalRecordNumByTitle(q);
		Page page = new Page(PageNum, totalRecordNum);
		List<News> newsList = newsDao.getNewsByTitle(q, page.getStartIndex(), page.getPageSize());
		for (News news : newsList) {
			WebUtil.removeHtml(news);
		}
		
		page.setRecords(newsList);
		page.setUrl("/Front?op=query&q="+q);
		request.setAttribute("page", page);
		return "/allnewsList.jsp";

	}

	
	
	//从页面获取新闻的newsId，访问DAO，获取新闻的全部内容，将内容存储到request对象中，
	//跳转到newsDetail.jsp页面显示该新闻全部内容
	public String displayNews(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//显示新闻分类
		//访问NewsclassDAO getList方法，将newsclass表的新闻分类信息存放到request对象里
		NewsClassDAO classDao=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDao.getList();
		request.setAttribute("classList", classList);
		
		String newsId=request.getParameter("newsId");//获取需要显示的新闻的newsId
		//访问DAO，获取新闻的全部内容
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		News news=newsDAO.getVerifiedNewsById(newsId);
		news.setTime(WebUtil.formatTime(news.getNewsTime()));
		int hits=news.getHits();
		hits++;
		news.setHits(hits);
		newsDAO.updateHits(news);
		//将分页对象保存在request对象中，方便在页面显示
		request.setAttribute("news", news);
		//跳转到allnewsList.jsp分页显示新闻列表
		return "/newsDetail.jsp";
	}
	
	
	//将List转换为JSONArray
	public String getNotes(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String newsId=request.getParameter("newsId");
		//获取需要显示的新闻的classId
		//访问DAO，获取新闻的评论列表
		NoteDAO noteDAO=NoteDAOFactory.getNoteDAOInstance();
		List<Note> list=noteDAO.getList(newsId);
		//将List转化为JSONList
		JSONArray array=new JSONArray();
		for(Note note:list){
			JSONObject object=new JSONObject();
			object.put("username", note.getUserName());
			object.put("content", note.getContent());
			object.put("time", WebUtil.formatTime(note.getNoteTime()));
			array.add(object);
		}
		PrintWriter out=response.getWriter();
		out.print(array);
		return "";
	}
	
	
	//获取页面传递的username、password，访问NewsuserDAO，判断用户名和密码是否正确，正确与否，在页面输出信息
	public String login(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String username=request.getParameter("username");
		//获取登录用户名
		String password=request.getParameter("password");
		//获取登录用户名
		NewsUserDAO newsuserDAO=NewsuserDAOFactory.getNewsuserDAOInstance();
		//String enpass=MD5Util.encoder(password);
		boolean exist=newsuserDAO.isExist(username, password);
		if(exist){
			//记录登录的用户名记录下Session
			HttpSession session =request.getSession();
			session.setAttribute("newsuser", username);
		}
		PrintWriter out=response.getWriter();
		out.print(exist);
		return "";
	}
	
	
	//获取页面参数newsId、content，从session获取username，
	//访问DAO，插入评论信息，返回发表评论是否成功的信息
	public String addNote(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		NoteDAO noteDAO=NoteDAOFactory.getNoteDAOInstance();
		Note note=WebUtil.fillBean(request, Note.class);
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("newsuser");
		if(username==null){//未登录
			out.print("您还没有登录，请先登录后再发表评论！");
		}else {
			//已登录
			note.setUserName(username);
			int result=noteDAO.insert(note);
			if(result==0){
				out.print("发表评论失败！");
			}else {
				out.print("发表评论成功！");
			}
		}
		return "";
	}
	
	
	//获取页面传递的用户民，访问DAO，判断判断用户名是否存在数据表中，存在，
	//让用户输入其他的用户名，不存在，可以使用该用户名。
	public String checkName(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		if(username!=null&&!username.equals("")&&username.length()>=6){
			NewsUserDAO newsuserDAO=NewsuserDAOFactory.getNewsuserDAOInstance();
			boolean result=newsuserDAO.existName(username);
			if(result){
				out.print("您输入的用户名已存在，请使用其他用户名！");
			}else {
				out.print("您输入的用户名可以使用！");
			}
		}else {
			out.print("您输入的用户名不合法，请使用其他用户名！");
		}
		return "";
	}
	
	
	//获取页面传递的参数，访问DAO，注册信息插入到数据表中
	//返回注册成功与否的信息
	public String regist(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		NewsUser user=WebUtil.fillBean(request, NewsUser.class);
		String vericode=request.getParameter("vericode");
		String vcodeString=(String) request.getSession().getAttribute("vCode");
		if(vcodeString.equalsIgnoreCase(vericode)){
			NewsUserDAO newsuserDAO=NewsuserDAOFactory.getNewsuserDAOInstance();
			if(user.getUsername()!=null&&user.getPassword()!=null&&
					!user.getUsername().equals("")&&!user.getPassword().equals("")){
				int result=newsuserDAO.insert(user);
				if(result==0){
					out.print("<script>alert('注册失败！');"+"</script>"+
					"window.location.href='regist.jsp"+"'</script>");
				}else {
					out.print("<script>alert('注册成功！');"+
							"window.location.href='Front?op=main"+"'</script>");
				}
			}else {
				out.print("<script>alert('注册信息有误！');"+"</script>"+
						"window.location.href='regist.jsp"+"'</script>");
			}
		}else {
			out.print("<script>alert('验证码有误！');"+
					"window.location.href='regist.jsp"+"'</script>");
		}
		return "";
	}


}
