package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cornucopia.bean.PushNotice;
import com.cornucopia.bean.Users;
import com.cornucopia.dao.PM_PushNoticeDao;
import com.cornucopia.service.PM_PushNoticeService;

//�������service
@Component
public class PM_PushNoticeServiceImpl<T> implements PM_PushNoticeService{

	@Autowired
	private PM_PushNoticeDao pushNoticeDao;

	//���
	@Override
	public void save(Object... objects) {
		pushNoticeDao.save(objects);
	}

	//��ѯ�Ƿ��иñ���
	@Override
	public Boolean getByTitle(String title) {
		boolean boo=pushNoticeDao.getByTitle(title);
		return boo;
	}

	//��ѯ
	@Override
	public List<PushNotice> ListPush(Map map) {
		List<PushNotice> plist=pushNoticeDao.ListAll(map);
		return plist;
	}

	//����ID��ѯ��������
	@SuppressWarnings("unchecked")
	@Override
	public PushNotice chakan(int id) {
		return pushNoticeDao.chakan(id);
	}

	//�޸�
	@Override
	public void update(Object  object) {
		System.out.println("qqq");
		pushNoticeDao.update(object);
		
	}

	@Override
	public <T> List<T> ListAll(Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
