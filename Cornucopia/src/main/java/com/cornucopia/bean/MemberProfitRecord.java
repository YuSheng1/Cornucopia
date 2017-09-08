package com.cornucopia.bean;

/*
 * 成员利润记录表
 */
public class MemberProfitRecord {

	private int id;//id
	private String serialNumber;//流水号
	private int type;//类型
	private int amount;//金额
	private int memberId;//用户id
	private int delflag;//(没写..)
	private String createDate;//创建时间
	private String updateDate;//修改时间
	private String comment;//备注
	private int purchaseId;//标的id
	private int profitYear;//计息年
	private int profitMonth;//计息月
	private int profitDay;//计息日	
}
