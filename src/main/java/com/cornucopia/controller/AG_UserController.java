package com.cornucopia.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.MembeWithdrawRecord;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;
import com.cornucopia.bean.MemberDepositRecord;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.bean.SysRegion;
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
	public String Purchased(int id, Model model,HttpSession session) {
		Member member=(Member) session.getAttribute("member");
		System.out.println(id+"---"+member.getId());
		//现在是死值
		//根据登陆人id查询可用金额
		MemberAccount memberAccount=validateImpl.MemberAccount(member.getId());
		//根据登录人id查询是否绑定银行卡
		List<MemberBankcards> memberBankcards=validateImpl.MemberBankcards(member.getId());
		Subject subject = AG_ProductServiceImpl.getBySubjectId(id);
		model.addAttribute("memberBankcards", memberBankcards);
		model.addAttribute("memberAccount", memberAccount);
		session.setAttribute("subject", subject);
		return "Purchased";
	}

	// 关于我们
	@RequestMapping("about")
	public String about() {
		return "About";
	}

	@RequestMapping("Contact")
	public String Contact(HttpSession session,Model model) {
		Member member=(Member)session.getAttribute("member");
		if(member==null){
			return "redirect:/item/Login";
		}else{
			//查询用户基本信息
			MemberAccount MAccount=AG_ProductServiceImpl.UpdateMemberAccount(member.getId());
			List<SubjectPurchaseRecord> subjectPurchaseRecorList=AG_ProductServiceImpl.GetSubjectPurchaseRecordByid(member.getId());	
			List<MemberDepositRecord>  memberDepositRecord= AG_ProductServiceImpl.GetMemberDepositRecordByid(member.getId());
			List<MembeWithdrawRecord> membeWithdrawRecord=AG_ProductServiceImpl.GetMembeWithdrawRecordByid(member.getId());
			MemberBankcards  memberBankcards=AG_ProductServiceImpl.GetMemberBankcardsByid(member.getId());
			//查询省市级联
			List<SysRegion>  sysregion=AG_ProductServiceImpl.saveGetregion();
			model.addAttribute("sysregion", sysregion);
			model.addAttribute("MAccount", MAccount);
			model.addAttribute("memberBankcards", memberBankcards);
		    model.addAttribute("subjectPurchaseRecor", subjectPurchaseRecorList);
		    model.addAttribute("membeWithdrawRecord", membeWithdrawRecord);
		    model.addAttribute("memberDepositRecord", memberDepositRecord);
		}
		return "Contact";
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
		session.setAttribute("member", null);
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
