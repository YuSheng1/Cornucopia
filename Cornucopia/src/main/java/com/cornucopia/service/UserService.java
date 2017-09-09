package com.cornucopia.service;

import java.util.List;

import com.cornucopia.bean.Resources;

public interface UserService {
	
	public <T>List<T> ListAll(Object...objects) ;
	public void save (Object object);
	public void delete(Object object);
	public void update(Object object);
	public <T> T getById(int id);
	public List<Resources> ListAllRole();
	public <T>List<T> ListAlltrue(int id);

}
