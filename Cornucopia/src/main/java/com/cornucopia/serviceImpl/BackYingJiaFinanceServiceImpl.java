package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.service.BackYingFinancetService;
import com.cornucopia.dao.BackYingJiaFinanceStatisticsDao;

/**
 * ��̨-->ӯ+ͳ��-->����ͳ��-->service�ӿ�ʵ����
 * @author PC
 *
 */
@Component
@Transactional
public class BackYingJiaFinanceServiceImpl implements BackYingFinancetService{

	@Autowired
	private BackYingJiaFinanceStatisticsDao financeDao;


	/**
	 * �˻���ֵ
	 */
	@Override
	public List deposit(Map map) {
		List depositList=this.financeDao.deposit(map);
		return depositList;
	}
	
	/**
	 * �˻�����
	 */
	@Override
	public List withdraw(Map map) {
		List withdrawList=this.financeDao.withdraw(map);
		return withdrawList;
	}
	
	/**
	 * �û����
	 */
	@Override
	public List award(Map map) {
		List awardList=this.financeDao.award(map);
		return awardList;
	}
	
	/**
	 * ������-->˽ļ����
	 */
	public String placement(Map map){
		String placement=this.financeDao.placement(map);
		return placement;
	}
	
	/**
	 * ������-->�������
	 */
	public String purchase(Map map){
		String purchase=this.financeDao.purchase(map);
		return purchase;
	}

	/**
	 * ƽ̨������-->��ֵ
	 */
	@Override
	public List pay(Map map) {
		List payList=this.financeDao.pay(map);
		return payList;
	}
	
	/**
	 * ƽ̨������-->����
	 */
	@Override
	public String lifePay(Map map) {
		String lifePay=this.financeDao.lifePay(map);
		return lifePay;
	}
	
	/**
	 * ��Ͷ��-->˽ļ����
	 */
	public String place(Map map){
		String place=this.financeDao.place(map);
		return place;
	}
	
	/**
	 * ��Ͷ��-->�������
	 */
	public String purch(Map map){
		String purch=this.financeDao.purch(map);
		return purch;
	}
}
