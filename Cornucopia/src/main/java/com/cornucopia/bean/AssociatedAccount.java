package com.cornucopia.bean;

/***
 * 关联账号表-第三方登陆信息表
 * @author 2016
 *
 */
public class AssociatedAccount {

	private int id;//id
	private int memberId;//会员ID
	private String type;//账号类型
	private String name;//账号名称
	private String identifying;//账号标识
	private int status;//状况
	private String createDate;//创建时间
	private String updateDate;//修改时间
}
