package com.cornucopia.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;
import com.cornucopia.service.UserService;

@Component
public class UserRoleServiceImpl implements UserService {
	@Resource
	private UserDao userRoleImpl;
	
	@Override
	public List<UserRole> ListAll(Object...object) {
		List<UserRole> UserRoleList=userRoleImpl.ListAll();
		return UserRoleList;
	}
	@Override
	public List<Resources> ListAllRole() {
		List<Resources> UserRoleList=userRoleImpl.ListAllRole();
		return UserRoleList;
	}
	@Override
	public List ListAlltrue(int id) {
		List UserRoleList=userRoleImpl.ListAlltrue(id);
		return UserRoleList;
	}
	@Override
	public void save(Object object) {
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

}
