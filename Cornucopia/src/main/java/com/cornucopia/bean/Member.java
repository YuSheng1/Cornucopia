package com.cornucopia.bean;

/*
 * 用户基本表
 */
public class Member {

	private int id;//用户ID	
	private String memberName;//真实姓名
	private String name;//用户名
	private String password;//密码
	private String salt;//密码盐
	private String mobilePhone;//手机号
	private int status;//账号状态（正常，锁定，删除）
	private int delFlag;//删除标志
	private String identity;//身份
	private String createDate;//创建时间
	private String updateDate;//修改时间
	private String weiBoAccount;//微博账号关联
	private String weixinAccount;//微信账号关联
	private int headid;//头像图片ID
	private String invitationCode;//邀请码
	private String withdrawPassword;//提款密码
	private String qqAccount;//QQ账号关联
	private String invitedCode;//被邀请码
	private String qqNumber;//QQ号码
}
