package com.cornucopia.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public  List<UserRole> ListAll(Object... objects) {
		Session session = getSession();
		List<UserRole> UserRoleList = session.createQuery("from UserRole").list();
		return UserRoleList;
	}
	
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	
}