package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.PushNotice;
import com.cornucopia.service.PM_PushNoticeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//公告管理controller
@Controller
@RequestMapping("push")
public class PM_PushNoticeController {

	//接口         实现类
	@Resource(name="PM_PushNoticeServiceImpl")
	private PM_PushNoticeService pM_PushNoticeServiceImpl;
	
	//查询所有
	@RequestMapping("list")
	public String listAll(Model model,String title1){
		
		Map map=new HashMap();
		map.put("title1",title1);
		System.out.println(title1);
		 List<PushNotice> plist=pM_PushNoticeServiceImpl.ListAll(map);
		 model.addAttribute("plist",plist);
		 model.addAttribute("title1",title1);
		 return "Bgnotice";
	}
	
	//添加
	@RequestMapping("save")
	public String save(PushNotice pushNotice,String create_date1){
		System.out.println("添加");
		pushNotice.setUpdate_date(create_date1);
		pM_PushNoticeServiceImpl.save(pushNotice);
		return "redirect:/push/list";
	}
	
	//根基Id查询公告内容
	@RequestMapping("cha")
	public String chakan(int id,Model model){
		System.out.println("111");
		PushNotice pushNotice = pM_PushNoticeServiceImpl.chakan(id);
		model.addAttribute("pushNotice",pushNotice);
		return "Bgnoticelist";
	}
	
	//查询是否有该标题
		@ResponseBody
		@RequestMapping("boo")
		public String boo(String title) {
			System.out.println(title+"title是否有标题");
			 boolean boo=pM_PushNoticeServiceImpl.getByTitle(title);
			 Map<String, Boolean> map = new HashMap<>();
		        map.put("valid", boo);
		        System.out.println(boo);
		        ObjectMapper mapper = new ObjectMapper();
		        String resultString = "";
		        try {
		            resultString = mapper.writeValueAsString(map);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
		        return resultString;
		}

}
