package com.cornucopia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.Subject;

@Component
public class AG_ProductDao {
	// 产品操作类
	@Autowired
	public SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	// 根据ID查询产品信息 产品信息表操作
	public FinanceProductFunds GetFinanceProductFundsId(int id) {
		Session session = getsession();
		FinanceProductFunds FinanceProductFunds = (FinanceProductFunds) session.get(FinanceProductFunds.class, id);
		return FinanceProductFunds;
	}
	
	// 根据ID查询产品信息 产品信息表操作
		public Subject GetSubject(int id) {
			Session session = getsession();
			Subject subject = (Subject) session.get(Subject.class, id);
			return subject;
		}

}
