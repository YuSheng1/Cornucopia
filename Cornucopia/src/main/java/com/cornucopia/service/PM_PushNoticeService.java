package com.cornucopia.service;

import java.util.List;
import java.util.Map;

//公告管理接口
public interface PM_PushNoticeService {

	//查询所有公告，新闻
	public <T>List<T> ListAll(Object...obj);
	//添加公告
	public void save (Object...objects);
	//查询是否有该标题
	public <T> T getByTitle(String title);
	//根据id查询公告内容
	public <T> T chakan(int id);
	//修改公告
	public void update(Object object);
}
