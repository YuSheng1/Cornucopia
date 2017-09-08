package com.cornucopia.bean;

/*
 * 成员账户表
 */
public class MemberAccount {

	private int id;//id
	private int memberId;//用户ID 
	private int useableBalance;// 可用余额 
	private int imusealeBalance;//冻结余额
	private int totalProfit;//累计收益 
	private String createDate;//创建时间
	private String updateDate;//修改时间
	private int bonusAmount;//红包金额
	private int investAmount;//投资总额  
	private int delflag;//(meixie)
	private int bbinAmount;//体验金 
}
