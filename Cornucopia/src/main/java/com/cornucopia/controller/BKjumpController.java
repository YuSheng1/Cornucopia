package com.cornucopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("BgItem")
public class BKjumpController {
	// 后台主页
	@RequestMapping("BgMain")
	public String BgMain() {
		return "BgMain";
	}
	// 后台默认主页
		@RequestMapping("BgIndex")
		public String BgIndex() {
			return "BgIndex";
		}
	// 后台左侧
	@RequestMapping("BgLeft")
	public String BgLeft() {
		return "BgLeft";
	}

	// 后台顶部
	@RequestMapping("BgTop")
	public String BgTop() {
		return "BgTop";
	}

	// 后台默认页面
	@RequestMapping("BgDefault")
	public String BgDefault() {
		return "BgDefault";
	}

	// 后台表单
	@RequestMapping("Bgform")
	public String Bgform() {
		return "Bgform";
	}

	// 后台模块编辑
	@RequestMapping("BgImgList")
	public String BgImgList() {
		return "BgImgList";
	}

	// 后台模块表单
	@RequestMapping("BgImgTable")
	public String BgImgTable() {
		return "BgImgTable";
	}
	
	// 后台模块表单
	@RequestMapping("Bgnotice")
	public String Bgnotice() {
		return "Bgnotice";
		}
	
	// 后台模块表单
	@RequestMapping("Bgfeedback")
	public String Bgfeedback() {
		return "Bgfeedback";
		}


	// 后台登陆
	@RequestMapping("BgLogin")
	public String BgLogin() {
		return "BgLogin";
	}

	// 后台右侧
	@RequestMapping("BgRight")
	public String BgRight() {
		return "BgRight";
	}

	// 后台表格
	@RequestMapping("BgTab")
	public String BgTab() {
		return "BgTab";
	}

	// 后台功能
	@RequestMapping("BgTools")
	public String BgTools() {
		return "BgTools";
	}
}