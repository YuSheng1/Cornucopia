package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.NewsType;
import com.cornucopia.bean.Resources;
import com.cornucopia.bean.Users;
import com.cornucopia.dao.PM_NewsTypeDao;
import com.cornucopia.service.PM_NewsService;
import com.cornucopia.service.UserService;

@Component
public class PM_NewsTypeServiceImpl implements  PM_NewsService{

	@Autowired
	private PM_NewsTypeDao newsTypeDao;


	@Override
	public  List<NewsType> ListAll(Object... objects) {
		List<NewsType> tlist=newsTypeDao.ListAll();
		return tlist;
	}

	@Override
	public void save(Object... objects) {
		newsTypeDao.save(objects);
	}

	@Override
	public void delete(Object object) {
		newsTypeDao.delete(object);
	}

	@Override
	public void update(Object object) {
		newsTypeDao.update(object);
	}

	@Override
	public NewsType getById(int id) {
		NewsType newsType=newsTypeDao.getById(id);
		return newsType;
	}

	@Override
	public  Boolean getByName(String name) {
		boolean newsType=newsTypeDao.getByName(name);
		return newsType;
	}

}
