package com.cornucopia.bean;
/*
 * 用户登陆令牌表
 */
public class UserLoginToken {
     
	private String token;//令牌号
	private int userId;//用户id
	private String userName;//登录时的用户名，可以是用户名，手机号等
	private String password;//密码
	private String expireTime;//有效时间
	private String createDate;//创建时间
	private String updateDate;//修改时间
}
