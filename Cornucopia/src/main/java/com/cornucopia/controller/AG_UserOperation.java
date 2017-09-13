package com.cornucopia.controller;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.Users;
import com.cornucopia.service.ValidateService;
import com.passwordauthentification.MD5Aauthentification;

@Controller
@RequestMapping("AgUserItem")
public class AG_UserOperation {
	
	@Resource
	private ValidateService validateImpl;
	
	MD5Aauthentification mD5Aauthentification=new MD5Aauthentification();
	//前台用户操作
	@RequestMapping("/toMain")
	public String toMain(HttpServletRequest request,Model model,String Lname,String Lpassworld){
		String msg="用户名密码错误";
		String name=Lname;
		String password=Lpassworld;
		System.out.println(name+"----"+password);
//			password=mD5Aauthentification.MD5Chains(name,password);
				boolean boo=validateImpl.UserLogin(name, password);
				System.out.println(boo);
				if(boo==true){
					Subject subject=SecurityUtils.getSubject();
					Session session=subject.getSession();
					session.setAttribute("Lname", Lname);
					 return "redirect:/item/Index";
				}
				else{
					  model.addAttribute("message", msg);  
						return "Login";
				}
		  
		}
}


