package com.cornucopia.bean;

/*
 * 理财类基金产品表
 */
public class FinanceProductFunds {

	private int id;//id
	private String type;//产品类型
	private String name;//名称
	private int status;//状态(0:未发布，1:募集中，2:已结束)
	private int period;//周期
	private int floorAmount;//起投金额
	private int yearRate;//年化率
	private int subscribeCount;//预约人数
	private String productTopic;//基金专题/关于基金
	private String productFactor;//产品要素
	private String productStrategy;//产品策略
	private String productManager;//基金经理详细
	private String createDate;//添加时间
	private String updateDate;//修改时间
	private String productManagerName;//管理人名称
	private String productManagerPic;//管理人图片
	private String productManagerTitle;//管理人头衔
	private String productManagerDesc;//产品管理人介绍
	private String investPoints;//投资方向
	private int amount;//募集金额
	private int soldAmount;//已售金额
	private int buyerCount;//购买人数
	private String startDate;//开始时间
	private String endDate;//结束时间
	private String ratio;//返佣比例
	private String contract;//私募合同
	private String bankAccount;//银行账户（支行名称|银行账号|户名）
}
