package com.cornucopia.bean;

/**
 * 后台-->盈+统计-->财务统计-->账户充值-->值域类
 * @author PC
 *
 */
public class BackYingJiaFinanceDepositVo {

	private String pay_channel_name;//充值渠道名称
	private float samount;//该渠道充值总金额
	
	public String getPay_channel_name() {
		return pay_channel_name;
	}
	public void setPay_channel_name(String pay_channel_name) {
		this.pay_channel_name = pay_channel_name;
	}
	public float getSamount() {
		return samount;
	}
	public void setSamount(float samount) {
		this.samount = samount;
	}
	
}
