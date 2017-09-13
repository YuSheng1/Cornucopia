package com.cornucopia.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cornucopia.bean.UserRole;
import com.cornucopia.bean.Users;
@Component
public class PM_UserRoleImpl {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	 //��ѯ��ɫ
	public List<UserRole> ListAll() {
		Session session = getSession();
		List<UserRole> UserRoleList = session.createQuery("from UserRole").list();
		return UserRoleList;
	}
	
	public UserRole ListAllById(int id) {
		Session session = getSession();
		UserRole UserRoleList = (UserRole) session.get(UserRole.class,id);
		return UserRoleList;
	}
	
	//����id��ѯȨ��
		public List ListAlltrue(int id) {
		System.out.println(id);
		String sql="select pid from role_res where rid="+id;
		List UserRoleList=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
			return UserRoleList;
		}
		
		//�����ɫ
		public void SaveRole(Object...objects) {
			Session session = getSession();
			UserRole userRole=(UserRole) objects[0];
				session.save(userRole);
	}
		//�޸Ľ�ɫ
		public void UpdateRole( Object objects) {
			Session session = getSession();
				session.update(objects);
	}
		//ɾ����ɫ
		public void DelRole( Object objects) {
			Session session = getSession();
				session.delete(objects);
	}
         //�����û�����ѯ��ɫ
		  //�����û������ɫ
	     public  Set<String> ListAllByName(Object object) {
		
			Session session=getSession();
			String sql="select r.cname from users u,user_role r where u.rid=r.id "
					+ " and u.user_name= '"+object+"'";
			List<String> rnameList=session.createSQLQuery(sql).list();
			session.flush();
			Set< String > set=new HashSet<String>(rnameList);
			System.out.println(set.size()+"��ɫ");
			return set;
		}
         //�����û�����ѯȨ��
	public Set<String> ListResourcesByName(String userName) {
		Session session=getSession();
		String sql="select res.resources_name from role_res re,user_role r,users u,resources res where u.rid=r.id and r.id=re.rid and res.resources_id=re.pid "
				+ " and u.user_name='"+userName+"'";
		List<String> pnameList= session.createSQLQuery(sql).list();
		Set< String > set=new HashSet<String>(pnameList);
		System.out.println(pnameList.size()+"Ȩ��");
		return set;
	}
	//��ѯ�Ƿ��иý�ɫ
	public  boolean getByName(String name) {
		Session session=getSession();
		String hql="from UserRole u where u.cname='"+name+"'";
		List<Users> list=session.createQuery(hql).list();
		if(list.size()>0){
			return false;
		}
		return true;
	}


}
