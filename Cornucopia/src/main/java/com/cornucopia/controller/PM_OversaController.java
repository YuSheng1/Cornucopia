package com.cornucopia.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.service.PM_OverService;
@Controller
@RequestMapping("BgOver")
public class PM_OversaController {
	
	@Resource
	private PM_OverService PM_OverseaImp;
	
	@RequestMapping("/list")
	public String list(OverseaConfig overseaConfig,Model model){
       List list=PM_OverseaImp.ListAll(overseaConfig);
		model.addAttribute("list",list);
		return "Bgform";
	}
	@RequestMapping("/toadd")
	public String toadd(){
		return "Bgtosave";
	}
	
	@RequestMapping("/save")
	public String save(OverseaConfig overseaConfig,String addTime){
		System.out.println("123456");
	    overseaConfig.setAddTime(addTime);
		PM_OverseaImp.save(overseaConfig);
		return "redirect:/BgOver/list";
	}
	@RequestMapping("/listAlll")
	public String listAlll(int id,Model model){
     System.out.println(id);
	 List lists= PM_OverseaImp.ListAlll(id);
	 model.addAttribute("lists", lists);
	  return "Bglist";
	}
	@RequestMapping("/toupdate")
	public String toupdate(int id,Model model){
     System.out.println(id);
     OverseaConfig overseaConfig=PM_OverseaImp.getById(id);
	 model.addAttribute("overseaConfig", overseaConfig);
	  return "BgUpover";
	}
	
	 @RequestMapping("/update1")
     public String update1(OverseaConfig overseaConfig,String updTime,String title,String child_title,
 			String description,String user_type,String start_time,String end_time,String status,String 
 			content,int sid){
		    System.out.println(title);
		    overseaConfig=PM_OverseaImp.getById(sid);
		    overseaConfig.setTitle(title);
		    overseaConfig.setChild_title(child_title);
		    overseaConfig.setDescription(description);
		    overseaConfig.setUser_type(user_type);
		    overseaConfig.setStart_time(start_time);
		    overseaConfig.setStatus(Integer.parseInt(status));
		    overseaConfig.setContent(content);
	    overseaConfig.setEnd_time(end_time);
		    overseaConfig.setUpdTime(updTime);
			PM_OverseaImp.update(overseaConfig);
			return "redirect:/BgOver/list";
		}

}
