package com.cornucopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/AGuser")
public class AG_UsersContextController {
	
	// 主页
		@RequestMapping("AG_Left")
		public String AG_Left() {
			return "AG_Left";
		}

}
