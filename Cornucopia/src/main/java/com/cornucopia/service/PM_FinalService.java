package com.cornucopia.service;

import java.util.List;

import java.util.Map;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.FinanceProductSubscribe;

public interface PM_FinalService {
	
	    public <T> List<T> FundList(FinanceProductFunds financeProductFunds);
	    
	    //������ѯ
	    public List proList(Map map);
		//���˽ļ
		public void save(FinanceProductFunds financeProductFunds);
		//˽ļ��Ʒid
		public <T> FinanceProductFunds getByIdFun(int id);

		//��ƷԤԼ��¼��id
		public <T> FinanceProductSubscribe getByIdSub(int id);
		
		//�޸Ĳ�Ʒ
		public void update(FinanceProductFunds financeProductFunds) ;
		
		public void updateFps(FinanceProductSubscribe financeProductSubscribe);

		
		//�޸ĸ���ǩ��
		public void personUpdate(FinanceProductSubscribe financeProductSubscribe);
		
		
	    public List personList(int  id);
	    
 	    //����ID��ѯ
		public List listAll(int id);

		


}
