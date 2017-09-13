package com.cornucopia.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.UserRole;
import com.cornucopia.bean.Users;
import com.cornucopia.service.PM_UserService;
import com.cornucopia.service.ValidateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passwordauthentification.MD5Aauthentification;

@Controller
@RequestMapping("PM_UsersItem")
public class PM_UsersController {
	// 用户权限相关操作
	@Resource
	private PM_UserService PM_UserRolesResources;
	// 用户相角色操作
	@Resource
	private PM_UserService PM_UserRoleServiceImpl;
	@Resource
	private ValidateService validateImpl;

	// 用户相角色操作
	@Resource
	private PM_UserService PM_UserServiceImpl;
	
	MD5Aauthentification mD5Aauthentification = new MD5Aauthentification();

	// 添加用户权限
	@RequestMapping("PM_RolesAdd")
	public String BgRight(String msg, int id, String data) {
		UserRole user = PM_UserRoleServiceImpl.getById(id);
		System.out.println(data);
		user.setUpdate_date(data);
		PM_UserRoleServiceImpl.update(user);
		msg += "8,29,30,31,";
		PM_UserRolesResources.save(msg, id);
		return "BgUserRoles";
	}

	// 添加用户
	@RequestMapping("add")
	public String add(Users user, int error) {
		UserRole userrole = PM_UserRoleServiceImpl.getById(error);
		user.setSalt(user.getUser_name());
		// 通过用户名加密
		String password = mD5Aauthentification.MD5Chains(user.getUser_name(), user.getPassword());
		user.setPassword(password);
		user.setUserrole(userrole);
		PM_UserServiceImpl.save(user);

		return "redirect:/BgItem/BgUserPermission";
	}

	// 修改用户角色
	@RequestMapping("update")
	public String update(String name, String update_date, int error) {
		Users user = PM_UserServiceImpl.getByName(name);
		UserRole userrole = PM_UserRoleServiceImpl.getById(error);
		user.setUserrole(userrole);
		user.setUpdate_date(update_date);
		PM_UserServiceImpl.save(user);
		return "redirect:/BgItem/BgUserPermission";
	}

	// 删除用户
	@RequestMapping("del")
	public String del(int delid, String delname) {
		System.out.println(delid);
		System.out.println(delname+"*******");
//		UserRole userRole = PM_UserRoleServiceImpl.getById(delid);
		Users user = PM_UserServiceImpl.getByName(delname);
//		user.setUserrole(userRole);
		PM_UserServiceImpl.delete(user);
		return "redirect:/BgItem/BgUserPermission";
	}

	// 查询是否有该用户
	@ResponseBody
	@RequestMapping("boo")
	public String boo(String user_name) {
		System.out.println(user_name + "name");
		boolean boo = PM_UserRolesResources.getByName(user_name);
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

	// 查询手机号是否已经注册
	@ResponseBody
	@RequestMapping("booPhone")
	public String booPhone(String mobile_Phone) {
		System.out.println(mobile_Phone + "mobile_Phone");
		boolean boo = validateImpl.getByPhone(mobile_Phone);
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
