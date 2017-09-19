package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.Feedback;
import com.cornucopia.service.PM_PushNoticeService;

//意见反馈controller
@Controller
@RequestMapping("feed")
public class PM_FeedBackController {

	@Resource(name="PM_FeedBackServiceImpl")
	private PM_PushNoticeService pM_FeedBackServiceImpl;
	
	//查询所有
		@RequestMapping("list")
		public String listAll(Model model){
			 List<Feedback> flist=pM_FeedBackServiceImpl.ListAll();
			 model.addAttribute("flist",flist);
			 return "Bgfeedback";
		}
}
