package com.cornucopia.bean;


/*
 * 用户消息表
 */
public class UserMessage {
   
	 private int id;//主键
	 private int userId;//用户
	 private String title;//消息标题
	 private int businessType;//业务类别
	 private int ownerId;//业务id
	 private String content;//消息内容
	 private int msgStatus;//状态,(已读未读)
	 private int delFlag;//删除标志
	 private String createDate;//创建时间
	 private String updateDate;//修改时间
}
