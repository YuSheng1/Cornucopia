package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.News;
import com.cornucopia.dao.PM_NewsDao;
import com.cornucopia.service.PM_NewsService;

@Component
public class PM_NewsServiceImpl implements PM_NewsService {

	@Autowired
	private PM_NewsDao newsDao;


	@Override
	public  List<News> ListAll(String title,String typeId) {
		List<News> list=newsDao.ListAll(title, typeId);
		return list;
	}

	@Override
	public void save(Object... objects) {
		newsDao.save(objects);
	}

	@Override
	public void delete(Object object) {
		newsDao.delete(object);
	}

	@Override
	public void update(Object object) {
		newsDao.update(object);
	}

	@Override
	public News getById(int id) {
		News news=newsDao.getById(id);
		return news;
	}

	@Override
	public  Boolean getByName(String title) {
		boolean boo=newsDao.getByName(title);
		return boo;
	}

	@Override
	public List<News> ListAllById(int id) {
		List<News> news=newsDao.ListAllById(id);
		return news;
	}
	@Override
	public News NewsByIdA(int id) {
		News news=newsDao.NewsByIdA(id);
		return news;
	}

	@Override
	public <T> List<T> ListAllT(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
