package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Subject;

@Component
public class AG_SubjectDao {

	@Autowired
	private SessionFactory sf; 
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public List<Subject> ListAll(){
		Session session=getSession();
		List<Subject> slist=session.createQuery("from Subject").list();
		return slist;
	}
}
