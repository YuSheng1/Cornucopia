package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Member;
@Component
public class ValidateDao {
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	// 根据昵称和手机号查询有没有这个人
		public Boolean UserLogin(String name,String password) {
			Session session = getSession();
			String hql = "from Member  where name='" + name + "'and password='" + password + "' or mobile_Phone='" + name + "' and password='" + password + "' ";
			List<Member> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				System.out.println("用户名密码匹配");
				return true;
			}
			return false;
		}

}
