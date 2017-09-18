package com.cornucopia.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Associated_account") // �����˺ű���������¼��Ϣ��
@Entity
public class AssociatedAccount {

	private int id;// ����
	private String type;// �˺�����(΢�ţ�QQ)
	private String name;// �˺�����
	private String identifying;// �˺ű�ʶ
	private int status;// ���(Ĭ��Ϊ0)
	private Date create_date;// ����ʱ��
	private Date update_date;// �޸�ʱ��
	private Member member;// ��Ա��

	@ManyToOne
	@JoinColumn(name = "member_id", unique = true)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifying() {
		return identifying;
	}

	public void setIdentifying(String identifying) {
		this.identifying = identifying;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}
