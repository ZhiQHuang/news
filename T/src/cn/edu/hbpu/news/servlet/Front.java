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

//��дServlet�̳�BaseServlet
public class Front extends BaseServlet {
	//����·����http://127.0.0.1:8090/news/Front?op=main
	public String main(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsClassDAO classDao = NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList = classDao.getList();
		request.setAttribute("classList", classList);

		NewsDAO newsDao = NewsDAOFactory.getNewsDAOInstance();

		// ��ʾ�ö�����
		News topNews = newsDao.getTopNews();
		topNews.setTime(WebUtil.formatTime(topNews.getNewsTime()));
		WebUtil.removeHtml(topNews);
		request.setAttribute("topNews", topNews);

		// ��ʾ��������
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
		//��ʾ���ŷ���
		//����NewsclassDAO getList��������newsclass������ŷ�����Ϣ��ŵ�request������
		NewsClassDAO classDao=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDao.getList();
		request.setAttribute("classList", classList);
		
		String num=request.getParameter("num");//��ȡ��Ҫ��ʾ��ҳ��
		//��һ�β�ѯ��û�����ò�ѯ��ҳ�룬pageNum��ֵ����1
		int pageNum=1;
		//������ǵ�һ�β�ѯ���û������һҳ����һҳ������ʱ������numҳ��
		if(num!=null&&!num.equals("")){
			pageNum=Integer.parseInt(num);
		}
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		int totalRecordNum=newsDAO.getVerifiedTotalRecordNum();//��ȡ�ܵļ�¼��
		Page page=new Page(pageNum, totalRecordNum);
		List<News> newsList=newsDAO.getVerifiedListByPage(page.getStartIndex(), page.getPageSize());//��ҳ��ѯ
		for(News news : newsList){
			WebUtil.removeHtml(news);
		}
		page.setRecords(newsList);//����pageNumҳ��ʾ�ļ�¼
		page.setUrl("/Front?op=listAll");//�����������ת��url
		request.setAttribute("page", page);//����ҳ���󱣴���request�����У�������ҳ����ʾ
		//��ת��allnewsList.jsp��ҳ��ʾ�����б�
		return "/allnewsList.jsp";
	}
	
	
	public String listByClass(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//��ʾ���ŷ���
		//����NewsclassDAO getList��������newsclass������ŷ�����Ϣ��ŵ�request������
		NewsClassDAO classDao=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDao.getList();
		request.setAttribute("classList", classList);
		
		String num=request.getParameter("num");//��ȡ��Ҫ��ʾ��ҳ��
		int pageNum=1;
		if(num!=null&&!num.equals("")){
			pageNum=Integer.parseInt(num);
		}
		String classId=request.getParameter("classId");
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		int totalRecordNum=newsDAO.getTotalRecordNumByClassId(classId);//��ȡ�ܵļ�¼��
		Page page=new Page(pageNum, totalRecordNum);
		List<News> newsList=newsDAO.getNewsByClassId(classId,page.getStartIndex(), page.getPageSize());//��ҳ��ѯ
		for(News news : newsList){
			WebUtil.removeHtml(news);
		}
		page.setRecords(newsList);//����pageNumҳ��ʾ�ļ�¼
		page.setUrl("/Front?op=listByClass&classId="+classId);//�����������ת��url
		request.setAttribute("page", page);//����ҳ���󱣴���request�����У�������ҳ����ʾ
		//��ת��newsList.jsp��ҳ��ʾ�����б�
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

	
	
	//��ҳ���ȡ���ŵ�newsId������DAO����ȡ���ŵ�ȫ�����ݣ������ݴ洢��request�����У�
	//��ת��newsDetail.jspҳ����ʾ������ȫ������
	public String displayNews(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		//��ʾ���ŷ���
		//����NewsclassDAO getList��������newsclass������ŷ�����Ϣ��ŵ�request������
		NewsClassDAO classDao=NewsclassDAOFactory.getNewsclassDAOInstance();
		List<NewsClass> classList=classDao.getList();
		request.setAttribute("classList", classList);
		
		String newsId=request.getParameter("newsId");//��ȡ��Ҫ��ʾ�����ŵ�newsId
		//����DAO����ȡ���ŵ�ȫ������
		NewsDAO newsDAO=NewsDAOFactory.getNewsDAOInstance();
		News news=newsDAO.getVerifiedNewsById(newsId);
		news.setTime(WebUtil.formatTime(news.getNewsTime()));
		int hits=news.getHits();
		hits++;
		news.setHits(hits);
		newsDAO.updateHits(news);
		//����ҳ���󱣴���request�����У�������ҳ����ʾ
		request.setAttribute("news", news);
		//��ת��allnewsList.jsp��ҳ��ʾ�����б�
		return "/newsDetail.jsp";
	}
	
	
	//��Listת��ΪJSONArray
	public String getNotes(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String newsId=request.getParameter("newsId");
		//��ȡ��Ҫ��ʾ�����ŵ�classId
		//����DAO����ȡ���ŵ������б�
		NoteDAO noteDAO=NoteDAOFactory.getNoteDAOInstance();
		List<Note> list=noteDAO.getList(newsId);
		//��Listת��ΪJSONList
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
	
	
	//��ȡҳ�洫�ݵ�username��password������NewsuserDAO���ж��û����������Ƿ���ȷ����ȷ�����ҳ�������Ϣ
	public String login(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String username=request.getParameter("username");
		//��ȡ��¼�û���
		String password=request.getParameter("password");
		//��ȡ��¼�û���
		NewsUserDAO newsuserDAO=NewsuserDAOFactory.getNewsuserDAOInstance();
		//String enpass=MD5Util.encoder(password);
		boolean exist=newsuserDAO.isExist(username, password);
		if(exist){
			//��¼��¼���û�����¼��Session
			HttpSession session =request.getSession();
			session.setAttribute("newsuser", username);
		}
		PrintWriter out=response.getWriter();
		out.print(exist);
		return "";
	}
	
	
	//��ȡҳ�����newsId��content����session��ȡusername��
	//����DAO������������Ϣ�����ط��������Ƿ�ɹ�����Ϣ
	public String addNote(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		NoteDAO noteDAO=NoteDAOFactory.getNoteDAOInstance();
		Note note=WebUtil.fillBean(request, Note.class);
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("newsuser");
		if(username==null){//δ��¼
			out.print("����û�е�¼�����ȵ�¼���ٷ������ۣ�");
		}else {
			//�ѵ�¼
			note.setUserName(username);
			int result=noteDAO.insert(note);
			if(result==0){
				out.print("��������ʧ�ܣ�");
			}else {
				out.print("�������۳ɹ���");
			}
		}
		return "";
	}
	
	
	//��ȡҳ�洫�ݵ��û��񣬷���DAO���ж��ж��û����Ƿ�������ݱ��У����ڣ�
	//���û������������û����������ڣ�����ʹ�ø��û�����
	public String checkName(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		if(username!=null&&!username.equals("")&&username.length()>=6){
			NewsUserDAO newsuserDAO=NewsuserDAOFactory.getNewsuserDAOInstance();
			boolean result=newsuserDAO.existName(username);
			if(result){
				out.print("��������û����Ѵ��ڣ���ʹ�������û�����");
			}else {
				out.print("��������û�������ʹ�ã�");
			}
		}else {
			out.print("��������û������Ϸ�����ʹ�������û�����");
		}
		return "";
	}
	
	
	//��ȡҳ�洫�ݵĲ���������DAO��ע����Ϣ���뵽���ݱ���
	//����ע��ɹ�������Ϣ
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
					out.print("<script>alert('ע��ʧ�ܣ�');"+"</script>"+
					"window.location.href='regist.jsp"+"'</script>");
				}else {
					out.print("<script>alert('ע��ɹ���');"+
							"window.location.href='Front?op=main"+"'</script>");
				}
			}else {
				out.print("<script>alert('ע����Ϣ����');"+"</script>"+
						"window.location.href='regist.jsp"+"'</script>");
			}
		}else {
			out.print("<script>alert('��֤������');"+
					"window.location.href='regist.jsp"+"'</script>");
		}
		return "";
	}


}
