package com.cornucopia.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String add(UserRole user,String createdate,String updatedate) {
		user.setCreate_date(createdate);
		user.setUpdate_date(updatedate);
		userRoleServiceImpl.save(user);
		return "redirect:/BgItem/BgUserRoles";
	}
	
	//查询是否有该用户
	@ResponseBody
	@RequestMapping("boo")
	public String boo(String cname) {
		System.out.println(cname+"name");
		 boolean boo=userRoleServiceImpl.getByName(cname);
		 Map<String, Boolean> map = new HashMap<>();
	        map.put("valid", boo);
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
