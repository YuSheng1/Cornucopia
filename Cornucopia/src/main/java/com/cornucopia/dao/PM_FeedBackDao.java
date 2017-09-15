package com.cornucopia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Feedback;

//意见反馈dao
@Component
public class PM_FeedBackDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	//查询所有新闻
	public List<Feedback>  ListAll(Object...objects){
		Session session = getSession();
		 StringBuffer buffer = new StringBuffer();
		  buffer.append( " from Feedback f  inner  join fetch  f.member ");
	        Query query = session.createQuery(buffer.toString());
			 List list =   query.list();
			 System.out.println(list.size());
			return list;
	}
}
