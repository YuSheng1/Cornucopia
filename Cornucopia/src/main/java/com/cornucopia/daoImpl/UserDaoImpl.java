package com.cornucopia.daoImpl;

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
import com.cornucopia.dao.UserDao;


@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	// 查询用户基本信息
	@Override
	public List ListAll(Object... objects) {
		Session session = getSession();
		 StringBuffer buffer = new StringBuffer();
         buffer.append( " from  Users  u  inner  join fetch u.userrole ");
        Query query = session.createQuery(buffer.toString());
		 List list =   query.list();
		 System.out.println(list.size());
		return list;
		
	}

	@Override
	public void save(Object...object) {
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
	@Override
	public List ListAlltrue(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> Set<T> ListAllByName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> Set<String> ListResourcesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	//根据用户名查询信息
	@Override
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