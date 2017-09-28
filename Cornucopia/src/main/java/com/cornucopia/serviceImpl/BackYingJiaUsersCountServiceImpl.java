package com.cornucopia.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.dao.BackYingJiaUsersCountDao;
import com.cornucopia.service.BackYingCountService;
/**
 * 后台-->盈+统计-->用户综合统计-->service接口实现类
 * @author PC
 *
 */
@Component("backYingJiaUsersCount")
@Transactional
public class BackYingJiaUsersCountServiceImpl implements BackYingCountService{

	@Autowired
	private BackYingJiaUsersCountDao usersCountDao;
	
	/**
	 * 交易记录信息
	 */
	@Override
	public <MemberTradeRecord> List<MemberTradeRecord> listAll(Object obj) {
		List tradeList=this.usersCountDao.tradeList(obj);
		return tradeList;
	}

	/**
	 * 用户基本信息
	 */
	@Override
	public Object member(Object obj) {
		Member member=this.usersCountDao.member(obj);
		return member;
	}


	/**
	 * 资金信息-->充值金额
	 */
	@Override
	public String deposit(Object obj) {
		String damount=this.usersCountDao.deposit(obj);
		return damount;
	}
	
	/**
	 * 资金信息-->提现金额
	 */
	@Override
	public String withdraw(Object obj) {
		String wamount=this.usersCountDao.withdraw(obj);
		return wamount;
	}

	/**
	 * 资金信息-->账户各类金额
	 */
	@Override
	public Object account(Object obj) {
		MemberAccount account=this.usersCountDao.account(obj);
		return account;
	}

	/**
	 * 资金-->红包金额
	 */
	@Override
	public String amount(Object obj) {
		String amount=this.usersCountDao.amount(obj);
		return amount;
	}


//	/**
//	 * 基本信息查询
//	 */
//	@Override
//	public Object listVo(Object obj) {
//		BackYingJiaUsersCountVo countVo=this.usersCountDao.usersCount(obj);
//		return countVo;
//	}
}
