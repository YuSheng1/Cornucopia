package com.cornucopia.bean;

/*
 * 理财类基金产品预约记录表
 */
public class FinanceProductSubscribe {

	private int id;//id
	private String name;//名称
	private int memberId;//会员ID
	private String phone;//联系电话
	private int productId;//理财产品ID
	private String addr;//所在地区
	private int status;//是否处理(0:签署拍照|1:已签约|2:审核中|3:签署失败)
	private String comment;//电子签署文档信息
	private String riskReveal;//风险揭示书
	private String createDate;// 添加时间
	private String updateDate;// 修改时间
	private int amount;//私募购买金额
	private int interest;//私募结算收益
	private String startDate;//开始时间
	private String endDate;//结束时间
	private String signedPhotos;//签署拍照
}
