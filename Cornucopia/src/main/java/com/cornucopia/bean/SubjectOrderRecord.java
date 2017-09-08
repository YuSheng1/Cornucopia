package com.cornucopia.bean;

/*
 * 标的订单表
 */
public class SubjectOrderRecord {
     
	private int id;//ID 
	private String serialNumber;//流水号
	private int dealType;//交易类型
	private int amount;// 订单金额
	private int status;//订单状态
	private int subjectId;//标的id
	private int memberId;//用户id
	private int delflag;//是否删除
	private String createDate;//创建日期
	private String updateDate;//更新日期
	
}
