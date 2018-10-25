package cn.edu.hbpu.news.Factory;

import cn.edu.hbpu.news.DAO.NewsDAO;

public class NewsDAOFactory {
	public static NewsDAO getNewsDAOInstance() {
		return new NewsDAO();
	}

}
