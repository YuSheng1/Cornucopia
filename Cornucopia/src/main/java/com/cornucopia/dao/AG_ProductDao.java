package com.cornucopia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.MembeWithdrawRecord;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.MemberBankcards;
import com.cornucopia.bean.MemberDepositRecord;
import com.cornucopia.bean.MemberTradeRecord;
import com.cornucopia.bean.PageBean;
import com.cornucopia.bean.PushNotice;
import com.cornucopia.bean.Resources;
import com.cornucopia.bean.Subject;
import com.cornucopia.bean.SubjectPurchaseRecord;
import com.cornucopia.bean.SysRegion;
import com.cornucopia.bean.Users;

@Component
public class AG_ProductDao {
	// ��Ʒ������
	@Autowired
	public SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	// ʡ�м���
	public List<SysRegion> saveGetregion(Object... objects) {
		Session session = getsession();
		String sql = " from SysRegion p where p.region_level=1";
		List list = session.createQuery(sql).list();
		return list;
	}

	// ʡ�м���1
	public List<SysRegion> saveGetregion1(Object... objects) {
		System.out.println(objects[0] + "***********88");
		Session session = getsession();
		String sql = " from SysRegion p where p.parent_id=" + objects[0];
		List list = session.createQuery(sql).list();
		return list;
	}

	// ����ID��ѯ�������Ʒ��Ϣ ��Ʒ��Ϣ�����
	public FinanceProductFunds GetFinanceProductFundsId(int id) {
		Session session = getsession();
		FinanceProductFunds FinanceProductFunds = (FinanceProductFunds) session.get(FinanceProductFunds.class, id);
		return FinanceProductFunds;
	}

	// ����ID��ѯ��Ʒ��Ϣ ��Ʒ��Ϣ�����
	public Subject GetSubject(int id) {
		Session session = getsession();
		Subject subject = (Subject) session.get(Subject.class, id);
		return subject;
	}

	// ����ID��ѯ��Ʒ��������
	public List<SubjectPurchaseRecord> GetSubjectPurchaseRecord(Object... objects) {
		Session session = getsession();
		String sql = " from SubjectPurchaseRecord p where p.subject.id=" + objects[0] + " and p.member.id="
				+ objects[1] + " order by create_date desc ";
		List list = session.createQuery(sql).list();
		return list;
	}

//	// ����ID��ѯ��Ʒ��������
//	public List<SubjectPurchaseRecord> GetSubjectPurchaseRecordByid(int mid) {
//		Session session = getsession();
//		String sql = " from SubjectPurchaseRecord p where p.member.id=" + mid;
//		List list = session.createQuery(sql).list();
//		if (list.size() > 0) {
//			return list;
//		}
//		return null;
//	}
	
	//����Id��ѯͶ�ʼ�¼
		public List<SubjectPurchaseRecord>  GetSubjectPurchaseRecordByid(Map map,int mid){
			String hql="from SubjectPurchaseRecord p where p.member.id=" + mid;
			PageBean pb=(PageBean)map.get("pb");
			int page=pb.getPage();
			int size=pb.getSize();
			String flag=(String)map.get("flag");
			int count=countNum(map, mid);
			pb.setTotal(count);
			
			if(flag!=null){
				if("next".equals(flag)){
					if(page+1>pb.getTotalpage()){
						page=pb.getTotalpage();
					}else{
						page=page+1;
					}
				}
				if("up".equals(flag)){
					if(page-1<1){
						page=1;
					}else{
						page=page-1;
					}
				}
				if("first".equals(flag)){
					page=1;
				}
				if("last".equals(flag)){
					page=pb.getTotalpage();
				}
			}
			pb.setPage(page);
			Session session=getsession();
			System.out.println("sdfs");
			List<SubjectPurchaseRecord> list=session.createQuery(hql).setFirstResult((page-1)*size).setMaxResults(size).list();
			return list;
		}
		
		public int countNum(Map map,int mid){
			String sql=" select count(*) from subject_purchase_record s ,member m where s.member_id=m.id and m.id="+mid;
			Session session=getsession();
			int count=Integer.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
			return count;
		}
	

