package com.cornucopia.service;

public interface ValidateService {
	// ��֤�ֻ���
	public <T> T getByPhone(String mobile_Phone);

	// ǰ̨��֤��½
	public <T> T UserLogin(String name, String password);

	// �����û�����ȡ����
	public <T> T member(String name);
	// ���뽱��
		public <T> T Useryqjl(String invitationCode);
	// �����û�����ȡ����
	public <T> T memberLoginUser(String name);

	// ǰ̨�û���ѯ���
	public <T> T MemberAccount(int id);
	// ǰ̨�û���ѯ���
	public <T> T AwardRecordsListVo(int id);
	
	// ǰ̨��ѯ���п�
	public <T> T MemberBankcards(int id);
	// ǰ̨��ѯ���п���û�а�
	public <T> T getMemberBankcardsKa(String card_no);
	
	
	// ��̨��ѯ�������п�
	public <T> T MemberBankcardsList();
	// ��̨��ѯ���б��¼��
	public <T> T SubjectList();
	//��̨����������
	public <T> T SubjectBbinPurchassRecordList(int subjectId);
	//��̨�깺�����
		public <T> T SubjectPurchaseRecordList(int subjectId);
		//��ֵ��¼��
		public <T> T getMemberDepositRecord();
		//������¼��
		public <T> T AwardRecordsList();
	
	// ��ͼ
	public <T> T cashFlowProcessVo(int id);

	// �ǳ���û��ע��
	public boolean Usernc(String member_name);

	// �ֻ�����û��ע��
	public boolean Usersjh(String mobile_Phone);
	//������治����
	public boolean Usersyz(String invitedCode);
	//���֤�治����
		public boolean Usersfid(String invitedCode);
	
	

}
