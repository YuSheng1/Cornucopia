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

	public Session getSession() {
		return sf.getCurrentSession();
	}

	// 查询标题
	public List<News> ListAll(String title,String typeid) {
		System.out.println(typeid);
		String hql="from News where 0=0";
		Session session = getSession();
		if(title!=null&&!"".equals(title)){
			hql+="and title like '%"+title+"%'" ;
		}
		if(typeid!=null&&!"".equals(typeid)&&Integer.parseInt(typeid)!=-1){
			hql+="and typeid = '"+typeid+"'";
		}
		hql+="  ORDER BY sort desc";
		List<News> list = session.createQuery(hql).list();
		return list;
	}

	// 查询标题
	public List<News> ListAllById(int id) {
		String hql = "from News where newsType.id =" + id;
		Session session = getSession();
		List<News> list = session.createQuery(hql).list();
		return list;
	}
	// 查询标题
		public News NewsByIdA(int id) {
			Session session = getSession();
			News News = (News) session.get(News.class, id);
			System.out.println(News.getAddTime());
			return News;
		}
	
	// 添加
	public void save(Object... objects) {
		Session session = getSession();
		session.save(objects[0]);
	}

	// 删除
	public void delete(Object object) {
		Session session = getSession();
		session.delete(object);
	}

	// 修改
	public void update(Object object) {
		Session session = getSession();
		session.update(object);
	}

	// 根据ID
	public News getById(int id) {
		Session session = getSession();
		News News = (News) session.get(News.class, id);
		return News;
	}

	// 查询是否有该标题
	public Boolean getByName(String tname) {
		Session session = getSession();
		String hql = "from News u where u.title='" + tname + "'";
		List<News> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return false;
		}
		return true;
	}
}
