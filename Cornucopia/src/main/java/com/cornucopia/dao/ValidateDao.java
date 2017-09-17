package com.cornucopia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.CashFlowProcess;
import com.cornucopia.bean.CashFlowProcessVo;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;

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
		String hql = "from Member  where name='"+name.trim()+"'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("�û�������ƥ��");
			return false;
		}
		return true;
	}

	// �����ǳƲ�ѯ��û��ע��
	public Boolean Userzcsjh(String mobile_Phone) {
		Session session = getSession();
		String hql = "from Member  where mobile_Phone='" + mobile_Phone.trim()+"'";
		List<Member> list = session.createQuery(hql).list();
		if (list.size() > 0) {
			System.out.println("�û�������ƥ��");
			return false;
		}
		return true;
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
		return list;
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

}
