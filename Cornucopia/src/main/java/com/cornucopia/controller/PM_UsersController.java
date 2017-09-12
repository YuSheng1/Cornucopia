package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.activiti.engine.identity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.bean.Users;
import com.cornucopia.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("PM_UsersItem")
public class PM_UsersController {
	//用户权限相关操作
	@Resource
	private UserService userRolesResources;
	//用户相角色操作
	@Resource
	private UserService userRoleServiceImpl;
	//用户相角色操作
		@Resource
		private UserService userServiceImpl;
	// 添加用户权限
	@RequestMapping("PM_RolesAdd")
	public String BgRight(String msg, int id,String data) {
		  UserRole user=userRoleServiceImpl.getById(id);
		  System.out.println(data);
		user.setUpdate_date(data);
		 userRoleServiceImpl.update(user);
		msg+="8,29,30,31,";
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
	//修改用户角色
	@RequestMapping("update")
	public String  update(String name,String update_date,int error) {
		  Users user=userServiceImpl.getByName(name);
		  UserRole userrole=userRoleServiceImpl.getById(error);
		          user.setUserrole(userrole);
		          user.setUpdate_date(update_date);
			userServiceImpl.save(user);
		return "redirect:/BgItem/BgUserPermission";
	}
	//删除用户
		@RequestMapping("del")
		public String  del(int delid) {
			  UserRole user=userRoleServiceImpl.getById(delid);
				 userRoleServiceImpl.delete(user);
			return "redirect:/BgItem/BgUserRoles";
		}
		
	//查询是否有该用户
	@ResponseBody
	@RequestMapping("boo")
	public String boo(String user_name) {
		System.out.println(user_name+"name");
		boolean boo=userRolesResources.getByName(user_name);
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
