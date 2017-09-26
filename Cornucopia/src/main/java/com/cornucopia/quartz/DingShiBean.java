package com.cornucopia.quartz;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;


import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.service.AG_ProductService;
import com.cornucopia.service.ValidateService;

public class DingShiBean {
	//杂查询类
		@Resource
		private ValidateService validateImpl;
		
		@Resource
		private AG_ProductService AG_ProductServiceImpl;
	
	private static Logger logger = Logger.getLogger(DingShiBean.class.getName());
	public void execute() {
		System.out.println("进来了");
		List<SubjectPurchaseRecord> list=validateImpl.SubjectPurchaseRecordListAll();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		for(int i=0;i<list.size();i++){
			 int res =list.get(i).getLast_profit_day().compareTo(date);
			 if(res>0||list.get(i).getIspayment()==1)
			    {
			     System.out.println("时间未到");
			    }else{
			    	MemberAccount memberAccount=AG_ProductServiceImpl.UpdateMemberAccount(list.get(i).getMember().getId());
			    	int money=(int)list.get(i).getInterset();
			    	System.out.println(money+"金额");
			    	memberAccount.setUseable_balance(memberAccount.getUseable_balance()+money+list.get(i).getAmount());
			    	//金额
			    	memberAccount.setTotal_profit(memberAccount.getTotal_profit()+money);
			    	list.get(i).setUpdate_date(date);
			    	//累计收益
			    	memberAccount.setInvest_amount(memberAccount.getInvest_amount()-list.get(i).getAmount());
			    	AG_ProductServiceImpl.saveMemberAccount(memberAccount);
			    	list.get(i).setIspayment(1);
			    	AG_ProductServiceImpl.updateSubjectPurchaseRecord(list.get(i));
			    }
		}
		System.out.println("这是第一个定时任务：" + date);
		logger.info("任务1：每分钟定时获取当前系统时间");
		
	}

	public void auto() {
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); // 椎内存使用情况
		long totalMemorySize = memoryUsage.getInit(); // 初始的总内存
		long maxMemorySize = memoryUsage.getMax(); // 最大可用内存
		long usedMemorySize = memoryUsage.getUsed(); // 已使用的内存
		System.out.println("这是第二个定时任务" + "\r" + "椎内存使用情况：" + "1.初始的总内存:" + totalMemorySize + "2.最大可用内存:" + maxMemorySize
				+ "3.已使用的内存:" + usedMemorySize);
		logger.info("任务2：后台监控椎内存使用情况");
	}
}
