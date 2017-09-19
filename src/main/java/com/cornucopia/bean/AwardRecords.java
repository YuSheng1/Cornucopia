package com.cornucopia.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Award_records")//'������¼��'
@Entity
public class AwardRecords {

	private int id;//����
	private int invitingid;//������id
	private int byinvitingid;//��������id
	private int type;//�������ͣ�0��ע�ά����1��Ͷ�ʽ�����
	private int amount;//�������
	private int isAward;//0:δ����  1���ѽ���
	private Date addTime;//���ʱ��
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvitingid() {
		return invitingid;
	}
	public void setInvitingid(int invitingid) {
		this.invitingid = invitingid;
	}
	public int getByinvitingid() {
		return byinvitingid;
	}
	public void setByinvitingid(int byinvitingid) {
		this.byinvitingid = byinvitingid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIsAward() {
		return isAward;
	}
	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
