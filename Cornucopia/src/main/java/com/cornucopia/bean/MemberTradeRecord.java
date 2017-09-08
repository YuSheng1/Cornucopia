package com.cornucopia.bean;

/*
 * 交易记录表
 */
public class MemberTradeRecord {

	private int id;//id
	private int memberId;//用户id
	private String tradeNo;//交易号
	private String tradeName;//交易名称
	private String counterpart;//交易对方
	private int amount;//交易金额
	private String tradeType;//交易分类
	private int fundFlow;//资金流向(0:流出1:流入)
	private int tradeStatus;//交易状态
	private String extField_1;//扩展1
	private String extField_2;//扩展2
	private String extField_3;//扩展3
	private String createDate;//创建时间
	private String updateDate;//修改时间
	
}
