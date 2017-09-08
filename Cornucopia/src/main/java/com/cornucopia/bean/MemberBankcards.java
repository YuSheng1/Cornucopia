package com.cornucopia.bean;

/*
 * 成员银联表
 */
public class MemberBankcards {

	private int id;//id
	private String type;//银行卡类型
	private int member_id;//用户
	private String card_no;//卡号
	private int delflag;//是否删除（0：正常使用，2：被删除）
	private String create_date;//创建时间
	private String update_date;//修改时间
	private String cardaddress;//开户银行所在地
}
