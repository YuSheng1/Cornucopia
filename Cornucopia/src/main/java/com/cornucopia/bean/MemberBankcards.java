package com.cornucopia.bean;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Member_bankcards")//��Ա���п���
@Entity
public class MemberBankcards {

	private int id;//����
	private String type;//���п�����
	private int member_id;//�û�id
	private String card_no;//����
	private int delflag;//Ĭ�ϡ�0�� �Ƿ�ɾ��(0������ʹ�ã�2����ɾ��)
	private Date create_date;//����ʱ��
	private Date update_date;//�޸�ʱ��
	private String cardaddress;//�����������ڵ�
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getCardaddress() {
		return cardaddress;
	}
	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}
	
}