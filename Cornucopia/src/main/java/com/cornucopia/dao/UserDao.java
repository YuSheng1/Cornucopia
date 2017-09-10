package com.cornucopia.dao;

import java.util.List;
import java.util.Set;

import com.cornucopia.bean.Resources;

public interface UserDao {
    
	public <T> List<T> ListAll(Object...objects) ;
	public void save (Object...objects);
	public void delete(Object object);
	public void update(Object object);
	public <T> T getById(int id);
	public <T> T getByName(String name);
	public <T> List<T> ListAlltrue(int id);
	public <T>Set<T> ListAllByName(Object object);
	public <T>Set<String> ListResourcesByName(String name);
}
