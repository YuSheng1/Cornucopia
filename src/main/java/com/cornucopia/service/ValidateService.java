package com.cornucopia.service;

public interface ValidateService {
	//��֤�ֻ���
	public <T> T getByPhone(String mobile_Phone);
	//ǰ̨��֤��½
	public <T> T UserLogin(String name,String password);
	//�����û�����ȡ����
	public <T> T member(String name);
	//�����û�����ȡ����
	public <T> T memberLoginUser(String name);
	//ǰ̨�û���ѯ���
	public <T> T MemberAccount(int id);
	//ǰ̨��ѯ���п�
	public <T> T MemberBankcards(int id);
	//��ͼ
	public <T> T cashFlowProcessVo(int id);
	//�ǳ���û��ע��
    public boolean Usernc(String member_name);
	//�ֻ�����û��ע��
    public boolean Usersjh(String mobile_Phone);
	
	
}
