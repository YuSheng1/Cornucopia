package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.service.BackYingFinancetService;


/**
 * 后台-->盈+统计-->财务统计
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/backYingJiaFinanceStatistics")
public class BackYingJiaFinanceStatisticsController {

	@Resource
	private BackYingFinancetService BackYingJiaFinanceServiceImpl;
	
	@RequestMapping("/login")
	public String login(Model model,String start,String end,String mons){
		Map map=new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("mons", mons);
		
		List depositList=this.BackYingJiaFinanceServiceImpl.deposit(map);
		List withdrawList=this.BackYingJiaFinanceServiceImpl.withdraw(map);
		List awardList=this.BackYingJiaFinanceServiceImpl.award(map);
		String placement=this.BackYingJiaFinanceServiceImpl.placement(map);
		String purchase=this.BackYingJiaFinanceServiceImpl.purchase(map);
		List payList=this.BackYingJiaFinanceServiceImpl.pay(map);
		String  lifePay=this.BackYingJiaFinanceServiceImpl.lifePay(map);
		String place=this.BackYingJiaFinanceServiceImpl.place(map);
		String purch=this.BackYingJiaFinanceServiceImpl.purch(map);
		model.addAttribute("depositList", depositList);
		model.addAttribute("withdrawList", withdrawList);
		model.addAttribute("awardList", awardList);
		model.addAttribute("placement", placement);
		model.addAttribute("purchase", purchase);
		model.addAttribute("payList", payList);
		model.addAttribute("lifePay", lifePay);
		model.addAttribute("place", place);
		System.out.println(purch);
		model.addAttribute("purch", purch);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		return "backYingJiaFinanceStatistics";
	}
}
