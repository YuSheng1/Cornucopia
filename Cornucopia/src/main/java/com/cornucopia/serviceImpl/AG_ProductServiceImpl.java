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
	//根据id查询充值记录表
	@Override
	public List<MemberDepositRecord> GetMemberDepositRecordByid(int id,Map map) {
		List<MemberDepositRecord> memberDepositRecord = ag_ProductDao.GetMemberDepositRecordByid(id,map);
		return memberDepositRecord;
	}
   //根据id查询银行卡绑定表
	@Override
	public MemberBankcards GetMemberBankcardsByid(int id) {
		MemberBankcards memberDepositRecord = ag_ProductDao.GetMemberBankcardsByid(id);
		return memberDepositRecord;
	}
	// 根据memberid和subjectid修改SubjectPurchaseRecord产品记录信息
	@Override
	public void UpdateSubjectPurchaseRecord(Object... object) {
		ag_ProductDao.UpdateSubjectPurchaseRecord(object);
	}
	@Override
	// 根据ID查询成员账户表操作
	public MemberAccount UpdateMemberAccount(Object... objects) {
		MemberAccount memberAccount=ag_ProductDao.GetMemberAccount(objects);
		return memberAccount;
	}
	@Override
	// 根据ID查询成员账户表操作
		public MembeWithdrawRecord GetMembeWithdrawRecordByliushui(String liushui) {
			MembeWithdrawRecord memberAccount=ag_ProductDao.GetMembeWithdrawRecordByliushui(liushui);
			return memberAccount;
		}
	// 向交易记录表添加数据
	@Override
	public void saveMemberTradeRecord(Object... object) {
		ag_ProductDao.saveMemberTradeRecord(object);

	}
	// 向交易记录表添加数据
		@Override
		public void save1MemberTradeRecord(Object... object) {
			ag_ProductDao.save1MemberTradeRecord(object);

		}
	// 向交易记录表添加数据
		@Override
		public void saveCashFlowProcess(Object... object) {
			ag_ProductDao.saveCashFlowProcess(object);

		}
	// 向交易记录表添加数据
		@Override
		public void saveMembeWithdrawRecord(Object... object) {
			ag_ProductDao.saveMembeWithdrawRecord(object);

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
	// 往购买标的标添加数据
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
