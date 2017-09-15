package com.cornucopia.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Member_profit_record") // 会员收益记录表
@Entity
public class MemberProfitRecord {

	private int id;// 主键
	private String serial_number;// 流水号
	private int type;// 类型
	private int amount;// 金额
	private int delflag;// 标志
	private String create_date;// 创建时间
	private String update_date;// 修改时间
	private String comment;// 备注
	private int profit_year;// 默认‘0’ 计息年
	private int profit_month;// 默认‘0’ 计息月
	private int profit_day;// 默认‘0’ 计息日
	private Member member;
	private Subject subject;
	@ManyToOne
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	@ManyToOne
	@JoinColumn(name = "subject_id")
	public Subject getsubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
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

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProfit_year() {
		return profit_year;
	}

	public void setProfit_year(int profit_year) {
		this.profit_year = profit_year;
	}

	public int getProfit_month() {
		return profit_month;
	}

	public void setProfit_month(int profit_month) {
		this.profit_month = profit_month;
	}

	public int getProfit_day() {
		return profit_day;
	}

	public void setProfit_day(int profit_day) {
		this.profit_day = profit_day;
	}

}
