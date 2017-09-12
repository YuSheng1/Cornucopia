package com.cornucopia.service;

import java.util.List;


public interface NewsService {

	public <T>List<T> ListAll(Object...objects) ;
	public void save (Object...objects);
	public void delete(Object object);
	public void update(Object object);
	public <T> T getById(int id);
	public <T> T getByName(String name);
}
