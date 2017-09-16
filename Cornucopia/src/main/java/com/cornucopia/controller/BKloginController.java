package com.cornucopia.controller;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.cornucopia.service.PM_UserService;
import com.passwordauthentification.MD5Aauthentification;


@Controller
@RequestMapping("BgLogin")
public class BKloginController {
	 //shiro验证类
	@Resource
	private PM_UserService PM_UserRoleServiceImpl;
	
	@Resource
	private PM_UserService PM_UserServiceImpl;
	
	MD5Aauthentification mD5Aauthentification=new MD5Aauthentification();
	
	
	@RequestMapping("/toMain")
	public String toMain(Users user,HttpServletRequest request,Model model,HttpSession session1){
		String msg="";
		String name=user.getUser_name();
		String password=user.getPassword();
		System.out.println(name+"---------"+password);
		if(name==null||password==null||name==""||password==""){
			 msg = "用户名与密码不能为空";  
		        model.addAttribute("message", msg);  
			return "BgLogin";
		}else{
			Subject subject=SecurityUtils.getSubject();
			password=mD5Aauthentification.MD5Chains(name,password);
			UsernamePasswordToken token=new UsernamePasswordToken(name,password);
			try {
				subject.login(token);
				Session session=subject.getSession();
				session.setAttribute("user_name", user.getUser_name());
				System.out.println(user.getUser_name()+"mingz");
				Set<String> set=PM_UserRoleServiceImpl.ListAllByName(name);
				
				String url=null;
				for (String string : set) {
					url=string;
					session1.setAttribute("url", url);
					if(url!=null){
						break;
					}
				}
				if(url!=null){
					 return "BgMain";
				}
			} catch (IncorrectCredentialsException e) {  
		        msg = "登录密码错误" + token.getPrincipal() + "登陆失败";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (ExcessiveAttemptsException e) {  
		        msg = "登录失败次数过多";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (LockedAccountException e) {  
		        msg = "帐号已被锁定" + token.getPrincipal() + " 登陆失败";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (DisabledAccountException e) {  
		        msg = "帐号已被禁用" + token.getPrincipal() + "登陆失败";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (ExpiredCredentialsException e) {  
		        msg = "帐号已过期" + token.getPrincipal() + "登陆失败";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (UnknownAccountException e) {  
		        msg = "帐号不存在" + token.getPrincipal();  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (UnauthorizedException e) {  
		        msg = "您没有得到相应的授权！" + e.getMessage();  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    }  
			return "BgLogin";
		}
	}
}
		
	

