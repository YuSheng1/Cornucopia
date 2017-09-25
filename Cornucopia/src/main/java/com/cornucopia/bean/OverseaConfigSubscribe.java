package com.cornucopia.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "oversea_config_subscribe") // �������ö��ı�
@Entity

public class OverseaConfigSubscribe {

	private int id;// ����
	
	private String name;// ����
	private String phone;// �绰
	private String addr;// ��ַ
	private int status;// ״̬
	private String create_date;// ����ʱ��
	private String update_date;// �޸�ʱ��
	private OverseaConfig overseaConfig;
	private Member member;

	@ManyToOne
	@JoinColumn(name = "member_id")
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

	
    @ManyToOne
    @JoinColumn(name="oversea_id")
	public OverseaConfig getOverseaConfig() {
		return overseaConfig;
	}

	public void setOverseaConfig(OverseaConfig overseaConfig) {
		this.overseaConfig = overseaConfig;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
}
