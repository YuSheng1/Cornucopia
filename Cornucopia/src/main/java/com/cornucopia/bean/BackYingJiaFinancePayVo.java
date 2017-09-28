package com.cornucopia.bean;

/**
 * 后台-->盈+统计-->财务统计-->平台总消费-->手机充值，石油卡充值-->值域类
 * @author PC
 *
 */
public class BackYingJiaFinancePayVo {

	private String type;//消费类型
	private float price;//消费金额
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
