package com.cornucopia.service;

public interface ValidateService {
	//验证手机号
	public <T> T getByPhone(String mobile_Phone);
	//前台验证登陆
	public <T> T UserLogin(String name,String password);
	//根据用户名获取对象
	public <T> T member(String name);
	//前台用户查询金额
	public <T> T MemberAccount(int id);
	//前台查询银行卡
	public <T> T MemberBankcards(int id);
	
}
