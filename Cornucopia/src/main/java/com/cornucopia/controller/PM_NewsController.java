package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.News;
import com.cornucopia.bean.NewsType;
import com.cornucopia.bean.UserRole;
import com.cornucopia.bean.Users;
import com.cornucopia.service.PM_NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("BgNews")
public class PM_NewsController {

	@Resource(name="PM_NewsServiceImpl")
	private PM_NewsService newsServiceImpl;
	
	@Resource(name="PM_NewsTypeServiceImpl")
	private PM_NewsService newsTypeServiceImpl;
	
	//后台学院管理咨询管理
		@RequestMapping("BgTration")
		public String BgTration(Model model){
			List<News> list=newsServiceImpl.ListAll();
			model.addAttribute("list",list);
			List<NewsType> tlist=newsTypeServiceImpl.ListAll();
			model.addAttribute("tlist",tlist);
 			return "BgTration";
		}
		
		// 添加标题
		@RequestMapping("add")
		public String add(News news, int error,String addTime) {
			news.setAddTime(addTime);
			NewsType newsType = newsTypeServiceImpl.getById(error);
			news.getTitle();
			news.setNewsType(newsType);
			newsServiceImpl.save(news);

			return "redirect:/BgNews/BgTration";
		}
		
		// 删除标题
				@RequestMapping("del")
				public String del(int delid) {
					System.out.println(delid);
					News news = newsServiceImpl.getById(delid);
					newsServiceImpl.delete(news);
					return "redirect:/BgNews/BgTration";
				}
		
		// 修改标题
				@RequestMapping("update")
				public String update(String title,String updTime,int error) {
					System.out.println("000123");
					News news = newsServiceImpl.getByName(title);
					NewsType newsType = newsTypeServiceImpl.getById(error);
					news.setNewsType(newsType);
					news.setUpdTime(updTime);
					newsServiceImpl.save(news);
					return "redirect:/BgNews/BgTration";
				}
		
		// 查询是否有该标题
		@ResponseBody
		@RequestMapping("boo")
		public String boo(String title) {
			System.out.println(title + "title");
			boolean boo = newsTypeServiceImpl.getByName(title);
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
