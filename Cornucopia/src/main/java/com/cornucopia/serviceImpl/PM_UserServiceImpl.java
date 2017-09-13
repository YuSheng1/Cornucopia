package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Users;
import com.cornucopia.dao.PM_UserDaoImpl;
import com.cornucopia.service.PM_UserService;

@Component
public class PM_UserServiceImpl implements PM_UserService {

	@Autowired
	private PM_UserDaoImpl pM_UserDaoImpl;

	// ��ѯ�û�������Ϣ
	@Override
	public List<Users> ListAll(Object... objects) {
		List<Users> User = pM_UserDaoImpl.ListAll();
		return User;
	}

	@Override
	public void save(Object... object) {
		pM_UserDaoImpl.SaveOrUpdate(object[0]);

	}

	@Override
	public void delete(Object object) {
		pM_UserDaoImpl.DelUsers(object);
		
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

		return null;
	}

	// �������Ʋ�ѯ�Ƿ��и��û�
	@Override
	public Users getByName(String name) {
		Users users = pM_UserDaoImpl.getByName(name);
		return users;
	}

	@Override
	public void saveaa(int id, List list) {
		// TODO Auto-generated method stub

	}

}
