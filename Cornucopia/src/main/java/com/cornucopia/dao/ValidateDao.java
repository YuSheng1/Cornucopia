package com.cornucopia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.AwardRecords;
import com.cornucopia.bean.AwardRecordsVo;
import com.cornucopia.bean.CashFlowProcess;
import com.cornucopia.bean.CashFlowProcessVo;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;
import com.cornucopia.bean.MemberDepositRecord;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectBbinPurchassRecord;
import com.cornucopia.bean.SubjectPurchaseRecord;

@Component
public class ValidateDao {
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// �����ǳƺ��ֻ��Ų�ѯ��û�������
	public Boolean UserLogin(String name, String password) {
		Session session = getSession();
		String hql = "from Member  where name='" + name + "'and password='" + password + "' or mobile_Phone='" + name
				+ "' and password='" + password + "' ";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("�û�������ƥ��");
			return true;
		}
		return false;
	}

	// �����ǳƲ�ѯ��û��ע��
	public Boolean Userzcnc(String name) {
		Session session = getSession();
		String hql = "from Member  where name='" + name.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("�û�������ƥ��");
			return false;
		}
		return true;
	}

	// �������֤��ѯ��û��ע��
	public Boolean Usersfid(String identity) {
		Session session = getSession();
		String hql = "from Member  where identity='" + identity.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return false;
		}
		return true;
	}

	// ���ݱ��������ѯ������
	public Member Useryqjl(String invitationCode) {
		Session session = getSession();
		String hql = "from Member  where invitationCode='" + invitationCode.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	// ����������治����
	public Boolean Userzcsjh(String invitationCode) {
		Session session = getSession();
		String hql = "from Member  where invitationCode='" + invitationCode.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("�û�������ƥ��");
			return false;
		}
		return true;
	}

	// �����ǳƲ�ѯ��û��ע��
	public Boolean Usersyz(String mobile_Phone) {
		Session session = getSession();
		String hql = "from Member  where mobile_Phone='" + mobile_Phone.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// �����ǳƻ�ȡ����
	public Member memberLogin(String name) {
		Session session = getSession();
		String hql = "from Member  where name='" + name.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// �����ǳƻ�ȡ����
	public Member memberLoginUser(String name) {
		Session session = getSession();
		String hql = "from Member  where member_name='" + name.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	// �����ǳƻ�ȡ����
		public Member memberce(int id) {
			Session session = getSession();
			String hql = "from Member  where id='" + id+ "'";
			List<Member> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				return list.get(0);
			}
			return null;
		}

	// ����id��ȡMemberAccount�������
	public MemberAccount getMemberAccount(int id) {
		Session session = getSession();
		String hql = "from MemberAccount  where member_id=" + id;
		List<MemberAccount> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ����id��ȡMemberBankcards�������п��󶨱��
	public List<MemberBankcards> getMemberBankcards(int id) {
		Session session = getSession();
		String hql = "from MemberBankcards  where member_id=" + id;
		List<MemberBankcards> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// ����i���Ż�ȡMemberBankcards�������п��󶨱��
	public boolean getMemberBankcardsKa(String card_no) {
		Session session = getSession();
		String hql = "from MemberBankcards  where card_no=" + card_no;
		List<MemberBankcards> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return false;
		}
		return true;
	}

	// ����id��ȡMemberBankcards�������п��󶨱��
	public List<MemberBankcards> MemberBankcardsList() {
		Session session = getSession();
		String hql = "from MemberBankcards";
		List<MemberBankcards> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
	// ��ȡ���뽱����
		public List<AwardRecords> AwardRecordsList() {
			Session session = getSession();
			String hql = "from AwardRecords";
			List<AwardRecords> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				return list;
			}
			return null;
		}
	// ��ȡ������
	public List<Subject> SubjectList() {
		Session session = getSession();
		String hql = "from Subject";
		List<Subject> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
	// ��ֵ��¼��
		public List<MemberDepositRecord> getMemberDepositRecord() {
			Session session = getSession();
			String hql = "from MemberDepositRecord";
			List<MemberDepositRecord> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				return list;
			}
			return null;
		}

	// ��ȡ���������
	public List<SubjectBbinPurchassRecord> SubjectBbinPurchassRecordList(int subjectId) {
		Session session = getSession();
		String hql = "from SubjectBbinPurchassRecord where subject.id="+subjectId;
		List<SubjectBbinPurchassRecord> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// ��ȡ��Ĺ����
	public List<SubjectPurchaseRecord> SubjectPurchaseRecordList(int subjectId) {
		Session session = getSession();
		String hql = "from SubjectPurchaseRecord where subject.id="+subjectId;
		List<SubjectPurchaseRecord> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// ����id��ȡMemberBankcards�������п��󶨱��
	public CashFlowProcessVo CashFlowProcessVo(int id) {
		Session session = getSession();
		String hql = "from CashFlowProcess  where ProcessInstanceId=" + id;
		List<CashFlowProcess> list = session.createQuery(hql).list();
		if (list.size() < 1) {
			return null;
		}
		String serialNumbe = list.get(0).getSerialNumbe();
		System.out.println(serialNumbe);
		String sql = "select mr.member_name,m.amount,m.create_date,m.serial_number,c.ProcessInstanceId,c.deploymentId  from member mr,member_withdraw_record m,CashFlowProcess c where mr.id=m.member_id and m.serial_number="
				+ serialNumbe + " and c.serialNumbe=" + serialNumbe;
		List listVo = session.createSQLQuery(sql).list();
		List<CashFlowProcessVo> temp = new ArrayList<CashFlowProcessVo>();
		for (int i = 0; i < listVo.size(); i++) {
			Object[] obj = (Object[]) listVo.get(i);
			CashFlowProcessVo vo = new CashFlowProcessVo();
			vo.setMname(obj[0].toString());
			vo.setMoney(Float.parseFloat(obj[1].toString()));
			vo.setCashWithdrawalTime(obj[2].toString());
			vo.setSerialNumbe(obj[3].toString());
			vo.setLid(Integer.parseInt(obj[4].toString()));
			vo.setDeploymentId(obj[5].toString());
			temp.add(vo);
		}
		CashFlowProcessVo cashFlowProcessVo = temp.get(0);
		return cashFlowProcessVo;
	}
	// ����id��ȡMemberBankcards�������п��󶨱��
		public 	List<AwardRecordsVo> AwardRecordsListVo(int id) {
			Session session = getSession();
			String sql = "select MB.member_name,MW.amount,MW.addTime,MW.type,MW.isAward from award_records MW, member MB where MW.byinvitingid=MB.id  and mw.invitingid="+id;
			List listVo = session.createSQLQuery(sql).list();
			if(listVo.size()<0){
				return null;
			}
			List<AwardRecordsVo> temp = new ArrayList<AwardRecordsVo>();
			for (int i = 0; i < listVo.size(); i++) {
				Object[] obj = (Object[]) listVo.get(i);
				AwardRecordsVo vo = new AwardRecordsVo();
				vo.setBname(obj[0].toString());
				vo.setMoney(Float.parseFloat(obj[1].toString()));
				vo.setDate(obj[2].toString());
				vo.setType(Integer.parseInt((obj[3]).toString()));
				vo.setIsAward(Integer.parseInt(obj[4].toString()));
				temp.add(vo);
			}
		
			return temp;
		}

}
