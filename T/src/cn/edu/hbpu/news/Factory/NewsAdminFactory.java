package cn.edu.hbpu.news.Factory;

import cn.edu.hbpu.news.DAO.NewsAdminDAO;

public class NewsAdminFactory {
public static NewsAdminDAO  getNewsAdminDAOInstance () {
	return new NewsAdminDAO();
	
}
}
