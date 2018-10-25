package cn.edu.hbpu.news.Factory;

import cn.edu.hbpu.news.DAO.NewsUserDAO;

public class NewsuserDAOFactory {
	public static NewsUserDAO getNewsuserDAOInstance() {
		return new NewsUserDAO();
	}

}
