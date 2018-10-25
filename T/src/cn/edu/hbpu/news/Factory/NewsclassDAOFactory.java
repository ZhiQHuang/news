package cn.edu.hbpu.news.Factory;

import cn.edu.hbpu.news.DAO.NewsClassDAO;

public class NewsclassDAOFactory {
	public static NewsClassDAO getNewsclassDAOInstance() {
		return new NewsClassDAO();
	}

}
