package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cornucopia.bean.PushNotice;

@Component
public class PushNoticeDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public List<PushNotice>  ListAll(){
		Session session=getSession();
		List<PushNotice> list=session.createQuery("from PushNotice").list();
		return list;
	}
	
	public void delete(Object object){
		Session session=getSession();
		session.delete(object);
	}
	
	public void save(Object...objects){
		Session session=getSession();
		session.save(objects[0]);
	}
}
