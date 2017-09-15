package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.News;
import com.cornucopia.bean.NewsType;

@Component
public class PM_NewsTypeDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	

	//��ѯ����
	public List<NewsType>  ListAll(){
		Session session=getSession();
		List<NewsType> list=session.createQuery("from NewsType").list();
		return list;
	}
	
	//���
	public void save (Object...objects){
		Session session =getSession();
		session.save(objects[0]);
	}
	
	//ɾ��
	public void delete(Object object){
		Session session =getSession();
		session.delete(object);
	}
	//�޸�
	public void update(Object object){
		Session session =getSession();
		session.update(object);
	}
	//����ID
	public  NewsType getById(int id){
		Session session = getSession();
		NewsType newsType = (NewsType) session.get(NewsType.class,id);
		return newsType;
	}
	
	//��ѯ�Ƿ��и����
		public  boolean getByName(String name) {
			Session session=getSession();
			String hql="from NewsType u where u.name='"+name+"'";
			List<NewsType> list=session.createQuery(hql).list();
			if(list.size()>0){
				return false;
			}
			return true;
		}
}
