package com.cornucopia.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberDepositRecord;
import com.cornucopia.bean.MemberProfitRecord;
import com.cornucopia.bean.MemberTradeRecord;
import com.cornucopia.bean.Member_tally;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.service.AG_ProductService;
import com.cornucopia.service.ValidateService;

@Controller
@RequestMapping("AG_UserPlay")
public class AG_UserPlay {
	// 用户购买操作类
	@Resource
	private com.cornucopia.service.AG_UserPlayService AG_UserPlayServiceImpl;
	// 杂查询类
	@Resource
	private ValidateService validateImpl;
	// 产品炒作类
	@Resource
	private AG_ProductService AG_ProductServiceImpl;

	@RequestMapping("GoPlay")
	public String BgMain(MemberTradeRecord memberTradeRecord, Member_tally member_tally,
			SubjectPurchaseRecord subjectPurchaseRecord, MemberAccount memberAccount,
			MemberProfitRecord memberProfitRecord, String memberName, int amount, Model model, int subject_id) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		int hour=cal.get(Calendar.HOUR);//小时
	    int minute=cal.get(Calendar.MINUTE);//分           
	    int second=cal.get(Calendar.SECOND);//秒 
	    //用来使用流水号
	    String no=""+year+month+day+hour+minute+second;
		// subjectType标的类别壮壮写完后添加现在是补充
		// fund_flow 交易类型 这里是 流入
		// trade_status 默认 0 失败
		Member member = validateImpl.member(memberName);
		// 根据id查询标的信息
		Subject subject = AG_ProductServiceImpl.getBySubjectId(subject_id);
		// 标的已投金额加购买金额
		subject.setAmount(subject.getAmount() + amount);
		// 标的已购人数+1
		subject.setBought(subject.getBought() + 1);
		// 交易记录表添加标题
		memberTradeRecord.setTrade_name("购买:" + subject.getName());
		memberTradeRecord.setTrade_no(no.trim());
		// 交易记录表添加交易流入
		memberTradeRecord.setFund_flow(1);
		// 交易记录表添加交易状态
		memberTradeRecord.setTrade_status(0);
		// 交易记录表添加member对象
		memberTradeRecord.setMember(member);
		// 记账表消费类型暂时放0 以后天际
		member_tally.setType_id(0);
		// 记账表类别
		member_tally.setType_name(memberTradeRecord.getTrade_type());
		// 记账表金额
		member_tally.setAmount(memberTradeRecord.getAmount());
		// 记账表时间
		member_tally.setCreate_date(memberTradeRecord.getCreate_date());
		// 记账表支付时间
		member_tally.setPay_date(memberTradeRecord.getCreate_date());
		// 记账表添加member对象
		member_tally.setMember(member);
		// 标的购买表金额
		subjectPurchaseRecord.setAmount(memberTradeRecord.getAmount());
		// 标的购买表IP
		subjectPurchaseRecord.setDeal_id(memberTradeRecord.getCreate_date());
		// 标的购买表流水号
		subjectPurchaseRecord.setSerial_number(memberTradeRecord.getCreate_date());
		// 表的购买表添加subject对象
		subjectPurchaseRecord.setSubject(subject);
		// 标的购买表添加member对象
		subjectPurchaseRecord.setMember(member);
		// 标的购买表是否删除 不能删除用户使用假删除所用到的字段
		subjectPurchaseRecord.setDelflag(0);
		// 标的购买表添加时间
		subjectPurchaseRecord.setCreate_date(memberTradeRecord.getCreate_date());
		// 标的购买表修改时间
		subjectPurchaseRecord.setUpdate_date(memberTradeRecord.getCreate_date());
		// 标的购买表添加利息 这个会动态改变
		subjectPurchaseRecord.setInterset(0);
		// 标的购买表是否还款
		subjectPurchaseRecord.setIspayment(0);
		// 表的购买表次数 判断这个人是否买了这个标
		List<SubjectPurchaseRecord> sRecord = AG_ProductServiceImpl.getBySubjectPurchaseRecordId(subject_id,
				member.getId());
		// 最后计息日
		subjectPurchaseRecord.setLast_profit_day(20160324);
		// 查询这个用户MemberAccount表
		MemberAccount MAccount = AG_ProductServiceImpl.UpdateMemberAccount(member.getId());
		// 修改这个用户MemberAccount的可用金额
		MAccount.setMember(member);
		MAccount.setUseable_balance(MAccount.getUseable_balance() - amount);
		MAccount.setUpdate_date(memberTradeRecord.getCreate_date());
		// 保存MemberAccount表数据
		AG_ProductServiceImpl.saveMemberAccount(MAccount);
		// 添加用户利润表流水号
		memberProfitRecord.setSerial_number(memberTradeRecord.getCreate_date());
		// 添加用户利润表类型(注意这个写的时候没用上，数据库是空置)
		memberProfitRecord.setType(1);
		// 添加用户利润表创建时间
		memberProfitRecord.setCreate_date(memberTradeRecord.getCreate_date());
		// 添加用户利润表修改时间
		memberProfitRecord.setUpdate_date(memberTradeRecord.getCreate_date());
		// 添加用户利润表备注
		memberProfitRecord.setComment(subject.getName() + "收益");
		// 添加用户利润表计息年
		memberProfitRecord.setProfit_year(year);
		// 添加用户利润表计息月
		memberProfitRecord.setProfit_month(month);
		// 添加用户利润表计息日
		memberProfitRecord.setProfit_day(day);
		// 注入subject对象
		memberProfitRecord.setSubject(subject);
		memberProfitRecord.setMember(member);
		int count = 0;
		if (sRecord.size() > 1) {
			for (SubjectPurchaseRecord subjectPurchaseRecord2 : sRecord) {
				count = subjectPurchaseRecord2.getPay_interest_times();
				subjectPurchaseRecord.setPay_interest_times(count + 1);
			}
			// 如果这个集合大于0 就去根据用户名和标的id去修改所有次数+1
			AG_ProductServiceImpl.UpdateSubjectPurchaseRecord(member.getId(), subject_id, count);
		} else {
			// 如果这个用户没有购买这个标，就让他加1
			subjectPurchaseRecord.setPay_interest_times(1);
		}
		// 往数据库里添加交易记录表memberTradeRecord
		AG_ProductServiceImpl.saveMemberTradeRecord(memberTradeRecord);
		// 往数据库里添加记账表member_tally
		AG_ProductServiceImpl.saveMembertally(member_tally);
		// 往数据库里添加标的购买表subjectPurchaseRecord
		AG_ProductServiceImpl.saveSubjectPurchaseRecord(subjectPurchaseRecord);
		// 保存subject
		AG_ProductServiceImpl.saveSubject(subject);
		// 保存memberProfitRecord对象
		AG_ProductServiceImpl.saveMemberProfitRecord(memberProfitRecord);

