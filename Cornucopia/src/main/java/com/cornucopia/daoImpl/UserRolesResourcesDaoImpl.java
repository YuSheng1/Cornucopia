package com.cornucopia.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;
@Component
public class UserRolesResourcesDaoImpl implements UserDao{
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//≤È—Ø∞ÂøÈ–≈œ¢
		@SuppressWarnings("unchecked")
		@Override
		public  List<Resources> ListAll(Object... objects) {
			Session session = getSession();
			List<Resources> UserRoleList = session.createQuery("from Resources ").list();
			return UserRoleList;
		}
		@Override
		public void save(Object...object) {
			Session session = getSession();
			int id=(int) object[1];
			delete(id);
			String[] sourceStrArray = ((String) object[0]).split(",");
			for (int i = 0; i < sourceStrArray.length; i++) {
				int i1=(Integer.parseInt(sourceStrArray[i]));
				UserRole userRole=(UserRole)session.get(UserRole.class, id);  
				Resources resources=(Resources)session.get(Resources.class,i1);
				userRole.getResour().add(resources);  
				resources.getResour().add(userRole);
			}
		}
		
		@Override
		public void delete(Object object) {
			Session session = getSession();
			int id=(int) object;
			String sql="delete  from role_res where rid="+id;
			session.createSQLQuery(sql).executeUpdate();
			session.flush();
			
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
		@Override
		public <T> List<T> ListAlltrue(int id) {
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

		@Override
		public <T> T getByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}
}
