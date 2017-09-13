package com.cornucopia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.Subject;

@Component
public class AG_ProductDao {
	// ��Ʒ������
	@Autowired
	public SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	// ����ID��ѯ��Ʒ��Ϣ ��Ʒ��Ϣ�����
	public FinanceProductFunds GetFinanceProductFundsId(int id) {
		Session session = getsession();
		FinanceProductFunds FinanceProductFunds = (FinanceProductFunds) session.get(FinanceProductFunds.class, id);
		return FinanceProductFunds;
	}
	
	// ����ID��ѯ��Ʒ��Ϣ ��Ʒ��Ϣ�����
		public Subject GetSubject(int id) {
			Session session = getsession();
			Subject subject = (Subject) session.get(Subject.class, id);
			return subject;
		}

}
