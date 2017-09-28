package com.cornucopia.service;

import java.util.List;

/**
 * 后台-->盈+统计-->-->用户综合统计-->service接口
 * @author PC
 *
 */
public interface BackYingCountService {

	public <T> List<T> listAll(Object obj);
		
	public Object member(Object obj);
	
	public String deposit(Object obj);

	public String withdraw(Object obj);
	
	public Object  account(Object obj);
	
	public String amount(Object obj);
	
//	public Object listVo(Object obj);
}
