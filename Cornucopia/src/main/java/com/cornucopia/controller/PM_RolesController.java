package com.cornucopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("PM_RolesItem")
public class PM_RolesController {
	// 添加用户权限
		@RequestMapping("PM_RolesAdd")
		public String BgRight(String msg,int id) {
			System.out.println(msg);
			return "BgUserRoles";
		}
}
