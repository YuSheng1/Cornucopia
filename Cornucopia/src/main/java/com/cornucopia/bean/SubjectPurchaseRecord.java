package com.cornucopia.bean;

/*
 * 标的购买表
 */
public class SubjectPurchaseRecord {
     
	private int id;//ID
	private String serial_number;//流水号
	private int amount;//购买金额
	private String dealIp;//交易ip
	private int subjectId;//标的Id'
	private int memberId;//会员ID
	private int delflag;//是否删除
	private String createDate;//添加时间
	private String updateDate;//修改时间
	private int interest;//结算利息
	private int ispayment;//是否还款
	private int payInterestTimes;//购买次数
	private int lastProfitDay;//最后计息日
	private String bonusInfo;//红包金额信息（app端实际投资额度+红包额度）
}
