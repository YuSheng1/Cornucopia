package com.cornucopia.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.Role_res;
import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;
@Component
public class UserRoleImpl implements UserDao {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	 //查询角色信息
	@Override
	public List<UserRole> ListAll(Object... objects) {
		Session session = getSession();
		List<UserRole> UserRoleList = session.createQuery("from UserRole").list();
		return UserRoleList;
	}
	//查询板块信息
	@Override
	public List<Resources> ListAllRole() {
		Session session = getSession();
		List<Resources> UserRoleList = session.createQuery("from Resources ").list();
		return UserRoleList;
	}
	//查询是否勾选
	@Override
		public List ListAlltrue(int id) {
		System.out.println(id);
		String sql="select pid from role_res where rid="+id;
		List UserRoleList=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
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
