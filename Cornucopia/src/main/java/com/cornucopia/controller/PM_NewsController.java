package com.cornucopia.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.NewsType;
import com.cornucopia.service.PM_NewsService;

@Controller
@RequestMapping("BgNews")
public class PM_NewsController {

	@Resource
	private PM_NewsService newsServiceImpl;
	
	//后台学院管理咨询管理
		@RequestMapping("BgTration")
		public String BgTration(Model model){
			List<NewsType> list=newsServiceImpl.ListAll();
			model.addAttribute("list",list);
			return "BgTration";
		}
}
