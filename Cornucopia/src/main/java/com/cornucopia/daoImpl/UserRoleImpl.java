package com.cornucopia.daoImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> ListAll(Object... objects) {
		Session session = getSession();
		List<UserRole> UserRoleList = session.createQuery("from UserRole").list();
		return UserRoleList;
	}
	//查询是否勾选
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
		public List ListAlltrue(int id) {
		System.out.println(id);
		String sql="select pid from role_res where rid="+id;
		List UserRoleList=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			return UserRoleList;
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
	public <T> T getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
         //根据用户名查询角色
	@SuppressWarnings("unchecked")
	@Override
	     public  Set<String> ListAllByName(Object object) {
		
			Session session=getSession();
			String sql="select r.cname from users u,user_role r where u.rid=r.id "
					+ " and u.user_name= '"+object+"'";
			List<String> rnameList=session.createSQLQuery(sql).list();
			session.flush();
			Set< String > set=new HashSet<String>(rnameList);
			System.out.println(set.size()+"用户角色");
			return set;
		}
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> ListResourcesByName(String userName) {
		Session session=getSession();
		String sql="select res.resources_name from role_res re,user_role r,users u,resources res where u.rid=r.id and r.id=re.rid and res.resources_id=re.pid "
				+ " and u.user_name='"+userName+"'";
		List<String> pnameList= session.createSQLQuery(sql).list();
		Set< String > set=new HashSet<String>(pnameList);
		System.out.println(pnameList.size()+"权限");
		return set;
	}

	@Override
	public <T> T getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
