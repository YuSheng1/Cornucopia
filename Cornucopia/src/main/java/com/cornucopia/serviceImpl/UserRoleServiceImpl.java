package com.cornucopia.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;
import com.cornucopia.service.UserService;

@Component("UserRoleServiceImpl")
public class UserRoleServiceImpl implements UserService {
	@Resource(name="UserRoleImpl")
	private UserDao userDao;
	
	@Override
	public List<UserRole> ListAll(Object...object) {
		List<UserRole> UserRoleList=userDao.ListAll(object);
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
