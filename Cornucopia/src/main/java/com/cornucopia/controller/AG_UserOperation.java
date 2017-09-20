package com.cornucopia.controller;

import java.util.Calendar;
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
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.AwardRecords;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;
import com.cornucopia.bean.MemberTradeRecord;
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
	public String toBank(HttpSession session,MemberBankcards memberBankcards,String datebank,String dz1,String dz2,String dz3) {
		Member member=(Member) session.getAttribute("member");
		memberBankcards.setCreate_date(datebank);
		memberBankcards.setUpdate_date(datebank);
		memberBankcards.setMember(member);
		memberBankcards.setDelflag(0);
		System.out.println(dz1+"-"+dz2+"-"+dz3);
		memberBankcards.setCardaddress(dz1+"-"+dz2+"-"+dz3+"-"+memberBankcards.getType());
		AG_ProductServiceImpl.saveMemberBankcards(memberBankcards);
		 session.setAttribute("member", member);
	return "redirect:/item/Contact";
	}
	//修改角色额密码
	
	@RequestMapping("/updatepass")
	public String updatepass(HttpSession session,String repassword,String update_date) {
		Member member=(Member) session.getAttribute("member");
		repassword=mD5Aauthentification.MD5Chains(member.getName(),repassword);
		 System.out.println(repassword);
	     member.setPassword(repassword);
	     member.setUpdate_date(update_date);
	     AG_UserPlayServiceImpl.savemember(member);
	     session.setAttribute("member", member);
	return "redirect:/item/Login";
	}
	
	@RequestMapping("/updawd")
	public String updawd(HttpSession session,String withdraw_password1,String update_date) {
		Member member=(Member) session.getAttribute("member");
		withdraw_password1=mD5Aauthentification.MD5Chains(member.getName(),withdraw_password1);
	     member.setWithdraw_password(withdraw_password1);
	     member.setUpdate_date(update_date);
	     AG_UserPlayServiceImpl.savemember(member);
	     session.setAttribute("member", member);
	return "redirect:/item/Contact";
	}
	
	// 前台用户操作
	@RequestMapping("/toMain")
	public String toMain(HttpServletRequest request, Model model, String Lname, String Lpassworld,HttpSession session) {
	
		String msg = "用户名密码错误";
		String name = Lname;
		String password = Lpassworld;
		System.out.println(name + "----" + password);
		 password=mD5Aauthentification.MD5Chains(name,password);
		boolean boo = validateImpl.UserLogin(name, password);
		System.out.println(boo);
		if (boo == true) {
			Member member = validateImpl.member(Lname);
			session.setAttribute("Lname", Lname);
			session.setAttribute("member", member);
			if(session.getAttribute("subid")==null){
				return "redirect:/item/Index";
			}else{
				int subid=Integer.parseInt(session.getAttribute("subid").toString());
				return "redirect:/item/Purchased?id="+subid;
			}
		} else {
			model.addAttribute("message", msg);
			return "Login";
		}
	}

	@RequestMapping("/toRegister")
	public String register(Member member,AwardRecords awardRecords, MemberAccount memberAccount) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		int hour=cal.get(Calendar.HOUR);//小时
	    int minute=cal.get(Calendar.MINUTE);//分           
	    int second=cal.get(Calendar.SECOND);//秒 
	    //用来使用流水号
	    String no=""+year+month+day+hour+minute+second;
		member.setStatus(0);
		member.setDel_flag(0);
		member.setPassword(mD5Aauthentification.MD5Chains(member.getName(),member.getPassword()));
		member.setInvitationCode(member.getMobile_Phone());
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
		if(member.getInvitedCode()!=null&&member.getInvitedCode()!=""&&member.getInvitedCode().length()>0){
			//被奖励人
			System.out.println("我进来了");
			Member memberyq = validateImpl.Useryqjl(member.getInvitedCode());
			MemberAccount MAccount = AG_ProductServiceImpl.UpdateMemberAccount(memberyq.getId());
			MAccount.setUseable_balance(MAccount.getUseable_balance()+50);
			MAccount.setMember(memberyq);
			MAccount.setUpdate_date(member.getCreate_date());
			awardRecords.setAddTime(member.getCreate_date());
			awardRecords.setAmount(50);
			awardRecords.setByinvitingid(memberUser.getId());
			awardRecords.setInvitingid(memberyq.getId());
			awardRecords.setType(0);
			awardRecords.setIsAward(1);
			AG_ProductServiceImpl.saveMemberAccount(MAccount);
			AG_ProductServiceImpl.saveAwardRecords(awardRecords);
			save(member,MAccount,memberyq,no);
		}
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
		@RequestMapping("sfid")
		public String sfid(String identity) {
			System.out.println(identity + "name");
			boolean boo = validateImpl.Usersfid(identity);
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
		@RequestMapping("getMemberBK")
		public String getMemberBK(String card_no) {
			System.out.println(card_no + "name");
			boolean boo = validateImpl.getMemberBankcardsKa(card_no);
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
	// 查询是否有该邀请码
		@ResponseBody
		@RequestMapping("zhuce")
		public String zhuce(String invitedCode) {
			System.out.println(invitedCode + "name");
			boolean boo = validateImpl.Usersyz(invitedCode);
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
	public void save(Member member,MemberAccount MAccount,Member memberyq,String no){
		MemberTradeRecord memberTradeRecordMember=new MemberTradeRecord();
			memberTradeRecordMember.setTrade_name("来自"+member.getMember_name()+"的注册奖励:50 元");
			memberTradeRecordMember.setTrade_no(no.trim()+MAccount.getId());
			memberTradeRecordMember.setCounterpart(member.getMember_name());
			memberTradeRecordMember.setAmount(50);
			memberTradeRecordMember.setTrade_type("注册奖励");
			// 交易记录表添加交易流入
			memberTradeRecordMember.setFund_flow(1);
			// 交易记录表添加交易状态
			memberTradeRecordMember.setTrade_status(1);
			memberTradeRecordMember.setCreate_date(member.getCreate_date());
			memberTradeRecordMember.setUpdate_date(member.getCreate_date());
			// 交易记录表添加member对象
			memberTradeRecordMember.setMember(memberyq);
			AG_ProductServiceImpl.save1MemberTradeRecord(memberTradeRecordMember);
	  }
}
