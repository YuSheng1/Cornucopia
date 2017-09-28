package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.FinanceProductSubscribe;
import com.cornucopia.dao.PM_finance_product_fundsHouDao;
import com.cornucopia.service.PM_FinalService;

@Component
public class PM_FinaImpl implements PM_FinalService {
	
	@Autowired
	private PM_finance_product_fundsHouDao fundsHouDao ;

	@Override
	public <T> List<T> FundList(FinanceProductFunds financeProductFunds) {
		return this.fundsHouDao.listFun(financeProductFunds);
	}

	@Override
	public List proList(Map map) {
		// TODO Auto-generated method stub
		return this.fundsHouDao.list(map);
	}

	@Override
	public void save(FinanceProductFunds financeProductFunds) {
		this.fundsHouDao.save(financeProductFunds);
		
	}

	@Override
	public <T> FinanceProductFunds getByIdFun(int id) {
		// TODO Auto-generated method stub
		return fundsHouDao.getById(id);
	}

	@Override
	public <T> FinanceProductSubscribe getByIdSub(int id) {
		// TODO Auto-generated method stub
		return fundsHouDao.getFpsId(id);
	}

	@Override
	public void update(FinanceProductFunds financeProductFunds) {
		// TODO Auto-generated method stub
		this.fundsHouDao.update(financeProductFunds);
		
	}

	@Override
	public void updateFps(FinanceProductSubscribe financeProductSubscribe) {
		// TODO Auto-generated method stub
		this.fundsHouDao.updateFps(financeProductSubscribe);
		
	}

	@Override
	public void personUpdate(FinanceProductSubscribe financeProductSubscribe) {
		this.fundsHouDao.personUpdate(financeProductSubscribe);
		
	}

	@Override
	public List personList(int id) {
		// TODO Auto-generated method stub
		return fundsHouDao.personList(id);
	}
	
	@Override
	public List listAll(int id) {
		return fundsHouDao.listAll(id);
	}
	
}
