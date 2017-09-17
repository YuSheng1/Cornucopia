package com.cornucopia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AG_UserPlayDao {
	@Autowired
	public SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	// 购买时添加交易记录表
	public void save(Object... objects) {
		Session session = getsession();
		session.save(objects[0]);
	}
	//注册表添加数据
	public void savemember(Object... objects){
		Session session = getsession();
		session.save(objects[0]);
	}
}
