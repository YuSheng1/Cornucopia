package com.cornucopia.bean;

/*
 * 行政区表
 */
public class SysRegion {
    
	private int id;// ID
	private String gb2260;//行政区域国标代码
	private String name;//行政区名称
	private int regionLevel;//行政区级别
	private int parentId;//父id
	private String parentIds;//父id列表
	private String parentGb2260;//父编码
	private String diallingCode;//电话区号
	private String createDate;//创建时间
	private String lastModified;//最后修改时间
}
