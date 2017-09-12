package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.NewsType;
import com.cornucopia.dao.NewsTypeDao;
import com.cornucopia.service.UserService;

@Component
public class NewsTypeServiceImpl implements  UserService{

	@Autowired
	private NewsTypeDao newsTypeDao;


	@Override
	public  List<NewsType> ListAll(Object... objects) {
		List<NewsType> tlist=newsTypeDao.ListAll();
		return tlist;
	}

	@Override
	public void save(Object... objects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> ListAlltrue(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<String> ListAllByName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<String> ListResourcesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
