package com.cornucopia.service;

public interface ValidateService {
	//��֤�ֻ���
	public <T> T getByPhone(String mobile_Phone);
	//ǰ̨��֤��½
	public <T> T UserLogin(String name,String password);


}
