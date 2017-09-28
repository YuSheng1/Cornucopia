package com.cornucopia.bean;

/**
 * 后台-->盈+统计-->用户综合统计--值域类
 * @author PC
 *
 */
public class BackYingJiaUsersCountVo {

	private String member_name;//真实姓名
	private String identity;//身份
	private String mobile_Phone;//手机号
	private String create_date;//创建时间
	private String weixinAccount;//微信账号关联
	private String qqNumber;//QQ账号
	private String invitationCode;//邀请码
	private String invitedCode;//被邀请码
	private float damount;//充值金额
	private float wamount;//默认‘0.00’ 提现金额
	private float invest_amount;//投资金额
	private float tamount;//交易金额
	private float total_profit;//收益金额
	private float ramount;//红包返利
	private float useable_balance;//可用余额
	private float imuseale_balance;//冻结余额
	private float bonus_amount;//红包金额
	private float bbin_amount;//体验金
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getMobile_Phone() {
		return mobile_Phone;
	}
	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getWeixinAccount() {
		return weixinAccount;
	}
	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getInvitedCode() {
		return invitedCode;
	}
	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}
	public float getDamount() {
		return damount;
	}
	public void setDamount(float damount) {
		this.damount = damount;
	}
	public float getWamount() {
		return wamount;
	}
	public void setWamount(float wamount) {
		this.wamount = wamount;
	}
	public float getInvest_amount() {
		return invest_amount;
	}
	public void setInvest_amount(float invest_amount) {
		this.invest_amount = invest_amount;
	}
	public float getTamount() {
		return tamount;
	}
	public void setTamount(float tamount) {
		this.tamount = tamount;
	}
	public float getTotal_profit() {
		return total_profit;
	}
	public void setTotal_profit(float total_profit) {
		this.total_profit = total_profit;
	}
	public float getRamount() {
		return ramount;
	}
	public void setRamount(float ramount) {
		this.ramount = ramount;
	}
	public float getUseable_balance() {
		return useable_balance;
	}
	public void setUseable_balance(float useable_balance) {
		this.useable_balance = useable_balance;
	}
	public float getImuseale_balance() {
		return imuseale_balance;
	}
	public void setImuseale_balance(float imuseale_balance) {
		this.imuseale_balance = imuseale_balance;
	}
	public float getBonus_amount() {
		return bonus_amount;
	}
	public void setBonus_amount(float bonus_amount) {
		this.bonus_amount = bonus_amount;
	}
	public float getBbin_amount() {
		return bbin_amount;
	}
	public void setBbin_amount(float bbin_amount) {
		this.bbin_amount = bbin_amount;
	}
	
}
