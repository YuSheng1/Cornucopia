package com.cornucopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.Subject;
import com.cornucopia.service.AG_SubjectService;

@Controller
@RequestMapping("AGSub")
public class AG_SubjectController {

	@Autowired
	private AG_SubjectService AG_subjectServiceImpl;
	
	@RequestMapping("subject")
	public String subject(Model model,String name){
		System.out.println("12345");
		List<Subject> slist=AG_subjectServiceImpl.ListAllS(name);
		model.addAttribute("slist", slist);
		return "Example";
	}
	
	@RequestMapping("fund")
	public String fund(Model model){
		System.out.println("000");
		List<FinanceProductFunds> flist=AG_subjectServiceImpl.ListAllF();
		model.addAttribute("flist", flist);
		return "AGFund";
	}
	
	@RequestMapping("overseas")
	public String overseas(Model model){
		System.out.println("111");
		List<OverseaConfig> olist=AG_subjectServiceImpl.ListAllO();
		model.addAttribute("olist", olist);
		return "AGOverseas";
	}
}
