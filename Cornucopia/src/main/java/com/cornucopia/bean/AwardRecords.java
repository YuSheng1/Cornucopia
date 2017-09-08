package com.cornucopia.bean;
/*
 * 奖励记录表
 */
public class AwardRecords {

	private int id;//ID	
	private int invitingid;//邀请人ID
	private int byinvitingid;//被邀人ID 
	private int type;//奖励类型(0:注册奖励,1:投资奖励)
	private int isAward;//奖励状态(0:未奖励 1:已奖励)
	private String addTime;//添加时间
	
}
