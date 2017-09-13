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
import com.cornucopia.service.PM_UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("PM_RolesItem")
public class PM_RolesController {
	//角色权限相关操作
	@Resource
	private PM_UserService PM_UserRolesResources;
	//角色相关操作
	@Resource
	private PM_UserService PM_UserRoleServiceImpl;
	// 添加用户权限
	@RequestMapping("PM_RolesAdd")
	public String BgRight(String msg, int id,String data) {
		  UserRole user=PM_UserRoleServiceImpl.getById(id);
		  System.out.println(data);
		user.setUpdate_date(data);
		 PM_UserRoleServiceImpl.update(user);
		msg+="8,29,30,31,";
		PM_UserRolesResources.save(msg,id);
		return "BgUserRoles";
	}
	//添加角色
	@RequestMapping("add")
	public String add(UserRole user,String createdate,String updatedate,String cname) {
		user.setCname(cname);
			 user.setCreate_date(createdate);
			 user.setUpdate_date(updatedate);
			PM_UserRoleServiceImpl.save(user);
	
		return "redirect:/BgItem/BgUserRoles";
	}
	//修改角色
	@RequestMapping("update")
	public String  update(UserRole user,String createdate1,String cname1) {
		   List list=PM_UserRoleServiceImpl.ListAlltrue(user.getId());
		           user.setCname(cname1);
			 user.setCreate_date(createdate1);
			 PM_UserRoleServiceImpl.update(user);
			   PM_UserRolesResources.saveaa(user.getId(),list);
		return "redirect:/BgItem/BgUserRoles";
	}

	// 删除角色
	@RequestMapping("del")
	public String del(int delid) {
		UserRole user = PM_UserRoleServiceImpl.getById(delid);
		//这里有个问题，不会删除用户表
		PM_UserRoleServiceImpl.delete(user);
		return "redirect:/BgItem/BgUserRoles";
	}

	//查询是否有该角色
	@ResponseBody
	@RequestMapping("boo")
	public String boo(String cname) {
		System.out.println(cname+"name");
		 boolean boo=PM_UserRoleServiceImpl.getByName(cname);
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
