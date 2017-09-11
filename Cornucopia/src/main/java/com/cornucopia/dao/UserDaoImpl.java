package com.cornucopia.dao;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.Users;


@Component
public class UserDaoImpl  {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	// 查询用户基本信息
	public List ListAll() {
		Session session = getSession();
		 StringBuffer buffer = new StringBuffer();
         buffer.append( " from  Users  u  inner  join fetch u.userrole ");
        Query query = session.createQuery(buffer.toString());
		 List list =   query.list();
		 System.out.println(list.size());
		return list;
		
	}

	
	//根据用户名查询信息
	public  Users getByName(String name) {
		Session session=getSession();
		String hql="from Users u where u.user_name='"+name+"'";
		List<Users> list=session.createQuery(hql).list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}


}