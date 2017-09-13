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

@Component
public class PM_PushNoticeServiceImpl<T> implements PM_PushNoticeService{

	@Autowired
	private PM_PushNoticeDao pushNoticeDao;

	@Override
	public void save(Object... objects) {
		pushNoticeDao.save(objects);
	}

	@Override
	public Boolean getByTitle(String title) {
		boolean boo=pushNoticeDao.getByTitle(title);
		return boo;
	}

	@Override
	public List<PushNotice> ListAll(Object...objects) {
		List<PushNotice> plist=pushNoticeDao.ListAll(objects);
		return plist;
	}
}
