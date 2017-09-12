package com.cornucopia.service;

import java.util.List;

public interface PushNoticeService {

	public <T>List<T> ListAll(Object object);
	public void delete(Object object);
	public void save (Object...objects);
}
