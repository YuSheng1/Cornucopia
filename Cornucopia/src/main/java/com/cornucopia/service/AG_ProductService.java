package com.cornucopia.service;

public interface AG_ProductService {
    //ǰ̨��Ʒ�����
	public <T> T getBySubjectId(int id);
	public <T> T getBySubjectPurchaseRecordId(Object...object);
	public void UpdateSubjectPurchaseRecord(Object...object);
	//���׼�¼���������
	public void saveMemberTradeRecord(Object...object);
	//�����˱��������
	public void saveMembertally(Object...object);
	//�������ı��������
	public void saveSubjectPurchaseRecord(Object...object);
	//����Ա�����¼���������
	public void saveMemberProfitRecord(Object...object);
	//�޸ĳ�Ա�˻�����
	public void saveMemberAccount(Object...object);
	//��ѯ��Ա�˻�����
	public <T> T  UpdateMemberAccount(Object...object);
	//�������������
	public void saveSubject(Object...object);
}
