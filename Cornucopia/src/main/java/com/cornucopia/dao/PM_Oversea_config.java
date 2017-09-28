package com.cornucopia.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.OverseaConfigSubscribe;

@Component
public class PM_Oversea_config {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getsession(){
		return sessionFactory.getCurrentSession();
	}
    public void save(OverseaConfig oversea ){
    	Session session=getsession();
    	session.save(oversea);
    }
    public OverseaConfig getById(int id){	
    	Session session=getsession();
        OverseaConfig overseaConfig=(OverseaConfig) session.get(OverseaConfig.class, id);
        return overseaConfig;
    }
    public OverseaConfigSubscribe getByIdSub(int oversea_id){
    	Session session=getsession();
    	OverseaConfigSubscribe overseaConfigSub=(OverseaConfigSubscribe) session.get(OverseaConfigSubscribe.class, oversea_id);
    	return overseaConfigSub;
    }
    
    public List listAll(){
    	String hql="from OverseaConfig";
    	Session session=getsession();
    	List list=session.createQuery(hql).list();
    	return list;
    }
    public List listAllSub(){
    	String hql="from OverseaConfigSubscribe";
    	Session session=getsession();
    	List listsub=session.createQuery(hql).list();
    	return listsub;
    }
   public List listAlll(int id){
        	String hql="from OverseaConfigSubscribe c where c.overseaConfig.id="+id;
        	Session session=getsession();
        	List listsub=session.createQuery(hql).list();
        	return listsub;
    }
    public void update(OverseaConfig oversea){
    	Session session=getsession();
    	session.update(oversea);
    }
    public void delete(OverseaConfig oversea){
    	Session session=getsession();
    	session.delete(session);
    }
}
