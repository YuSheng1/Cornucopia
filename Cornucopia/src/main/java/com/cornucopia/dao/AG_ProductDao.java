package com.cornucopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.Resources;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.bean.Users;

@Component
public class AG_ProductDao {
	// 产品操作类
	@Autowired
	public SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	// 根据ID查询基金类产品信息 产品信息表操作
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

	// 根据ID查询产品购买表操作
	public List<SubjectPurchaseRecord> GetSubjectPurchaseRecord(Object... objects) {
		Session session = getsession();
		String sql = " from SubjectPurchaseRecord p where p.subject.id=" + objects[0] + " and p.member.id="
				+ objects[1];
		List list = session.createQuery(sql).list();
		if(list.size()>0){
			return list;
		}
	return null;
	}

	// 根据id查询成员利润表(暂时用不上，所以查询字段没改，是错的)
//	public List GetMemberProfitRecord(Object... objects) {
//		String sql = "select * from Subject_purchase_record where subject_id=" + objects[0] + " and member_id="
//				+ objects[1];
//		List list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
//		return list;
//	}

	// 根据ID修改产品购买表操作
	public void UpdateSubjectPurchaseRecord(Object... objects) {
		Session session = getsession();
		System.out.println("秀高了");
		String sql = "update subject_purchase_record set pay_interest_times="+ objects[2]+ " where member_id="
				+ objects[0] + "  and subject_id=" + objects[1];
		          session.createSQLQuery(sql);
	}

	// 根据ID查询成员账户表操作
	public MemberAccount GetMemberAccount(Object... objects) {
		Session session = getsession();
		String sql = " from MemberAccount u where u.member.id=" + objects[0];
		List<MemberAccount> list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 向交易记录表添加数据
	public void saveMemberTradeRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);

	}

	// 往及账表添加数据
	public void saveMembertally(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// 修改成员表金额
	public void saveMemberAccount(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// 修改标数据
	public void saveSubject(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// 往购买标的标添加数据
	public void saveSubjectPurchaseRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// 往购买标的标添加数据
	public void saveMemberProfitRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

}
