package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.AwardRecords;
import com.cornucopia.bean.AwardRecordsVo;
import com.cornucopia.bean.CashFlowProcessVo;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberDepositRecord;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectBbinPurchassRecord;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.dao.PM_UserDaoImpl;
import com.cornucopia.dao.ValidateDao;
import com.cornucopia.service.ValidateService;

@Component
public class ValidateImpl implements ValidateService {
	
	@Autowired
	private PM_UserDaoImpl pM_UserDaoImpl;
	
	@Autowired
	private ValidateDao validateDao;
	@Override
	public Boolean getByPhone(String mobile_Phone) {
		boolean boo=pM_UserDaoImpl.getByPhone(mobile_Phone);
		return boo;
	}
	//判断用户密码是否正确
	@Override
	public Boolean UserLogin(String name, String password) {
		boolean boo=validateDao.UserLogin(name, password);
		return boo;
	}
	//根据用户名查询对象
	@Override
	public Member member(String name) {
		Member member=validateDao.memberLogin(name);
		return member;
	}
	//根据流程id查询Vo表
		@Override
		public CashFlowProcessVo cashFlowProcessVo(int id) {
			CashFlowProcessVo cashFlowProcessVo=validateDao.CashFlowProcessVo(id);
			return cashFlowProcessVo;
		}
	
	//根据用户id查询金额
	@Override
	public com.cornucopia.bean.MemberAccount MemberAccount(int id) {
		com.cornucopia.bean.MemberAccount memberAccount=validateDao.getMemberAccount(id);
		return memberAccount;
	}
	//根据用户id查询银行卡
	@Override
	public List<com.cornucopia.bean.MemberBankcards> MemberBankcards(int id) {
		List<com.cornucopia.bean.MemberBankcards> memberAccount=validateDao.getMemberBankcards(id);
		return memberAccount;
	}
	//根据昵称查询
	@Override
	public boolean Usernc(String name) {
		return validateDao.Userzcnc(name);
	}
	//根据手机号查询
	@Override
	public boolean Usersjh(String mobile_Phone) {
		return validateDao.Userzcsjh(mobile_Phone);
	}
	@Override
	public  Member memberLoginUser(String name) {
		Member member=validateDao.memberLoginUser(name);
		return member;
	}
	@Override
	public List<com.cornucopia.bean.MemberBankcards> MemberBankcardsList() {
		List<com.cornucopia.bean.MemberBankcards> list=validateDao.MemberBankcardsList();
		return list;
	}
	@Override
	public boolean Usersyz(String invitedCode) {
		return validateDao.Usersyz(invitedCode);
	}
	@Override
	public Member  Useryqjl(String invitationCode) {
		Member member=validateDao.Useryqjl(invitationCode);
		return member;
	}
	@Override
	public Boolean getMemberBankcardsKa(String card_no) {
		return 	validateDao.getMemberBankcardsKa(card_no);
	}
	@Override
	public boolean Usersfid(String invitedCode) {
		return 	validateDao.Usersfid(invitedCode);
	}
	@Override
	public List<Subject> SubjectList() {
		List<Subject> list=validateDao.SubjectList();
		return list;
	}
	@Override
	public List<SubjectBbinPurchassRecord> SubjectBbinPurchassRecordList(int subjectId) {
		List<SubjectBbinPurchassRecord> list=validateDao.SubjectBbinPurchassRecordList(subjectId);
		return list;
	}
	@Override
	public List<SubjectPurchaseRecord> SubjectPurchaseRecordList(int subjectId) {
		List<SubjectPurchaseRecord> list=validateDao.SubjectPurchaseRecordList(subjectId);
		return list;
	}
	@Override
	public List<MemberDepositRecord> getMemberDepositRecord() {
		List<MemberDepositRecord> list=validateDao.getMemberDepositRecord();
		return list;
	}
	@Override
	public List<AwardRecords> AwardRecordsList() {
		List<AwardRecords> list=validateDao.AwardRecordsList();
		return list;
	}
	@Override
	public List<AwardRecordsVo>  AwardRecordsListVo(int id) {
		List<AwardRecordsVo> list=validateDao.AwardRecordsListVo(id);
		return list;
	}
	
}
