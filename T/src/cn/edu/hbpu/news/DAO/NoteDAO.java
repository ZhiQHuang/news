package cn.edu.hbpu.news.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.hbpu.news.Util.DBCPUtils;
import cn.edu.hbpu.news.model.News;
import cn.edu.hbpu.news.model.Note;

public class NoteDAO {
	QueryRunner runner=new QueryRunner(DBCPUtils.getDataSource());
	public List<Note> getList(String newsId){
		List<Note> list=new ArrayList<Note>();
		String sql="select * from note where isDel=0 and newsId=? "
			+"order by noteId desc ";
		BeanListHandler<Note> bh
		=new BeanListHandler<Note>(Note.class);
		//因为返回结果是List集合，所以使用BeanListHandler，
		//而不使用BeanHandler（代表返回结果为单个对象）
		try {
			list=runner.query(sql,bh,newsId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int insert(Note note) {
		int result=0;
		String sql="insert into note(username,content,noteTime,newsId,isDel) "+
		"values(?,?,now(),?,0)";
		
		try {
			result=runner.update(sql,note.getUserName(),
					note.getContent(),
					note.getNewsId());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

}
