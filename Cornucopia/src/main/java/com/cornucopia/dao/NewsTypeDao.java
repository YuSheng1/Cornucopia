package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.NewsType;

@Component
public class NewsTypeDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	

	public List<NewsType>  ListAll(){
		Session session=getSession();
		List<NewsType> list=session.createQuery("from NewsType").list();
		return list;
	}
}
