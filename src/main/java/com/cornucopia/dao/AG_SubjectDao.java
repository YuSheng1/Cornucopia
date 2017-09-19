package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.Subject;

@Component
public class AG_SubjectDao {

	@Autowired
	private SessionFactory sf; 
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public List<Subject> ListAllS(String name){
		Session session=getSession();
		String hql="from Subject where 0=0";
		if(name!=null&&!"".equals(name)){
			hql+="and name='"+name+"'";
		}
		List<Subject> slist=session.createQuery(hql).list();
		return slist;
	 }
	
	
	public List<FinanceProductFunds> ListAllF(){
		Session session=getSession();
		String hql="from FinanceProductFunds";
		List<FinanceProductFunds> flist=session.createQuery(hql).list();
		return flist;
	}
	
	public List<OverseaConfig> ListAllO(){
		Session session=getSession();
		String hql="from OverseaConfig";
		List<OverseaConfig> olist=session.createQuery(hql).list();
		return olist;
	}

}
