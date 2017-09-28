package com.cornucopia.bean;

/**
 * 后台-->盈+统计-->财务统计-->账户提现-->值域类
 * @author PC
 *
 */
public class BackYingJiaFinanceWithdrawVo {

	private String channel_name;//充值渠道名称
	private float wamount;//该渠道提现总金额
	
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public float getWamount() {
		return wamount;
	}
	public void setWamount(float wamount) {
		this.wamount = wamount;
	}
}
