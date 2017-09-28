package com.cornucopia.dao;

import java.util.List;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Subject;


@Component
public class PM_Subjectdao {
	
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Subject> list(Map map){
		Session session=getSession();
		String hql="from Subject where 0=0";
		hql+=getHql(hql, map);
		List<Subject> list=session.createQuery(hql).list();
		return list;
	}
	/**
	 * 
	 */
	public String getHql(String hql,Map map){
		String name=(String)map.get("name");
		String type=(String)map.get("type");
		String status=(String)map.get("status");
		hql="";
		if(name!=null&&!name.trim().equals("")){
			hql+=" and name like '%"+name+"%'";
		}
		if(type!=null&&!type.trim().equals("")){
			hql+=" and type like '%"+type+"%'";
		}
		if(status!=null&&!status.trim().equals("")){
			hql+=" and status like '%"+status+"%'";
		}
		return hql;
	}


	public List SubList(){
		System.out.println("111");
    	String hql="from Subject";
    	Session session=getSession();
    	List Sublist=session.createQuery(hql).list();
    	return Sublist;
    }
		
	//
	public float GetSubjectPurchaseRecordByidTiYan(int subId) {
		Session session = getSession();
		String sql = " select amount from  Subject_bbin_purchase_record p where p.subject_id=" + subId;
		List list = session.createQuery(sql).list();
		if (list.size() > 0) {
			float count=0;
			for (int i = 0; i < list.size(); i++) {
				count+=(float) list.get(i);
			}
			return count;
		}
		return 0;
	}
	// 
	public float GetSubjectPurchaseRecordByid(int subId) {
		Session session = getSession();
		String sql = " select amount from Subject_purchase_record p where p.subject_id=" + subId;
		List list = session.createSQLQuery(sql).list();
		if (list.size() > 0) {
			float count=0;
			for (int i = 0; i < list.size(); i++) {
				count+=(float) list.get(i);
			}
			return count;
		}
		return 0;
	}

		
		public void save (Object...objects){
			Session session =getSession();
			session.save(objects[0]);
		}
		
		public void delete(Object object){
			Session session =getSession();
			session.delete(object);
		}
		
		public void update(Object object){
			Session session =getSession();
			session.update(object);
		}
		
		public  Subject getById(int id){
			Session session = getSession();
			Subject subject = (Subject) session.get(Subject.class,id);
			return subject;
		}
		
		public List listAllmen(int id){
			Session session = getSession();
			String hql="from SubjectBbinPurchassRecord s where s.subject.id="+id;
			List list=session.createQuery(hql).list();
			return list;
		}
}