		return "Login";
	}
	@RequestMapping("AlipayTradePagePay")
	public String AlipayTradePagePay(MemberTradeRecord memberTradeRecord,
	MemberDepositRecord memberDepositRecord,String name, String WIDout_trade_no, String WIDsubject, int WIDtotal_amount,
			String WIDbody, String date) {
		// WIDout_trade_no订单标号
		// WIDsubject
		// WIDtotal_amount订单金额
		// WIDbody商品描述
		// date系统时间
		// 获取用户表
		Member member = validateImpl.member(name);
		// 添加充值流水表
		memberDepositRecord.setAmount(WIDtotal_amount);
		// 添加创建日期
		memberDepositRecord.setCreate_date(date);
		// 添加修改日期
		memberDepositRecord.setUpdate_date(date);
		// 交易是否可用
		memberDepositRecord.setDelFlag(0);
		// 添加充值方
		memberDepositRecord.setPay_channel_name("支付宝充值");
		// 添加充值方订单号
		memberDepositRecord.setPay_channel_order_no(WIDout_trade_no);
		// 添加流水号
		memberDepositRecord.setSerial_number(WIDout_trade_no);
		// 添加充值状态
		memberDepositRecord.setStatus(0);
		// memberTradeRecord
		memberTradeRecord.setAmount(WIDtotal_amount);
		memberTradeRecord.setCounterpart("梵雅金融");
		memberTradeRecord.setCreate_date(date);
		memberTradeRecord.setFund_flow(1);
		memberTradeRecord.setTrade_name("支付宝充值" + WIDtotal_amount + "元");
		memberTradeRecord.setTrade_no(WIDout_trade_no);
		// 状态写0了 注意这里
		memberTradeRecord.setTrade_status(0);
		memberTradeRecord.setTrade_type("支付宝充值");
		memberTradeRecord.setUpdate_date(date);
		memberTradeRecord.setMember(member);
		// 保存member对象
		memberDepositRecord.setMember(member);
		// 充值表添加信息
		AG_ProductServiceImpl.saveAlipayTradePagePay(memberDepositRecord);
		AG_ProductServiceImpl.saveMemberTradeRecord(memberTradeRecord);
		return "alipay.trade.page.pay";
	}
}
