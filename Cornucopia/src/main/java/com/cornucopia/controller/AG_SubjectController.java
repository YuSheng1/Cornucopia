package com.cornucopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.Subject;
import com.cornucopia.service.AG_SubjectService;

@Controller
@RequestMapping("AGSub")
public class AG_SubjectController {

	@Autowired
	private AG_SubjectService AG_subjectServiceImpl;
	
	@RequestMapping("subject")
	public String subject(Model model ){
		System.out.println("12345");
		List<Subject> slist=AG_subjectServiceImpl.ListAll();
		model.addAttribute("slist", slist);
		return "Example";
	}
}
