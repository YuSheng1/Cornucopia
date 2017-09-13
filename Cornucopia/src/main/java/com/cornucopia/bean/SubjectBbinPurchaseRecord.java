package com.cornucopia.bean;

/*
 * 体验金购买标的表
 */
public class SubjectBbinPurchaseRecord {
   
	private int id;//ID
	private String serialNumber;//流水号
	private int amount;//购买金额
	private String dealIp;//交易ip
	private int subjectId;//标的Id
	private int memberId;//会员ID
	private int delflag;//是否删除
	private String createDate;//创建时间
	private String updateDate;//修改时间
	private int interest;//结算利息
	private int ispayment;//是否还款
	private int payInterestTimes;//支付次数
	private int lastProfitDay;//最后计息日
}
