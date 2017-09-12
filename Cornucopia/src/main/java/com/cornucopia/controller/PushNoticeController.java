package com.cornucopia.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.PushNotice;
import com.cornucopia.service.PushNoticeService;

@Controller
@RequestMapping("/push")
public class PushNoticeController {

	//接口         实现类
	@Resource
	private PushNoticeService pushNoticeServiceImpl;
	
	@RequestMapping("list")
	public String listAll(PushNotice pushNotice,Model model){
		 List<PushNotice> plist=pushNoticeServiceImpl.ListAll(pushNotice);
		 model.addAttribute("plist",plist);
		 return "Bgnotice";
	}
	
	@RequestMapping("delete")
	public String delete(int id){
		pushNoticeServiceImpl.delete(id);
		return "redirect:/push/list";
	}
	
	@RequestMapping("/save")
	public String save(PushNotice pushNotice){
		pushNoticeServiceImpl.save(pushNotice);
		return "redirect:/push/list";
	}
}
