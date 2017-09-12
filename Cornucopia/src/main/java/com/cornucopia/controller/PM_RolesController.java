package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("PM_RolesItem")
public class PM_RolesController {
	//角色权限相关操作
	@Resource
	private UserService userRolesResources;
	//角色相关操作
	@Resource
	private UserService userRoleServiceImpl;
	// 添加用户权限
	@RequestMapping("PM_RolesAdd")
	public String BgRight(String msg, int id) {
		userRolesResources.save(msg,id);
		return "BgUserRoles";
	}
	//添加用户
	@RequestMapping("add")
	public String add(UserRole user,String createdate,String updatedate,String cname) {
		user.setCname(cname);
			 user.setCreate_date(createdate);
			 user.setUpdate_date(updatedate);
			userRoleServiceImpl.save(user);
	
		return "redirect:/BgItem/BgUserRoles";
	}
	//修改用户
	@RequestMapping("update")
	public String  update(UserRole user,String createdate1,String cname1) {
		   List list=userRoleServiceImpl.ListAlltrue(user.getId());
		           user.setCname(cname1);
			 user.setCreate_date(createdate1);
			 userRoleServiceImpl.update(user);
			   userRolesResources.saveaa(user.getId(),list);
		return "redirect:/BgItem/BgUserRoles";
	}
	
	//查询是否有该角色
	@ResponseBody
	@RequestMapping("boo")
	public String boo(String cname) {
		System.out.println(cname+"name");
		 boolean boo=userRoleServiceImpl.getByName(cname);
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
