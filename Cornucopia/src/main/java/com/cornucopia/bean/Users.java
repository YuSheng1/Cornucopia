package com.cornucopia.bean;
/*
 * 用户基本表
 */
public class Users {
	
     private int id; //用户id'
     private String userName;//用户名
     private String name;//名称
     private String password;//密码
     private String salt;//密码盐
     private String mobilePhone;//手机号
     private int status;//账号状态(正常，锁定，删除)
     private int delFlag;//删除标志
     private int identity;//身份
     private String createDate;//创建时间
     private String updateDate;//修改时间
}
