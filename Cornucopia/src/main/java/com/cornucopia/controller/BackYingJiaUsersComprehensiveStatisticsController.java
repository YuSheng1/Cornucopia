package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;


/**
 * 后台-->盈+统计-->用户综合统计
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/backYingJiaUsersComprehensiveStatistics")
public class BackYingJiaUsersComprehensiveStatisticsController {

	@Resource(name="backYingJiaUsersCount")
	private com.cornucopia.service.BackYingCountService BackYingJiaUsersCountServiceImpl;
	
	@RequestMapping("/login")
	public String login(Model model,String phone,String start,String end,String qtrade_type){
		Map map=new HashMap<>();
		map.put("phone", phone);
		map.put("start", start);
		map.put("end", end);
		map.put("qtrade_type", qtrade_type);
		
		//用户信息
		Member member=(Member) this.BackYingJiaUsersCountServiceImpl.member(phone);
		if(member!=null){//用户存在时
		//资金信息
		String damount=this.BackYingJiaUsersCountServiceImpl.deposit(phone);
		String wamount=this.BackYingJiaUsersCountServiceImpl.withdraw(phone);
		
		//交易记录
		List tradeList=this.BackYingJiaUsersCountServiceImpl.listAll(map);
		
		//资金信息-->某些金额
		MemberAccount account=(MemberAccount) this.BackYingJiaUsersCountServiceImpl.account(phone);
		
		//资金信息-->红包金额
		String amount=this.BackYingJiaUsersCountServiceImpl.amount(member.getId());
		
		//最初的基本信息方法
		//BackYingJiaUsersCountVo countVo=(BackYingJiaUsersCountVo) this.BackYingJiaUsersCountServiceImpl.listVo(phone);
		//model.addAttribute("countVo", countVo);
		//页面取值 ${countVo.值域内字段名}
		
		model.addAttribute("member", member);
		
		model.addAttribute("damount", damount);
		model.addAttribute("wamount", wamount);
		model.addAttribute("account", account);
		model.addAttribute("amount", amount);
		
		model.addAttribute("phone", phone);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		model.addAttribute("tradeList", tradeList);
		}
		return "backYingJiaUsersComprehensiveStatistics";
	}
}
