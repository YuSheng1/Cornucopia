package com.cornucopia.service;

import java.util.List;
import java.util.Map;

/**
 * ��̨-->ӯ+ͳ��-->����ͳ��-->service�ӿ�
 * @author PC
 *
 */
public interface BackYingFinancetService {

		
	public List deposit(Map map);
	
	public List withdraw(Map map);
	
	public List award(Map map);
	
	public String placement(Map map);
	
	public String purchase(Map mapt);
	
	public List pay(Map map);
	
	public String lifePay(Map map);
	
	public String place(Map map);
	
	public String purch(Map map);
}
