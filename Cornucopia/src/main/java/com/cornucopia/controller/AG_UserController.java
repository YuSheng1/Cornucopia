package com.cornucopia.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.Subject;
import com.cornucopia.service.AG_ProductService;
import com.cornucopia.service.ValidateService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/item")
public class AG_UserController {
	//产品炒作类
	@Resource
	private AG_ProductService AG_ProductServiceImpl;
	//杂查询类
	@Resource
	private ValidateService validateImpl;

	// 主页
	@RequestMapping("Index")
	public String Index() {
		return "Index";
	}

	// 购买产品
	@RequestMapping("/Purchased")
	public String Purchased(int id, Model model,int mid) {
		System.out.println(id+"---"+mid);
		id=1628;
		MemberAccount memberAccount=validateImpl.MemberAccount(mid);
		Subject subject = AG_ProductServiceImpl.getById(id);
		model.addAttribute("memberAccount", memberAccount);
		model.addAttribute("subject", subject);
		return "Purchased";
	}

	// 关于我们
	@RequestMapping("about")
	public String about() {
		return "About";
	}

	@RequestMapping("Contact")
	public String Contact() {
		return "Contact";
	}

	@RequestMapping("Example")
	public String Example() {
		return "Example";
	}

	@RequestMapping("Join")
	public String Join() {
		return "Join";
	}

	@RequestMapping("NewsC")
	public String NewsC() {
		return "News-Content";
	}

	@RequestMapping("News")
	public String News() {
		return "News";
	}

	@RequestMapping("Login")
	public String Login() {
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("Lname", null);
		return "Login";
	}

	@RequestMapping("Product1")
	public String Product1() {
		return "Product1";
	}

	@RequestMapping("Product2")
	public String Product2() {
		return "Product2";
	}

	@RequestMapping("Product3")
	public String Product3() {
		return "Product3";
	}

	@RequestMapping("Solution")
	public String Solution() {
		return "Solution";
	}

	@RequestMapping("About")
	public String About() {
		return "About";
	}

	// 注册
	@RequestMapping("Register")
	public String Register() {
		return "Register";
	}
}
