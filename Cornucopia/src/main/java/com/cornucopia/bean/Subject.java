package com.cornucopia.bean;

/*
 * 主题表
 */
public class Subject {

	 private int id;//ID
	 private String serialNumber; //流水号
	 private String serialNo; //合同号
	 private String name; //标的名称
	 private int type; //标的类型
	 private int status; //标的状态
	 private int floorAmount; //起投金额
	 private int amount; //标的金额
	 private int firstId; //始标id
	 private int parentId; //父标id
	 private int period; //标的周期
	 private String purpose; //借款目的
	 private String raiseStart; //募集开始
	 private String raiseEnd; //募集结束
	 private int refundWay; //还款方式
	 private int safeGuardWay; //保障方式
	 private String startDate; //标的开始日期
	 private String endDate; //标的结束日期
	 private int yearRate; //年化率
	 private String comment; //产品速览
	 private int folderId; //文件夹Id
	 private int delflag; //是否删除
	 private String updateDate; //更新日期
	 private String createDate; //创建日期
	 private String borrowername; //借款人姓名
	 private String borrowerid; //借款人id
	 private int bought; //已购人数
	 private String projectDetails; //项目详情
	 private String safetyControl; //安全保障
	 private int experStatus; //体验金是否可以购买(0：否，1：是)
}
