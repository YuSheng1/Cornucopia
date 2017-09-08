package com.cornucopia.bean;

/*
 * 短信记录表
 */
public class SmsRecord {

	private int id;//ID
	private int type;//短信类型
	private String phone;//手机号码
	private String code;//验证码
	private String content;//短信内容
	private String result;//返回结果
	private int status;//状态
	private String senddate;//发送时间
	private String createdate;//创建时间
	
}
