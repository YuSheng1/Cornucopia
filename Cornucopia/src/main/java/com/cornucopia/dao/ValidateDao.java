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

	// 根据昵称和手机号查询有没有这个人
	public Boolean UserLogin(String name, String password) {
		Session session = getSession();
		String hql = "from Member  where name='" + name + "'and password='" + password + "' or mobile_Phone='" + name
				+ "' and password='" + password + "' ";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("用户名密码匹配");
			return true;
		}
		return false;
	}

	// 根据昵称查询有没有注册
	public Boolean Userzcnc(String name) {
		Session session = getSession();
		String hql = "from Member  where name='" + name.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("用户名密码匹配");
			return false;
		}
		return true;
	}

	// 根据身份证查询有没有注册
	public Boolean Usersfid(String identity) {
		Session session = getSession();
		String hql = "from Member  where identity='" + identity.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return false;
		}
		return true;
	}

	// 根据被邀请码查询邀请人
	public Member Useryqjl(String invitationCode) {
		Session session = getSession();
		String hql = "from Member  where invitationCode='" + invitationCode.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	// 根据邀请码存不存在
	public Boolean Userzcsjh(String invitationCode) {
		Session session = getSession();
		String hql = "from Member  where invitationCode='" + invitationCode.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("用户名密码匹配");
			return false;
		}
		return true;
	}

	// 根据昵称查询有没有注册
	public Boolean Usersyz(String mobile_Phone) {
		Session session = getSession();
		String hql = "from Member  where mobile_Phone='" + mobile_Phone.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// 根据昵称获取对象
	public Member memberLogin(String name) {
		Session session = getSession();
		String hql = "from Member  where name='" + name.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 根据昵称获取对象
	public Member memberLoginUser(String name) {
		Session session = getSession();
		String hql = "from Member  where member_name='" + name.trim() + "'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	// 根据昵称获取对象
		public Member memberce(int id) {
			Session session = getSession();
			String hql = "from Member  where id='" + id+ "'";
			List<Member> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				return list.get(0);
			}
			return null;
		}

	// 根据id获取MemberAccount对象金额表
	public MemberAccount getMemberAccount(int id) {
		Session session = getSession();
		String hql = "from MemberAccount  where member_id=" + id;
		List<MemberAccount> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 根据id获取MemberBankcards对象银行卡绑定表表
	public List<MemberBankcards> getMemberBankcards(int id) {
		Session session = getSession();
		String hql = "from MemberBankcards  where member_id=" + id;
		List<MemberBankcards> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// 根据i卡号获取MemberBankcards对象银行卡绑定表表
	public boolean getMemberBankcardsKa(String card_no) {
		Session session = getSession();
		String hql = "from MemberBankcards  where card_no=" + card_no;
		List<MemberBankcards> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return false;
		}
		return true;
	}

	// 根据id获取MemberBankcards对象银行卡绑定表表
	public List<MemberBankcards> MemberBankcardsListAll() {
		Session session = getSession();
		String hql = "from MemberBankcards";
		List<MemberBankcards> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
	
	public List<MemberBankcards> MemberBankcardsList(String mobile_Phone,String member_name,String card_no,String create_date) {
		Session session = getSession();
		String sql = "select m.mobile_Phone,m.member_name,m.identity,c.type,c.card_no,c.cardaddress,c.delflag,c.create_date,c.id from member_bankcards c inner join Member m on c.member_id=m.id where 0=0";
		if(mobile_Phone!=null&&!mobile_Phone.equals("")){
			sql+=" and m.mobile_Phone like '%"+mobile_Phone+"%' ";
		}
		if(member_name!=null&&!member_name.equals("")){
			sql+=" and m.member_name like '%"+member_name+"%' ";
		}
		if(card_no!=null&&!card_no.equals("")){
			sql+=" and c.card_no like '%"+card_no+"%' ";
		}
		if(create_date!=null&&!create_date.equals("")){
			sql+=" and c.create_date like '%"+create_date+"%' ";
		}
		List list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
	// 获取邀请奖励表
		public List<AwardRecords> AwardRecordsList() {
			Session session = getSession();
			String hql = "from AwardRecords";
			List<AwardRecords> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				return list;
			}
			return null;
		}
	// 获取标对象表
	public List<Subject> SubjectList(String name,String status,String type) {
		Session session = getSession();
		String hql = "from Subject where 0=0";
		if(name!=null&&!name.equals("")){
			hql+=" and name like '%"+name+"%'";
		}
		if(status!=null&&!status.equals("")){
			if(status.equals("-1")){
				hql+="";
			}else{
				hql+=" and status like '%"+status+"%'";
			}
		}
		if(type!=null&&!type.equals("")){
			if(type.equals("-1")){
				hql+="";
			}else{
				hql+=" and type like '%"+type+"%'";
			}
		}
		List<Subject> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
	// 充值记录表
		public List<MemberDepositRecord> getMemberDepositRecord(String serial_number,String status,String pay_channel_order_no,String create_date) {
			Session session = getSession();
			String hql = "from MemberDepositRecord where 0=0";
			if(serial_number!=null&&!serial_number.equals("")){
				hql+=" and serial_number like '%"+serial_number+"%' ";
			}
			if(status!=null&&!status.equals("")){
				if(status.equals("-1")){
					//sql+=" and r.status like '%"+0+"%' or r.status like '%"+1+"%'";
					hql+="";
				}
				else{
					hql+=" and status like '%"+status+"%' ";
				}
			}
			if(pay_channel_order_no!=null&&!pay_channel_order_no.equals("")){
				hql+="and pay_channel_order_no like '%"+pay_channel_order_no+"%' ";
			}
			if(create_date!=null&&!create_date.equals("")){
				hql+=" and create_date like '%"+create_date+"%' ";
			}
			List<MemberDepositRecord> list = session.createQuery(hql).list();
			if (list.size() > 0) {
				return list;
			}
			return null;
		}

	// 获取体验金对象表
	public List<SubjectBbinPurchassRecord> SubjectBbinPurchassRecordList(int subjectId) {
		Session session = getSession();
		String hql = "from SubjectBbinPurchassRecord where subject.id="+subjectId;
		List<SubjectBbinPurchassRecord> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// 获取表的购买表
	public List<SubjectPurchaseRecord> SubjectPurchaseRecordList(int subjectId) {
		Session session = getSession();
		String hql = "from SubjectPurchaseRecord where subject.id="+subjectId;
		List<SubjectPurchaseRecord> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// 根据id获取MemberBankcards对象银行卡绑定表表
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
	// 根据id获取MemberBankcards对象银行卡绑定表表
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
