package com.cornucopia.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Users;
import com.cornucopia.dao.UserDao;


@Component("UserDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	// 查询用户基本信息
	@Override
	public List<Users> ListAll(Object... objects) {
		Session session = getSession();
		List<Users> User = session.createQuery("from Users").list();
		return User;
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
	public Object getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}