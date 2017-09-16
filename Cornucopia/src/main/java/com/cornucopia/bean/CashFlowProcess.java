package com.cornucopia.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class CashFlowProcess {
	private int id;
	private String serialNumbe;
	private int ProcessInstanceId;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumbe() {
		return serialNumbe;
	}
	public void setSerialNumbe(String serialNumbe) {
		this.serialNumbe = serialNumbe;
	}
	public int getProcessInstanceId() {
		return ProcessInstanceId;
	}
	public void setProcessInstanceId(int processInstanceId) {
		ProcessInstanceId = processInstanceId;
	}

}
