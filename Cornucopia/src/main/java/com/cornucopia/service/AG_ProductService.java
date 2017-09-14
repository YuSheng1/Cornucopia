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
}
