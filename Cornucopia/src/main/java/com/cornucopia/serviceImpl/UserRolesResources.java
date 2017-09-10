package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;
import com.cornucopia.service.UserService;
@Component
public class UserRolesResources implements UserService {

	@Resource
	private UserDao userRolesResourcesDaoImpl;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Resources> ListAll(Object...object) {
		List<Resources> UserResources=userRolesResourcesDaoImpl.ListAll();
		return UserResources;
	}
	@Override
	public void save(Object...object) {
		userRolesResourcesDaoImpl.save(object);
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
	@Override
	public <T> T getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
