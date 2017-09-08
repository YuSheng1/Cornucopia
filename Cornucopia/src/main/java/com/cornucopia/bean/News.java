package com.cornucopia.bean;

/*
 * 新闻列表
 */
public class News {

	private int id;//ID
	private int typeId;//所属类别
	private String title;//标题
	private String subTitle;//副标题
	private int sort;//排序
	private String info;//简介
	private String cPhoto;//封面图片
	private String link;//链接地址
	private String author;//作者
	private String source;//来源
	private String label;//标签
	private int clickNumber;//点击数量
	private String text;//内容
	private String filelink;//附件地址
	private String seoTitle;//页面seo标题
	private String seoKey;//seo关键字
	private String seoDes;//seo描述
	private int placTop;//是否置顶 0：为是  1为否
	private int recommend;//是否推荐
	private int audit;//是否审核
	private int addId;//添加人ID
	private int updId;//修改人ID
	private String updTime;//修改时间
	private String addTime;//添加时间
	
}
