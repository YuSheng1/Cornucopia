package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserRoleImpl;
import com.cornucopia.service.UserService;

@Component
public class UserRoleServiceImpl implements UserService {
	@Autowired
	private UserRoleImpl userRoleImpl;
	
	@Override
	public List<UserRole> ListAll(Object...object) {
		List<UserRole> UserRoleList=userRoleImpl.ListAll();
		return UserRoleList;
	}
	
	@Override
	public List ListAlltrue(int id) {
		List UserRoleList=userRoleImpl.ListAlltrue(id);
		return UserRoleList;
	}
	@Override
	public void save(Object...object) {
		userRoleImpl.SaveRole(object);
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		userRoleImpl.UpdateRole(object);
		
	}

	@Override
	public  UserRole getById(int id) {
		UserRole userRole=userRoleImpl.ListAllById(id);
		return userRole;
	}

	@Override
	public  Set<String> ListAllByName(Object object) {
		Set<String> set=userRoleImpl.ListAllByName(object);
		return set;
	}

	@Override
	public <T> Set<String> ListResourcesByName(String name) {
		Set<String> set=userRoleImpl.ListResourcesByName(name);
		return set;
	}

	@Override
	public  Boolean getByName(String name) {
		boolean boo=userRoleImpl.getByName(name);
		return boo;
	}

	@Override
	public void saveaa(int id, List list) {
		// TODO Auto-generated method stub
		
	}

}
