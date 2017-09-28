package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.service.BackYingFinancetService;
import com.cornucopia.dao.BackYingJiaFinanceStatisticsDao;

/**
 * 后台-->盈+统计-->财务统计-->service接口实现类
 * @author PC
 *
 */
@Component
@Transactional
public class BackYingJiaFinanceServiceImpl implements BackYingFinancetService{

	@Autowired
	private BackYingJiaFinanceStatisticsDao financeDao;


	/**
	 * 账户充值
	 */
	@Override
	public List deposit(Map map) {
		List depositList=this.financeDao.deposit(map);
		return depositList;
	}
	
	/**
	 * 账户提现
	 */
	@Override
	public List withdraw(Map map) {
		List withdrawList=this.financeDao.withdraw(map);
		return withdrawList;
	}
	
	/**
	 * 用户红包
	 */
	@Override
	public List award(Map map) {
		List awardList=this.financeDao.award(map);
		return awardList;
	}
	
	/**
	 * 总收益-->私募基金
	 */
	public String placement(Map map){
		String placement=this.financeDao.placement(map);
		return placement;
	}
	
	/**
	 * 总收益-->固收理财
	 */
	public String purchase(Map map){
		String purchase=this.financeDao.purchase(map);
		return purchase;
	}

	/**
	 * 平台总消费-->充值
	 */
	@Override
	public List pay(Map map) {
		List payList=this.financeDao.pay(map);
		return payList;
	}
	
	/**
	 * 平台总消费-->消费
	 */
	@Override
	public String lifePay(Map map) {
		String lifePay=this.financeDao.lifePay(map);
		return lifePay;
	}
	
	/**
	 * 总投资-->私募基金
	 */
	public String place(Map map){
		String place=this.financeDao.place(map);
		return place;
	}
	
	/**
	 * 总投资-->固收理财
	 */
	public String purch(Map map){
		String purch=this.financeDao.purch(map);
		return purch;
	}
}
