package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.dao.AG_ProductDao;
import com.cornucopia.service.AG_ProductService;

//产品操作类

@Component
public class AG_ProductServiceImpl implements AG_ProductService {

	@Autowired
	private AG_ProductDao ag_ProductDao;// 产品操作类

	// 根据id查询subject产品信息
	@Override
	public Subject getBySubjectId(int id) {
		Subject subject = ag_ProductDao.GetSubject(id);
		return subject;
	}

	// 根据id查询SubjectPurchaseRecord产品记录信息
	@Override
	public List<SubjectPurchaseRecord> getBySubjectPurchaseRecordId(Object... object) {
		List<SubjectPurchaseRecord> subjectPurchaseRecord = ag_ProductDao.GetSubjectPurchaseRecord(object);
		return subjectPurchaseRecord;
	}

	// 根据memberid和subjectid修改SubjectPurchaseRecord产品记录信息
	@Override
	public void UpdateSubjectPurchaseRecord(Object... object) {
		ag_ProductDao.UpdateSubjectPurchaseRecord(object);
	}

	// 根据ID查询成员账户表操作
	public MemberAccount UpdateMemberAccount(Object... objects) {
		MemberAccount memberAccount=ag_ProductDao.GetMemberAccount(objects);
		return memberAccount;
	}
	
	// 向交易记录表添加数据
	@Override
	public void saveMemberTradeRecord(Object... object) {
		ag_ProductDao.saveMemberTradeRecord(object);

	}

	// 往及账表添加数据
		@Override
		public void saveMembertally(Object... object) {
			ag_ProductDao.saveMembertally(object);

		}
		

	// 往购买标的标添加数据
	@Override
	public void saveSubjectPurchaseRecord(Object... object) {
		ag_ProductDao.saveSubjectPurchaseRecord(object);

	}
	@Override
	public void saveAlipayTradePagePay(Object... object) {
		ag_ProductDao.saveSubjectPurchaseRecord(object);

	}
	@Override
	public void updateAlipayTradePagePay(Object... object) {
		ag_ProductDao.updateAlipayTradePagePay(object);

	}
	
	@Override
	public void saveMemberAccount(Object... object) {
		ag_ProductDao.saveMemberAccount(object);
		
	}
	

	@Override
	public void saveMemberProfitRecord(Object... object) {
	    ag_ProductDao.saveMemberProfitRecord(object);
	}

	@Override
	public void saveSubject(Object... object) {
		ag_ProductDao.saveSubject(object);
	}

}
