package com.cornucopia.service;

public interface ValidateService {
	//验证手机号
	public <T> T getByPhone(String mobile_Phone);
	//前台验证登陆
	public <T> T UserLogin(String name,String password);


}
