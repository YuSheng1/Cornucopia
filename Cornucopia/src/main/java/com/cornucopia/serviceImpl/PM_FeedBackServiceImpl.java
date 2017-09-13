package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cornucopia.bean.Feedback;
import com.cornucopia.dao.PM_FeedBackDao;
import com.cornucopia.service.PM_PushNoticeService;

@Service
@Transactional
public class PM_FeedBackServiceImpl implements PM_PushNoticeService{
	
	@Autowired
	private PM_FeedBackDao pm_FeedBackDao;

	@Override
	public List<Feedback> ListAll(Object...objects) {
		System.out.println("近方法之前");
		List<Feedback> flist=pm_FeedBackDao.ListAll(objects);
		return flist;
	}

	@Override
	public void save(Object... objects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
