package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cornucopia.bean.UserRole;
import com.cornucopia.dao.UserDao;
import com.cornucopia.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserRole> ListAll(Object... objects) {
		List<UserRole> UserRoleList=userDao.ListAll();
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
