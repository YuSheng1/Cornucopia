package com.cornucopia.dao;

import java.util.List;

public interface UserDao {
    
	public <T> List<T> ListAll(Object...objects) ;
	public void save (Object object);
	public void delete(Object object);
	public void update(Object object);
	public <T> T getById(int id);
	
	
}
