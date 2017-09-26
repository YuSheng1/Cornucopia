package com.cornucopia.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.PageBean;
import com.cornucopia.bean.PushNotice;
import com.cornucopia.service.PM_PushNoticeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//公告管理controller
@Controller
@RequestMapping("push")
public class PM_PushNoticeController {

	//接口         实现类
	@Resource
	private PM_PushNoticeService PM_PushNoticeServiceImpl;
	
	@Autowired
	private PageBean pb;
	
	//查询所有
	@RequestMapping("list")
	public String listAll(Model model,String title1,@RequestParam(required=true,defaultValue="1")int page,String flag){
		Map map=new HashMap();
		pb.setSize(5);
		pb.setPage(page);
		map.put("title1",title1);
		map.put("flag",flag);
		map.put("pb",pb);
		 List<PushNotice> plist=PM_PushNoticeServiceImpl.ListPush(map);
		 model.addAttribute("plist",plist);
		 model.addAttribute("title1",title1);
		 model.addAttribute("pb",pb);
		 return "Bgnotice";
	}
	
	//添加
	@RequestMapping("save")
	public String save(PushNotice pushNotice,String create_date1){
		pushNotice.setUpdate_date(create_date1);
		PM_PushNoticeServiceImpl.save(pushNotice);
		return "redirect:/push/list";
	}
	
	//根基Id查询公告内容
	@RequestMapping("cha")
	public String chakan(int id,Model model){
		System.out.println("111");
		PushNotice pushNotice = PM_PushNoticeServiceImpl.chakan(id);
		System.out.println(pushNotice.getContent()+"公告内容");
		model.addAttribute("pushNotice",pushNotice);
		return "Bgnoticelist";
	}
	//根基Id查询公告内容
		@RequestMapping("cha1")
		public String chakan1(int id,Model model){
			PushNotice pushNotice = PM_PushNoticeServiceImpl.chakan(id);
			model.addAttribute("pushNotice",pushNotice);
			return "Ag_title";
		}
		
	
	//去修改
		@RequestMapping("updatebyid")
		public String updateById(int id,Model model){
			System.out.println("111");
			PushNotice pushNotice = PM_PushNoticeServiceImpl.chakan(id);
			model.addAttribute("pushNotice",pushNotice);
			return "Bgnoticeupdate";
		}
	//修改
		@RequestMapping("update")
		public String update(PushNotice pushNotice){
			System.out.println("进修改了");
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(date).toString());
			//pushNotice.setCreate_date(sdf.format(date));
			pushNotice.setUpdate_date(sdf.format(date));
			this.PM_PushNoticeServiceImpl.update(pushNotice);
			System.out.println(1);
			return "redirect:/push/list";
		}
	
	//查询是否有该标题
		@ResponseBody
		@RequestMapping("boo")
		public String boo(String title) {
			System.out.println(title+"title");
			 boolean boo=PM_PushNoticeServiceImpl.getByTitle(title);
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
