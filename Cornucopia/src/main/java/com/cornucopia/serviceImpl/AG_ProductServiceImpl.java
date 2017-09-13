package com.cornucopia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.Subject;
import com.cornucopia.dao.AG_ProductDao;
import com.cornucopia.service.AG_ProductService;

//产品操作类

@Component
public class AG_ProductServiceImpl implements AG_ProductService{
	
	
	@Autowired
	private AG_ProductDao ag_ProductDao;//产品操作类
	
	//根据id查询subject产品信息
	@Override
	public  Subject getById(int id) {
		Subject subject=ag_ProductDao.GetSubject(id);
		return subject;
	}

}
