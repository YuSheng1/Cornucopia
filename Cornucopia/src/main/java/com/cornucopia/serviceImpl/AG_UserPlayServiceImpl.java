package com.cornucopia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.dao.AG_UserPlayDao;
import com.cornucopia.service.AG_UserPlayService;
//������
@Component
public class AG_UserPlayServiceImpl implements AG_UserPlayService{

	@Autowired
	private AG_UserPlayDao aG_UserPlaytDao;//�����Ʒ��
	
	//����ʱ���׼�¼��
	@Override
	public void save(Object... objects) {
		aG_UserPlaytDao.save(objects);
	}

	@Override
	public void savemember(Object... objects) {
		aG_UserPlaytDao.savemember(objects);
		
	}

}
