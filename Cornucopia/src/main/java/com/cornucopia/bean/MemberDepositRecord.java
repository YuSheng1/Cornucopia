package com.cornucopia.bean;

/*
 * 充值记录表
 */
public class MemberDepositRecord {

	private int id;//id
	private String serialNumber;//流水号
	private int memberId;//用户id
	private int amount;//金额
	private int status;// 状态(0:待付款;1:完成)
	private String payChannelName;//充值渠道名称
	private String payChannelOrder_no;//充值渠道订单号
	private int delFlag;//默认...（没写备注..）
	private String createDate;// 创建时间
	private String updateDate;// 修改时间
}
