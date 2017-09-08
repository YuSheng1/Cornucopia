package com.cornucopia.bean;

/*
 * 金融产品订阅记录表
 */
public class FinanceProductSubscribeRecord {

	private int id;//id
	private int memberId;//会员ID
	private int subscribeId;//私募预约记录ID
	private String techUserId;//e签宝个人账号
	private String techUserSeal;//e签宝个人印章
	private String orgPath;//原签署文档路径 
	private String newPath;//新签署文档路径
	private int status;//状态	
	private String createDate;//创建时间	
	private String updateDate;//修改时间
	private String filedl;//备用字段
}
