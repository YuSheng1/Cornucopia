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

//��Ʒ������

@Component
public class AG_ProductServiceImpl implements AG_ProductService {

	@Autowired
	private AG_ProductDao ag_ProductDao;// ��Ʒ������

	// ����id��ѯsubject��Ʒ��Ϣ
	@Override
	public Subject getBySubjectId(int id) {
		Subject subject = ag_ProductDao.GetSubject(id);
		return subject;
	}

	// ����id��ѯSubjectPurchaseRecord��Ʒ��¼��Ϣ
	@Override
	public List<SubjectPurchaseRecord> getBySubjectPurchaseRecordId(Object... object) {
		List<SubjectPurchaseRecord> subjectPurchaseRecord = ag_ProductDao.GetSubjectPurchaseRecord(object);
		return subjectPurchaseRecord;
	}

	// ����memberid��subjectid�޸�SubjectPurchaseRecord��Ʒ��¼��Ϣ
	@Override
	public void UpdateSubjectPurchaseRecord(Object... object) {
		ag_ProductDao.UpdateSubjectPurchaseRecord(object);
	}

	// ����ID��ѯ��Ա�˻������
	public MemberAccount UpdateMemberAccount(Object... objects) {
		MemberAccount memberAccount=ag_ProductDao.GetMemberAccount(objects);
		return memberAccount;
	}
	
	// ���׼�¼���������
	@Override
	public void saveMemberTradeRecord(Object... object) {
		ag_ProductDao.saveMemberTradeRecord(object);

	}

	// �����˱��������
		@Override
		public void saveMembertally(Object... object) {
			ag_ProductDao.saveMembertally(object);

		}
		

	// �������ı��������
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
