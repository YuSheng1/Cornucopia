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

import com.cornucopia.bean.News;
import com.cornucopia.bean.NewsType;
import com.cornucopia.bean.UserRole;
import com.cornucopia.service.PM_NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("BgType")
public class PM_NewsTypeCotroller {

	@Resource(name="PM_NewsTypeServiceImpl")
	private PM_NewsService pm_NewsTypeServiceImpl;
	@Resource(name="PM_NewsServiceImpl")
	private PM_NewsService PM_NewsServiceImpl;
	
	
	//后台学院管理咨询分类
		@RequestMapping("BgConsultation")
		public String BgConsultation(Model model) {
			List<NewsType> tlist=pm_NewsTypeServiceImpl.ListAll();
			model.addAttribute("tlist",tlist);
			return "BgConsultation";
		}
		
	//添加分类
		@RequestMapping("add")
		public String add(NewsType newsType,String addTime) {
			newsType.setAddTime(addTime);
			pm_NewsTypeServiceImpl.save(newsType);
			return "redirect:/BgType/BgConsultation";
		}
		//添加分类
				@RequestMapping("NewsById")
				public String NewsById(int id,Model model) {
					List<News> news=PM_NewsServiceImpl.ListAllById(id);
					model.addAttribute("news",news);
					return "AG_NewConType";
				}
				@RequestMapping("NewsByIdA")
				public String NewsByIdA(int id,Model model) {
					News news=PM_NewsServiceImpl.NewsByIdA(id);
					model.addAttribute("newcon",news);
					return "AG_NewCon";
				}	
				
		//修改
		@RequestMapping("update")
		public String update(NewsType newsType) {
			System.out.println(newsType.getTId());
			pm_NewsTypeServiceImpl.update(newsType);
			return "redirect:/BgType/BgConsultation";
		}
		
		
		//查询是否有该类别
		@ResponseBody
		@RequestMapping("boo")
		public String boo(String name) {
			System.out.println(name+"name");
			 boolean boo=pm_NewsTypeServiceImpl.getByName(name);
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
