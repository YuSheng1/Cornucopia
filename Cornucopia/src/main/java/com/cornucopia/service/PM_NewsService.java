package com.cornucopia.service;

import java.util.List;

import com.cornucopia.bean.News;


public interface PM_NewsService {

	public <T>List<T> ListAll(String title,String typeId);
	public <T>List<T> ListAllT(Object...objects) ;
	public void save (Object...objects);
	public void delete(Object object);
	public void update(Object object);
	public <T> T getById(int id);
	public <T> T getByName(String name);
	public <T>List<T> ListAllById(int id) ;
	public News NewsByIdA(int id) ;
	
}
