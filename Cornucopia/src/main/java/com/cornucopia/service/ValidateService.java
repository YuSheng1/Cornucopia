package com.cornucopia.service;

public interface ValidateService {
	//��֤�ֻ���
	public <T> T getByPhone(String mobile_Phone);
	//ǰ̨��֤��½
	public <T> T UserLogin(String name,String password);
	//�����û�����ȡ����
	public <T> T member(String name);
	//ǰ̨�û���ѯ���
	public <T> T MemberAccount(int id);
	//ǰ̨��ѯ���п�
	public <T> T MemberBankcards(int id);
	
}
