package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.PM_UserRoleImpl;
import com.cornucopia.service.PM_UserService;

@Component
public class PM_UserRoleServiceImpl implements PM_UserService {
	
	@Autowired
	private PM_UserRoleImpl PM_UserRoleImpl;
	
	@Override
	public List<UserRole> ListAll(Object...object) {
		List<UserRole> UserRoleList=PM_UserRoleImpl.ListAll();
		return UserRoleList;
	}
	
	@Override
	public List ListAlltrue(int id) {
		List UserRoleList=PM_UserRoleImpl.ListAlltrue(id);
		return UserRoleList;
	}
	@Override
	public void save(Object...object) {
		PM_UserRoleImpl.SaveRole(object);
		
	}

	@Override
	public void delete(Object object) {
		PM_UserRoleImpl.DelRole(object);
		
	}

	@Override
	public void update(Object object) {
		PM_UserRoleImpl.UpdateRole(object);
		
	}

	@Override
	public  UserRole getById(int id) {
		UserRole userRole=PM_UserRoleImpl.ListAllById(id);
		return userRole;
	}

	@Override
	public  Set<String> ListAllByName(Object object) {
		Set<String> set=PM_UserRoleImpl.ListAllByName(object);
		return set;
	}

	@Override
	public <T> Set<String> ListResourcesByName(String name) {
		Set<String> set=PM_UserRoleImpl.ListResourcesByName(name);
		return set;
	}

	@Override
	public  Boolean getByName(String name) {
		boolean boo=PM_UserRoleImpl.getByName(name);
		return boo;
	}

	@Override
	public void saveaa(int id, List list) {
		// TODO Auto-generated method stub
		
	}

}
