package com.cornucopia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.PageBean;
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
	public List<PushNotice>  ListAll(Map map){
		String hql="from PushNotice where 0=0";
		PageBean pb=(PageBean)map.get("pb");
		int page=pb.getPage();
		int size=pb.getSize();
		String flag=(String)map.get("flag");
		int count=countNum(map);
		pb.setTotal(count);
		
		if(flag!=null){
			if("next".equals(flag)){
				if(page+1>pb.getTotalpage()){
					page=pb.getTotalpage();
				}else{
					page=page+1;
				}
			}
			if("up".equals(flag)){
				if(page-1<1){
					page=1;
				}else{
					page=page-1;
				}
			}
			if("first".equals(flag)){
				page=1;
			}
			if("last".equals(flag)){
				page=pb.getTotalpage();
			}
		}
		pb.setPage(page);
		Session session=getSession();
		System.out.println("sdfs");
		hql=listDataHql(hql, map);
		List<PushNotice> list=session.createQuery(hql).setFirstResult((page-1)*size).setMaxResults(size).list();
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
	
	public int countNum(Map map){
		String hql=" select count(*) from push_notice where 0=0";
		hql=listDataHql(hql, map);
		Session session=getSession();
		int count=Integer.valueOf(session.createSQLQuery(hql).uniqueResult().toString());
		return count;
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
	//�༭����
		public void update(Object object){
			Session session=getSession();
			session.update(object);
		}

}
