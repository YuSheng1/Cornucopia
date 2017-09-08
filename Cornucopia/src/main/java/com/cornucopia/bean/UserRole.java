package com.cornucopia.bean;
/*
 * 角色表
 */
public class UserRole {
    
	private int id;//主键
	private String cname;//中文名
	private String ename;//英文名
	private int available;//是否可用
	private String remark;//备注
	private String createDate;//创建时间
	private String updateDate;//修改时间
	private String category;//分类
	private int sourceType;//源型类别
	private int sourceId;//源ID
	private int delFlag;//是否删除
}
