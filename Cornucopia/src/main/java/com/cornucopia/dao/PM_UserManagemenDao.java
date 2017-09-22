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
		public List<Member> ListmemberList(String name,String mobile_Phone,String member_name,String invitationCode,String create_date) {
			String hql="from Member where 0=0";
			Session session = getSession();
			if(name!=null&&!name.equals("")){
				hql+=" and name like '%"+name+"%'";
			}
			if(mobile_Phone!=null&&!mobile_Phone.equals("")){
				hql+=" and mobile_Phone like '%"+mobile_Phone+"%'";
			}
			if(member_name!=null&&!member_name.equals("")){
				hql+=" and member_name like '%"+member_name+"%'";
			}
			if(invitationCode!=null&&!invitationCode.equals("")){
				hql+=" and invitationCode like '%"+invitationCode+"%'";
			}
			if(create_date!=null&&!create_date.equals("")){
				hql+=" and create_date like '%"+create_date+"%'";
			}
			List<Member> memberList = session.createQuery(hql).list();
			return memberList;
		}
}
