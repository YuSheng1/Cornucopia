package com.cornucopia.service;

import java.util.List;
import java.util.Map;

/**
 * 后台-->盈+统计-->财务统计-->service接口
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
