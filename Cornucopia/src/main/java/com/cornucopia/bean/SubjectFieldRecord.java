package com.cornucopia.bean;

/*
 * 主题记录表
 */
public class SubjectFieldRecord {
    
	private int id;// ID
	private int subjectId;//标的Id
	private int fieldId;//字段id
	private String fieldValue;//字段值
	private int delflag;//删除标记
	private String createDate;//创建日期
	private String updateDate;//更新日期
}
