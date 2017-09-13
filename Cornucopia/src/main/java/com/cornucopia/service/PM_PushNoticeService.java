package com.cornucopia.service;

import java.util.List;
import java.util.Map;

public interface PM_PushNoticeService {

	public <T>List<T> ListAll(Object...obj);
	public void save (Object...objects);
	public <T> T getByTitle(String title);
}