	// ����ID��ѯ��Ʒ��������
	public List<MemberTradeRecord> GetmemberTradeRecordByid(int mid) {
		Session session = getsession();
		String sql = " from MemberTradeRecord p where p.member.id=" + mid+ " order by create_date desc ";
		List list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// ����id��ѯ��ֵ��¼��
	public List<MemberDepositRecord> GetMemberDepositRecordByid(int mid,Map map) {
		String sql = " from MemberDepositRecord m where m.member.id=" + mid + " order by create_date desc";
		PageBean pb=(PageBean)map.get("pb");
		int page=pb.getPage();
		int size=pb.getSize();
		String info=(String)map.get("info");
		int count=countNum1(map, mid);
		pb.setTotal(count);
		
		if(info!=null){
			if("next".equals(info)){
				if(page+1>pb.getTotalpage()){
					page=pb.getTotalpage();
				}else{
					page=page+1;
				}
			}
			if("up".equals(info)){
				if(page-1<1){
					page=1;
				}else{
					page=page-1;
				}
			}
			if("first".equals(info)){
				page=1;
			}
			if("last".equals(info)){
				page=pb.getTotalpage();
			}
		}
		pb.setPage(page);
		Session session=getsession();
		System.out.println("sdfs");
		List<MemberDepositRecord> list=session.createQuery(sql).setFirstResult((page-1)*size).setMaxResults(size).list();
		return list;
	}
	public int countNum1(Map map,int mid){
		String sql=" select count(*) from member_deposit_record md ,member m where md.member_id=m.id and m.id="+mid;
		Session session=getsession();
		int count=Integer.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
		return count;
	}

	// ����id��ѯ����¼��
	public List<MembeWithdrawRecord> GetMembeWithdrawRecordByid(int mid,Map map) {
		String sql = " from MembeWithdrawRecord m where m.member.id=" + mid + " order by create_date desc";
		PageBean pb=(PageBean)map.get("pb");
		int page=pb.getPage();
		int size=pb.getSize();
		String note=(String)map.get("note");
		int count=countNum2(map, mid);
		pb.setTotal(count);
		
		if(note!=null){
			if("next".equals(note)){
				if(page+1>pb.getTotalpage()){
					page=pb.getTotalpage();
				}else{
					page=page+1;
				}
			}
			if("up".equals(note)){
				if(page-1<1){
					page=1;
				}else{
					page=page-1;
				}
			}
			if("first".equals(note)){
				page=1;
			}
			if("last".equals(note)){
				page=pb.getTotalpage();
			}
		}
		pb.setPage(page);
		Session session=getsession();
		System.out.println("sdfs");
		List<MembeWithdrawRecord> list=session.createQuery(sql).setFirstResult((page-1)*size).setMaxResults(size).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}
	public int countNum2(Map map,int mid){
		String sql=" select count(*) from member_withdraw_record md ,member m where md.member_id=m.id and m.id="+mid;
		Session session=getsession();
		int count=Integer.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
		return count;
	}

	// ������ˮ�Ų�ѯ����¼��
	public MembeWithdrawRecord GetMembeWithdrawRecordByliushui(String liushui) {
		Session session = getsession();
		String sql = " from MembeWithdrawRecord m where m.serial_number=" + liushui + " order by create_date desc";
		List list = session.createQuery(sql).list();
		MembeWithdrawRecord membeWithdrawRecord = (MembeWithdrawRecord) list.get(0);
		return membeWithdrawRecord;
	}

	// ����id��ѯ����¼��
	public MemberBankcards GetMemberBankcardsByid(int mid) {
		Session session = getsession();
		String sql = " from MemberBankcards m where m.member.id=" + mid + " order by create_date desc";
		List<MemberBankcards> list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ����id��ѯ��Ա�����(��ʱ�ò��ϣ����Բ�ѯ�ֶ�û�ģ��Ǵ��)
	// public List GetMemberProfitRecord(Object... objects) {
	// String sql = "select * from Subject_purchase_record where subject_id=" +
	// objects[0] + " and member_id="
	// + objects[1];
	// List list =
	// sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	// return list;
	// }

	// ����ID�޸Ĳ�Ʒ��������
	public void UpdateSubjectPurchaseRecord(Object... objects) {
		Session session = getsession();
		session.update(objects[0]);
	}

	// ����ID��ѯ��Ա�˻������
	public MemberAccount GetMemberAccount(Object... objects) {
		Session session = getsession();
		String sql = " from MemberAccount u where u.member.id=" + objects[0];
		List<MemberAccount> list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ���׼�¼���������
	public void saveMemberTradeRecord(Object... object) {
		System.out.println("��Ҫ�����˼���");
		Session session = getsession();
		session.save(object[0]);

	}

	// ���׼�¼���������
	public void save1MemberTradeRecord(Object... object) {
		System.out.println("��Ҫ�����˼���");
		Session session = getsession();
		session.save(object[0]);

	}

	// �����ּ�¼�м���������
	public void saveCashFlowProcess(Object... object) {
		Session session = getsession();
		session.saveOrUpdate(object[0]);

	}

	// �����������������
	public void saveMemberBankcards(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// �����������������
	public void saveAwardRecords(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// �����˱��������
	public void saveMembertally(Object... object) {
		Session session = getsession();
		session.saveOrUpdate(object[0]);
	}

	// �����ֱ��������
	public void saveMembeWithdrawRecord(Object... object) {
		Session session = getsession();
		session.saveOrUpdate(object[0]);
	}

	// ����ֵ���������
	public void saveAlipayTradePagePay(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// ����ֵ���������
	public void updateAlipayTradePagePay(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// �޸ĳ�Ա����
	public void saveMemberAccount(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// �޸ĳ�Ա����
	public void savesMemberAccount(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// �޸ı�����
	public void saveSubject(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// �������ı��������
	public void saveSubjectPurchaseRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}
	// �������ı��������
		public void updateSubjectPurchaseRecord(Object... object) {
			Session session = getsession();
			session.update(object[0]);
		}
	// �������ı��������
	public void saveMemberProfitRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

}
