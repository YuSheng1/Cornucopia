package com.cornucopia.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cornucopia.bean.UserRole;
import com.cornucopia.bean.Users;
import com.cornucopia.dao.UserDao;
import com.cornucopia.daoImpl.UserDaoImpl;
import com.cornucopia.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDaoImpl;

	// 查询用户基本信息
	@Override
		public List<Users> ListAll(Object... objects) {
	        List<Users> User = userDaoImpl.ListAll();
			return User;
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
	}}
