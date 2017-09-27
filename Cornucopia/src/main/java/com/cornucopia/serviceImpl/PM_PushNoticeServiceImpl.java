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

//公告管理service
@Component
public class PM_PushNoticeServiceImpl<T> implements PM_PushNoticeService{

	@Autowired
	private PM_PushNoticeDao pushNoticeDao;

	//添加
	@Override
	public void save(Object... objects) {
		pushNoticeDao.save(objects);
	}

	//查询是否有该标题
	@Override
	public Boolean getByTitle(String title) {
		boolean boo=pushNoticeDao.getByTitle(title);
		return boo;
	}

	//查询
	@Override
	public List<PushNotice> ListPush(Map map) {
		List<PushNotice> plist=pushNoticeDao.ListAll(map);
		return plist;
	}

	//根据ID查询公告内容
	@SuppressWarnings("unchecked")
	@Override
	public PushNotice chakan(int id) {
		return pushNoticeDao.chakan(id);
	}

	//修改
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
