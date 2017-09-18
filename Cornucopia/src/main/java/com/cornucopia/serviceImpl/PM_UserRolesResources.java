package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.dao.PM_UserDaoImpl;
import com.cornucopia.dao.PM_UserRolesResourcesDaoImpl;
import com.cornucopia.service.PM_UserService;
@Component
public class PM_UserRolesResources implements PM_UserService{

	@Autowired
	private PM_UserRolesResourcesDaoImpl pM_UserRolesResourcesDaoImpl;
	@Autowired
	private PM_UserDaoImpl pM_UserDaoImpl;
	//查询所有树
	@Override
	public List<Resources> ListAll(Object...objects) {
		List<Resources> UserResources=pM_UserRolesResourcesDaoImpl.ListAll();
		return UserResources;
	}
	@Override
	//中间表添加权限
	public void save(Object...objects) {
		pM_UserRolesResourcesDaoImpl.save(objects);
		
	}
	@Override
	//中间表添加权限
	public void saveaa(int id,List list) {
		pM_UserRolesResourcesDaoImpl.saveaa(id,list);
		
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
	public  List<Resources> getById(int id) {
		List<Resources> resources=pM_UserRolesResourcesDaoImpl.ListById(id);
		return resources;
	}
	@Override
	public  Boolean getByName(String name) {
		boolean bo=pM_UserDaoImpl.getByNameOrTrue(name);
		return bo;
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
