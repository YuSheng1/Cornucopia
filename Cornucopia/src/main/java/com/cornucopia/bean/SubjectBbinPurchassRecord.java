package com.cornucopia.bean;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject_bbin_purchass_record")//体验金购买标的
public class SubjectBbinPurchassRecord {
               
	              private int id;//主键
	              private String serial_number;//流水号
	              private int amount;//购买金额
	              private String deal_ip;//交易ip
	              private int subject_id;//标的ip
	              private int member_id;//
	              private int delflag;
	              private Date create_date;
	              private Date update_date;
	              private int interest;//结算利息
	              private int ispayment;//是否还款
	              private int pay_interest_times;
	              private int last_profit_day;//最后计息日
	              
	              public int getPay_interest_times() {
					return pay_interest_times;
				}
				public void setPay_interest_times(int pay_interest_times) {
					this.pay_interest_times = pay_interest_times;
				}
				public int getLast_profit_day() {
					return last_profit_day;
				}
				public void setLast_profit_day(int last_profit_day) {
					this.last_profit_day = last_profit_day;
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
				public int getAmount() {
					return amount;
				}
				public void setAmount(int amount) {
					this.amount = amount;
				}
				public String getDeal_ip() {
					return deal_ip;
				}
				public void setDeal_ip(String deal_ip) {
					this.deal_ip = deal_ip;
				}
				public int getSubject_id() {
					return subject_id;
				}
				public void setSubject_id(int subject_id) {
					this.subject_id = subject_id;
				}
				public int getMember_id() {
					return member_id;
				}
				public void setMember_id(int member_id) {
					this.member_id = member_id;
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
				public int getInterest() {
					return interest;
				}
				public void setInterest(int interest) {
					this.interest = interest;
				}
				public int getIspayment() {
					return ispayment;
				}
				public void setIspayment(int ispayment) {
					this.ispayment = ispayment;
				}
	              
	              
	       
}
