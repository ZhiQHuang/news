package cn.edu.hbpu.news.Factory;

import cn.edu.hbpu.news.DAO.NoteDAO;

public class NoteDAOFactory {
	public static NoteDAO getNoteDAOInstance() {
		return new NoteDAO();
	}

}
