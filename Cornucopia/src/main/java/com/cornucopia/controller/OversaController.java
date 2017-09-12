package com.cornucopia.controller;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.service.OverService;


@Controller
@RequestMapping("BgOver")
public class OversaController {
	
	@Resource
	private OverService overseaImp;
	
	@RequestMapping("/list")
	public String list(OverseaConfig overseaConfig,Model model){
		List list=overseaImp.ListAll(overseaConfig);
		model.addAttribute("list",list);
		return "Bgform";
	}
	
}
