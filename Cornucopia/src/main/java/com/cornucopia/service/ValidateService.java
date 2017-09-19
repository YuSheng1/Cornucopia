package com.cornucopia.service;

public interface ValidateService {
	// 验证手机号
	public <T> T getByPhone(String mobile_Phone);

	// 前台验证登陆
	public <T> T UserLogin(String name, String password);

	// 根据用户名获取对象
	public <T> T member(String name);
	// 邀请奖励
		public <T> T Useryqjl(String invitationCode);
	// 根据用户名获取对象
	public <T> T memberLoginUser(String name);

	// 前台用户查询金额
	public <T> T MemberAccount(int id);
	// 前台用户查询金额
	public <T> T AwardRecordsListVo(int id);
	
	// 前台查询银行卡
	public <T> T MemberBankcards(int id);
	// 前台查询银行卡有没有绑定
	public <T> T getMemberBankcardsKa(String card_no);
	
	
	// 后台查询所有银行卡
	public <T> T MemberBankcardsList();
	// 后台查询所有标记录卡
	public <T> T SubjectList();
	//后台体验金购买的人
	public <T> T SubjectBbinPurchassRecordList(int subjectId);
	//后台标购买的人
		public <T> T SubjectPurchaseRecordList(int subjectId);
		//充值记录表
		public <T> T getMemberDepositRecord();
		//奖励记录表
		public <T> T AwardRecordsList();
	
	// 视图
	public <T> T cashFlowProcessVo(int id);

	// 昵称有没有注册
	public boolean Usernc(String member_name);

	// 手机号有没有注册
	public boolean Usersjh(String mobile_Phone);
	//邀请码存不存在
	public boolean Usersyz(String invitedCode);
	//身份证存不存在
		public boolean Usersfid(String invitedCode);
	
	

}
