package com.cornucopia.service;

public interface AG_ProductService {
	 //前台产品类操作
		public <T> T getBySubjectId(int id);
		public <T> T getBySubjectPurchaseRecordId(Object...object);
		public void UpdateSubjectPurchaseRecord(Object...object);
		//向交易记录表添加数据
		public void saveMemberTradeRecord(Object...object);
		//往及账表添加数据
		public void saveMembertally(Object...object);
		//往提现表添加数据
		public void saveMembeWithdrawRecord(Object...object);
		//往购买标的标添加数据
		public void saveSubjectPurchaseRecord(Object...object);
		//往成员利润记录表添加数据
		public void saveMemberProfitRecord(Object...object);
		//修改成员账户表金额
		public void saveMemberAccount(Object...object);
		//查询成员账户表金额
		public <T> T  UpdateMemberAccount(Object...object);
		//往标里添加数据
		public void saveSubject(Object...object);
		//往充值表添加数据
		public void saveAlipayTradePagePay(Object...object);
		public void updateAlipayTradePagePay(Object...object);
		//根据用户id查询SubjectPurchaseRecord
		public <T> T GetSubjectPurchaseRecordByid(int mid);
		//根据id查询充值记录表
		public <T> T GetMemberDepositRecordByid(int mid);
		//根据id查询提款记录表
		public <T> T GetMembeWithdrawRecordByid(int mid);
		//根据id查询英航卡绑定表
		public <T> T GetMemberBankcardsByid(int mid);
		//根据流水号查询提现表
		public <T> T GetMembeWithdrawRecordByliushui(String liushui);
		
		
		//往中间提款
		public void saveCashFlowProcess(Object...object);

		
	
		
		
}