package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.MembeWithdrawRecord;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;
import com.cornucopia.bean.MemberDepositRecord;
import com.cornucopia.bean.MemberTradeRecord;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.bean.SysRegion;
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
	//����id��ѯ��ֵ��¼��
	@Override
	public List<MemberDepositRecord> GetMemberDepositRecordByid(int id,Map map) {
		List<MemberDepositRecord> memberDepositRecord = ag_ProductDao.GetMemberDepositRecordByid(id,map);
		return memberDepositRecord;
	}
   //����id��ѯ���п��󶨱�
	@Override
	public MemberBankcards GetMemberBankcardsByid(int id) {
		MemberBankcards memberDepositRecord = ag_ProductDao.GetMemberBankcardsByid(id);
		return memberDepositRecord;
	}
	// ����memberid��subjectid�޸�SubjectPurchaseRecord��Ʒ��¼��Ϣ
	@Override
	public void UpdateSubjectPurchaseRecord(Object... object) {
		ag_ProductDao.UpdateSubjectPurchaseRecord(object);
	}
	@Override
	// ����ID��ѯ��Ա�˻������
	public MemberAccount UpdateMemberAccount(Object... objects) {
		MemberAccount memberAccount=ag_ProductDao.GetMemberAccount(objects);
		return memberAccount;
	}
	@Override
	// ����ID��ѯ��Ա�˻������
		public MembeWithdrawRecord GetMembeWithdrawRecordByliushui(String liushui) {
			MembeWithdrawRecord memberAccount=ag_ProductDao.GetMembeWithdrawRecordByliushui(liushui);
			return memberAccount;
		}
	// ���׼�¼���������
	@Override
	public void saveMemberTradeRecord(Object... object) {
		ag_ProductDao.saveMemberTradeRecord(object);

	}
	// ���׼�¼���������
		@Override
		public void save1MemberTradeRecord(Object... object) {
			ag_ProductDao.save1MemberTradeRecord(object);

		}
	// ���׼�¼���������
		@Override
		public void saveCashFlowProcess(Object... object) {
			ag_ProductDao.saveCashFlowProcess(object);

		}
	// ���׼�¼���������
		@Override
		public void saveMembeWithdrawRecord(Object... object) {
			ag_ProductDao.saveMembeWithdrawRecord(object);

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
	// �������ı��������
		@Override
		public void updateSubjectPurchaseRecord(Object... object) {
			ag_ProductDao.updateSubjectPurchaseRecord(object);

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
	@SuppressWarnings("unchecked")
	@Override
	public  List<SubjectPurchaseRecord> GetSubjectPurchaseRecordByid(int mid,Map map) {
		List<SubjectPurchaseRecord> subjectPurchaseRecordlist=ag_ProductDao.GetSubjectPurchaseRecordByid(map,mid);
		return subjectPurchaseRecordlist;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MembeWithdrawRecord> GetMembeWithdrawRecordByid(int mid,Map map) {
		List<MembeWithdrawRecord> membeWithdrawRecordlist=ag_ProductDao.GetMembeWithdrawRecordByid(mid,map);
		return membeWithdrawRecordlist;
	}
	@Override
	public void savesMemberAccount(Object... object) {
		ag_ProductDao.savesMemberAccount(object);		
	}
	@Override
	public List<SysRegion> saveGetregion(Object... object) {
		List<SysRegion> sysRegion=ag_ProductDao.saveGetregion(object);
		return sysRegion;
		
	}
	@Override
	public List<SysRegion> saveGetregion1(Object... object) {
		List<SysRegion> sysRegion=ag_ProductDao.saveGetregion1(object);
		return sysRegion;
		
	}

	@Override
	public void saveMemberBankcards(Object... object) {
		ag_ProductDao.saveMemberBankcards(object);
	}
	@Override
	public List<MemberTradeRecord> GetmemberTradeRecordByid(int mid) {
		List<MemberTradeRecord> memberTradeRecord=ag_ProductDao.GetmemberTradeRecordByid(mid);
		return memberTradeRecord;
	}
	@Override
	public void saveAwardRecords(Object... object) {
		ag_ProductDao.saveAwardRecords(object);
		
	}
	
}
