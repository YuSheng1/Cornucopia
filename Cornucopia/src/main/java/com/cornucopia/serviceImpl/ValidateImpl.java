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
		if (memberAccount !=null) {
			return memberAccount;
		}
		return null;
	}
	//根据用户id查询银行卡
	@Override
	public List<com.cornucopia.bean.MemberBankcards> MemberBankcards(int id) {
		List<com.cornucopia.bean.MemberBankcards> memberAccount=validateDao.getMemberBankcards(id);
		if (memberAccount.size()>0) {
			return memberAccount;
		}
		return null;
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
	public List<com.cornucopia.bean.MemberBankcards> MemberBankcardsListAll() {
		List<com.cornucopia.bean.MemberBankcards> list=validateDao.MemberBankcardsListAll();
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public boolean Usersyz(String invitedCode) {
		return validateDao.Usersyz(invitedCode);
	}
	@Override
	public Member  Useryqjl(String invitationCode) {
		Member member=validateDao.Useryqjl(invitationCode);
		if (member!=null) {
			return member;
		}
		return null;
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
	public List<Subject> SubjectList(String name,String status,String type) {
		List<Subject> list=validateDao.SubjectList(name, status, type);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public List<SubjectBbinPurchassRecord> SubjectBbinPurchassRecordList(int subjectId) {
		List<SubjectBbinPurchassRecord> list=validateDao.SubjectBbinPurchassRecordList(subjectId);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public List<SubjectPurchaseRecord> SubjectPurchaseRecordList(int subjectId) {
		List<SubjectPurchaseRecord> list=validateDao.SubjectPurchaseRecordList(subjectId);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public List<MemberDepositRecord> getMemberDepositRecord(String serial_number,String status,String pay_channel_order_no,String create_date) {
		List<MemberDepositRecord> list=validateDao.getMemberDepositRecord(serial_number, status, pay_channel_order_no, create_date);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public List<AwardRecords> AwardRecordsList() {
		List<AwardRecords> list=validateDao.AwardRecordsList();
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public List<AwardRecordsVo>  AwardRecordsListVo(int id) {
		List<AwardRecordsVo> list=validateDao.AwardRecordsListVo(id);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public  List MemberBankcardsList(String mobile_Phone, String member_name, String card_no, String create_date) {
		List list=validateDao.MemberBankcardsList(mobile_Phone, member_name, card_no, create_date);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
}
