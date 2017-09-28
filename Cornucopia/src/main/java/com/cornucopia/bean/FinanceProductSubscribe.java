package com.cornucopia.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Finance_product_subscribe") // 锟斤拷锟斤拷锟斤拷锟斤拷品预约锟斤拷录锟斤拷
@Entity
public class FinanceProductSubscribe {
	private int id;// 锟斤拷锟斤拷
	private String name;// 锟斤拷锟�
	private String phone;// 锟斤拷系锟界话
    private String addr;// 锟斤拷锟节碉拷锟斤拷
	private int status;// 锟角凤拷锟斤拷(0:签锟斤拷锟斤拷锟斤拷|1:锟斤拷签约|2:锟斤拷锟斤拷锟絴3:签锟斤拷失锟斤拷)
	private String comment;// 锟斤拷锟斤拷签锟斤拷锟侥碉拷锟斤拷息
	private String risk_reveal;// 锟斤拷锟秸斤拷示锟斤拷
	private String create_date;// 锟斤拷锟斤拷时锟斤拷
	private String update_date;// 锟睫革拷时锟斤拷
	private int amount;// 私募锟斤拷锟斤拷锟斤拷
	private int interest;// 私募锟斤拷锟斤拷锟斤拷锟斤拷
	private String start_date;// 锟斤拷始时锟斤拷
	private String end_date;// 锟斤拷锟斤拷时锟斤拷
	private String signed_photos;// 签锟斤拷锟斤拷锟斤拷
	private FinanceProductFunds financeProductFunds;
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	public FinanceProductFunds getFinanceProductFunds() {
		return financeProductFunds;
	}

	public void setFinanceProductFunds(FinanceProductFunds financeProductFunds) {
		this.financeProductFunds = financeProductFunds;
	}

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRisk_reveal() {
		return risk_reveal;
	}

	public void setRisk_reveal(String risk_reveal) {
		this.risk_reveal = risk_reveal;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getSigned_photos() {
		return signed_photos;
	}

	public void setSigned_photos(String signed_photos) {
		this.signed_photos = signed_photos;
	}

}
