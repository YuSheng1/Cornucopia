package com.cornucopia.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.Resources;
import com.cornucopia.bean.UserRole;
import com.cornucopia.service.UserService;

@Controller
@RequestMapping("BgItem")
public class BKjumpController {

	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private UserService userRoleServiceImpl;
	
	@Resource
	private UserService userRolesResources;
	
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
	

	// 后台用户权限管理
	@RequestMapping("BgUserPermission")
	public String BgUserPermission(Model model) {
		List<UserRole> UserRoleList=userRoleServiceImpl.ListAll();
		List UsersList=userServiceImpl.ListAll();
		model.addAttribute("UsersList",UsersList);
		model.addAttribute("UserRole",UserRoleList);
		return "BgUserPermission";
	}
	// 后台查询角色
	//
	@RequestMapping("BgUserRoles")
	public String BgUserRoles(Model model) {
		List<UserRole> UserRoleList=userRoleServiceImpl.ListAll();
		model.addAttribute("UserRoleList",UserRoleList);
		return "BgUserRoles";
	}
	
	// 后台用户权限管理
	@ResponseBody
		@RequestMapping("Ztree")
		public String Ztree(Model model,int id) {
		System.out.println("初始化");
			 List<Resources> list=userRolesResources.ListAll(); 
			List<Integer> bool=userRoleServiceImpl.ListAlltrue(id);
		        StringBuffer json=new StringBuffer("[");  
		        String data="";  
		        for (int i = 0; i < list.size(); i++) {  
		            json.append("{id:"+list.get(i).getResources_id()+",");  
		            json.append("pId:"+list.get(i).getResources_higher()+",");  
		            json.append("name:\""+list.get(i).getResources_name()+"\",");  
		            if (list.get(i).getIsParent() !=0) {  
		                json.append("isParent:"+list.get(i).getIsParent()+",");  
		            }  
		            for (int y = 0; y < bool.size(); y++) {  
		            if (list.get(i).getResources_id() ==bool.get(y)) {  
		            	
		            	System.out.println(bool.get(y));
		            	//默认勾选
		                json.append("checked:true,");  
		                //勾选后默认打开
		                json.append("open:"+list.get(i).getResources_id()+",");  
		            }  
		            }
		            if (list.get(i).getChkDisabled()==1) { 
		            	 json.append("checked:true,");  
		                json.append("chkDisabled:true,");  
		            }  
		            data=json.substring(0,json.lastIndexOf(","))+"},";  
		            json=new StringBuffer(data);  
		        }  
		        data=json.substring(0, json.length()-1)+"]";  
		        System.out.println(data);  
		        return data;  
		}
	
}
	