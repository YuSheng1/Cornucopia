package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Member;
@Component
public class PM_UserManagemenDao {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	 //²éÑ¯½ÇÉ«
		public List<Member> ListmemberList() {
			Session session = getSession();
			List<Member> memberList = session.createQuery("from Member").list();
			return memberList;
		}
}
