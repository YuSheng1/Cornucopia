package com.cornucopia.service;

import java.util.List;
import java.util.Map;

import com.cornucopia.bean.PushNotice;

//�������ӿ�
public interface PM_PushNoticeService {

	//��ѯ���й��棬����
	public <T>List<T> ListAll(Object...obj);
	//��ӹ���
	public void save (Object...objects);
	//��ѯ�Ƿ��иñ���
	public <T> T getByTitle(String title);
	//����id��ѯ��������
	public <T> T chakan(int id);
	//�޸Ĺ���
	public void update(Object object);
	public <T> T ListPush(Map map);
}
