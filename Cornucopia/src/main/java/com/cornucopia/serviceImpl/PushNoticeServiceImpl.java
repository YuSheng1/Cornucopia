package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cornucopia.bean.PushNotice;
import com.cornucopia.dao.PushNoticeDao;
import com.cornucopia.service.PushNoticeService;

@Component
public class PushNoticeServiceImpl implements PushNoticeService{

	@Autowired
	private PushNoticeDao pushNoticeDao;

	@Override
	public List<PushNotice> ListAll(Object object) {
		List<PushNotice> plist=pushNoticeDao.ListAll();
		return plist;
	}

	@Override
	public void delete(Object object) {
		pushNoticeDao.delete(object);		
	}

	@Override
	public void save(Object... objects) {
		pushNoticeDao.save(objects);
	}
}
