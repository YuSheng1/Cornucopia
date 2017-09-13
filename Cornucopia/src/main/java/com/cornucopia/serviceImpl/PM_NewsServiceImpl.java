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
	public  List<News> ListAll(Object... objects) {
		List<News> list=newsDao.ListAll();
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
	public  Boolean getByName(String name) {
		boolean newsType=newsDao.getByName(name);
		return newsType;
	}

}
