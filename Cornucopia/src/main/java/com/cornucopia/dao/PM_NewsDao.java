package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.News;
import com.cornucopia.bean.Users;

@Component
public class PM_NewsDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	//��ѯ����
		public List<News>  ListAll(){
			Session session=getSession();
			List<News> list=session.createQuery("from News").list();
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
		public  News getById(int id){
			Session session = getSession();
			News News = (News) session.get(News.class,id);
			return News;
		}
		
		//��ѯ�Ƿ��иñ���
		public  Boolean getByName(String tname) {
			Session session=getSession();
			String hql="from News u where u.title='"+tname+"'";
			List<News> list=session.createQuery(hql).list();
			if(list.size()>0){
				return false;
			}
			return true;
		}
}
