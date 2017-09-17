package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;
import com.cornucopia.bean.SysRegion;
import com.cornucopia.service.AG_ProductService;
import com.cornucopia.service.ValidateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passwordauthentification.MD5Aauthentification;

@Controller
@RequestMapping("AgUserItem")
public class AG_UserOperation {
	// 用户购买操作类
	@Resource
	private com.cornucopia.service.AG_UserPlayService AG_UserPlayServiceImpl;
	@Resource
	private ValidateService validateImpl;
	// 产品炒作类
	@Resource
	private AG_ProductService AG_ProductServiceImpl;

	MD5Aauthentification mD5Aauthentification = new MD5Aauthentification();

	
	@RequestMapping("/toBank")
	public String toBank(HttpSession session,MemberBankcards memberBankcards,String datebank,String error,String error1,String error2) {
		Member member=(Member) session.getAttribute("member");
		memberBankcards.setCreate_date(datebank);
		memberBankcards.setUpdate_date(datebank);
		memberBankcards.setMember(member);
		memberBankcards.setDelflag(0);
		memberBankcards.setType("银联");
		memberBankcards.setCardaddress(error+error1+error2);
		AG_ProductServiceImpl.saveMemberBankcards(memberBankcards);
	return "redirect:/item/Contact";
	}
	
	
	// 前台用户操作
	@RequestMapping("/toMain")
	public String toMain(HttpServletRequest request, Model model, String Lname, String Lpassworld) {
		String msg = "用户名密码错误";
		String name = Lname;
		String password = Lpassworld;
		System.out.println(name + "----" + password);
		 password=mD5Aauthentification.MD5Chains(name,password);
		boolean boo = validateImpl.UserLogin(name, password);
		System.out.println(boo);
		if (boo == true) {
			Subject subject = SecurityUtils.getSubject();
			Member member = validateImpl.member(Lname);
			Session session = subject.getSession();
			session.setAttribute("Lname", Lname);
			session.setAttribute("member", member);
			return "redirect:/item/Index";
		} else {
			model.addAttribute("message", msg);
			return "Login";
		}
	}

	@RequestMapping("/toRegister")
	public String register(Member member, MemberAccount memberAccount) {
		member.setStatus(0);
		member.setDel_flag(0);
		member.setPassword(mD5Aauthentification.MD5Chains(member.getName(),member.getPassword()));
		AG_UserPlayServiceImpl.savemember(member);
		Member memberUser = validateImpl.member(member.getName());
		memberAccount.setBbin_amount(8888);
		memberAccount.setBonus_amount(0);
		memberAccount.setCreate_date(member.getCreate_date());
		memberAccount.setDelflag(0);
		memberAccount.setImuseale_balance(0);
		memberAccount.setInvest_amount(0);
		memberAccount.setTotal_profit(0);
		memberAccount.setUpdate_date(member.getCreate_date());
		memberAccount.setUseable_balance(0);
		memberAccount.setMember(memberUser);
		// 保存MemberAccount表数据
		AG_ProductServiceImpl.savesMemberAccount(memberAccount);
		return "Login";
	}

	// 查询是否有该角色
	@ResponseBody
	@RequestMapping("nc")
	public String nc(String name) {
		System.out.println(name + "name");
		boolean boo = validateImpl.Usernc(name);
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

	// 查询是否有该角色
	@ResponseBody
	@RequestMapping("phone")
	public String phone(String mobile_Phone) {
		System.out.println(mobile_Phone + "name");
		boolean boo = validateImpl.Usersjh(mobile_Phone);
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
	// 查询是否有该角色
	@ResponseBody
	@RequestMapping("queryInfo")
	public List<SysRegion> queryInfo(int id) {
		System.out.println(id);
		List<SysRegion>  sysregion=AG_ProductServiceImpl.saveGetregion1(id);
		return sysregion;
}
}
