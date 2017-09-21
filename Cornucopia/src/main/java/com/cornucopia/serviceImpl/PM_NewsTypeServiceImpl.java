package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.News;
import com.cornucopia.bean.NewsType;
import com.cornucopia.bean.Resources;
import com.cornucopia.bean.Users;
import com.cornucopia.dao.PM_NewsTypeDao;
import com.cornucopia.service.PM_NewsService;
import com.cornucopia.service.PM_UserService;

@Component
public class PM_NewsTypeServiceImpl implements  PM_NewsService{

	@Autowired
	private PM_NewsTypeDao newsTypeDao;


	@Override
	public  List<NewsType> ListAllT(Object... objects) {
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

	@Override
	public <T> List<T> ListAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public News NewsByIdA(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> ListAll(String title, String typeId) {
		// TODO Auto-generated method stub
		return null;
	}


}
