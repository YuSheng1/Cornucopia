package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.dao.UserRolesResourcesDaoImpl;
import com.cornucopia.service.UserService;
@Component
public class UserRolesResources implements UserService{

	@Autowired
	private UserRolesResourcesDaoImpl userRolesResourcesDaoImpl;
	//查询所有树
	@Override
	public List<Resources> ListAll(Object...objects) {
		List<Resources> UserResources=userRolesResourcesDaoImpl.ListAll();
		return UserResources;
	}
	@Override
	//中间表添加权限
	public void save(Object...objects) {
		userRolesResourcesDaoImpl.save(objects);
		
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
