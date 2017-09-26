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
	//�Ӳ�ѯ��
		@Resource
		private ValidateService validateImpl;
		
		@Resource
		private AG_ProductService AG_ProductServiceImpl;
	
	private static Logger logger = Logger.getLogger(DingShiBean.class.getName());
	public void execute() {
		System.out.println("������");
		List<SubjectPurchaseRecord> list=validateImpl.SubjectPurchaseRecordListAll();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		for(int i=0;i<list.size();i++){
			 int res =list.get(i).getLast_profit_day().compareTo(date);
			 if(res>0||list.get(i).getIspayment()==1)
			    {
			     System.out.println("ʱ��δ��");
			    }else{
			    	MemberAccount memberAccount=AG_ProductServiceImpl.UpdateMemberAccount(list.get(i).getMember().getId());
			    	int money=(int)list.get(i).getInterset();
			    	System.out.println(money+"���");
			    	memberAccount.setUseable_balance(memberAccount.getUseable_balance()+money+list.get(i).getAmount());
			    	//���
			    	memberAccount.setTotal_profit(memberAccount.getTotal_profit()+money);
			    	list.get(i).setUpdate_date(date);
			    	//�ۼ�����
			    	memberAccount.setInvest_amount(memberAccount.getInvest_amount()-list.get(i).getAmount());
			    	AG_ProductServiceImpl.saveMemberAccount(memberAccount);
			    	list.get(i).setIspayment(1);
			    	AG_ProductServiceImpl.updateSubjectPurchaseRecord(list.get(i));
			    }
		}
		System.out.println("���ǵ�һ����ʱ����" + date);
		logger.info("����1��ÿ���Ӷ�ʱ��ȡ��ǰϵͳʱ��");
		
	}

	public void auto() {
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); // ׵�ڴ�ʹ�����
		long totalMemorySize = memoryUsage.getInit(); // ��ʼ�����ڴ�
		long maxMemorySize = memoryUsage.getMax(); // �������ڴ�
		long usedMemorySize = memoryUsage.getUsed(); // ��ʹ�õ��ڴ�
		System.out.println("���ǵڶ�����ʱ����" + "\r" + "׵�ڴ�ʹ�������" + "1.��ʼ�����ڴ�:" + totalMemorySize + "2.�������ڴ�:" + maxMemorySize
				+ "3.��ʹ�õ��ڴ�:" + usedMemorySize);
		logger.info("����2����̨���׵�ڴ�ʹ�����");
	}
}
