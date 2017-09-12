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

import com.cornucopia.bean.NewsType;
import com.cornucopia.service.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("BgType")
public class NewsCotroller {

	@Resource
	private NewsService newsTypeServiceImpl;
	
	//后台学院管理咨询分类
		@RequestMapping("BgConsultation")
		public String BgConsultation(Model model) {
			List<NewsType> tlist=newsTypeServiceImpl.ListAll();
			model.addAttribute("tlist",tlist);
			return "BgConsultation";
		}
		
		//后台学院管理咨询管理
		@RequestMapping("BgTration")
		public String BgTration(){
			return "BgTration";
		}
	
	//添加分类
		@RequestMapping("add")
		public String add(NewsType newsType,String addTime) {
			newsType.setAddTime(addTime);
			newsTypeServiceImpl.save(newsType);
			return "redirect:/BgType/BgConsultation";
		}
		
		//修改
		@RequestMapping("update")
		public String update(NewsType newsType) {
			System.out.println(newsType.getId());
			newsTypeServiceImpl.update(newsType);
			return "redirect:/BgType/BgConsultation";
		}
		
		//删除
		@RequestMapping("/delete")
		public String delete(int id ) {
			System.out.println(123);
			newsTypeServiceImpl.delete(id);
			return "redirect:/BgType/BgConsultation";
		}
		
		
		//查询是否有该类别
		@ResponseBody
		@RequestMapping("boo")
		public String boo(String name) {
			System.out.println(name+"name");
			 boolean boo=newsTypeServiceImpl.getByName(name);
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
