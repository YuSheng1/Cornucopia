package com.cornucopia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cornucopia.bean.PushNotice;
import com.cornucopia.bean.Users;

//�������dao
@Component
public class PM_PushNoticeDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	//��ѯ����
	public List<PushNotice>  ListAll(Object...object){
		String hql="from PushNotice where 0=0";
		Map map= (Map)object[0];
			hql=listDataHql(hql, map);
		Session session=getSession();
		System.out.println(hql);
		List<PushNotice> list=session.createQuery(hql).list();
		return list;
	}
	//ģ����ѯ
	public String listDataHql(String hql,Map map){
		String title1 = (String)map.get("title1");
		if(title1!=null&&!title1.equals("")){
			hql+=" and title like '%"+title1+"%'";
		}
		System.out.println(hql);
		return hql;
	}
	//���
	public void save(Object...objects){
		Session session=getSession();
		session.save(objects[0]);
	}
	
	//��ѯ�Ƿ��иñ���
		public  boolean getByTitle(String title) {
			Session session=getSession();
			String hql="from PushNotice p where p.title='"+title+"'";
			List<PushNotice> list=session.createQuery(hql).list();
			if(list.size()>0){
				return false;
			}
			return true;
		}
	//����id��ѯ��������
		public PushNotice chakan(int id){
			Session session=getSession();
			PushNotice pushNotice = (PushNotice) session.get(PushNotice.class, id);
			return pushNotice;
		}
}
