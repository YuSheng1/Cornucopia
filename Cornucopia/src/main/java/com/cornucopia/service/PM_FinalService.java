package com.cornucopia.service;

import java.util.List;

import java.util.Map;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.FinanceProductSubscribe;

public interface PM_FinalService {
	
	    public <T> List<T> FundList(FinanceProductFunds financeProductFunds);
	    
	    //条件查询
	    public List proList(Map map);
		//添加私募
		public void save(FinanceProductFunds financeProductFunds);
		//私募产品id
		public <T> FinanceProductFunds getByIdFun(int id);

		//产品预约记录表id
		public <T> FinanceProductSubscribe getByIdSub(int id);
		
		//修改产品
		public void update(FinanceProductFunds financeProductFunds) ;
		
		public void updateFps(FinanceProductSubscribe financeProductSubscribe);

		
		//修改个人签署
		public void personUpdate(FinanceProductSubscribe financeProductSubscribe);
		
		
	    public List personList(int  id);
	    
 	    //跟据ID查询
		public List listAll(int id);

		


}
