package com.cornucopia.bean;

/*
 * 提现记录表
 */
public class MemberWithdrawRecord {

	private int id;//id
	private String serialNumber;//流水号
	private int memberId;// 用户id
	private String amount;//提现金额
	private String bankName;//银行名称
	private String bankCard;//卡号
	private int status;//提现状态(0:待审核;1:已打款;2打款中;3:打款失败
	private int delFlag;//是否删除
	private String cardaddress;//开户银行所在地
	private String channelName;//打款通道（富友,贝付）
	private String createDate;//创建时间
	private String updateDate;//修改时间
	
}
