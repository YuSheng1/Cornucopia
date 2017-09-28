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
	// 产品操作类
	@Autowired
	public SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	// 省市级联
	public List<SysRegion> saveGetregion(Object... objects) {
		Session session = getsession();
		String sql = " from SysRegion p where p.region_level=1";
		List list = session.createQuery(sql).list();
		return list;
	}
	public List<PushNotice> GetPushNotice(Object... objects) {
		Session session = getsession();
		String sql = " from PushNotice";
		List list = session.createQuery(sql).list();
		return list;
	}

	// 省市级联1
	public List<SysRegion> saveGetregion1(Object... objects) {
		System.out.println(objects[0] + "***********88");
		Session session = getsession();
		String sql = " from SysRegion p where p.parent_id=" + objects[0];
		List list = session.createQuery(sql).list();
		return list;
	}

	// 根据ID查询基金类产品信息 产品信息表操作
	public FinanceProductFunds GetFinanceProductFundsId(int id) {
		Session session = getsession();
		FinanceProductFunds FinanceProductFunds = (FinanceProductFunds) session.get(FinanceProductFunds.class, id);
		return FinanceProductFunds;
	}

	// 根据ID查询产品信息 产品信息表操作
	public Subject GetSubject(int id) {
		Session session = getsession();
		Subject subject = (Subject) session.get(Subject.class, id);
		return subject;
	}

	// 根据ID查询产品购买表操作
	public List<SubjectPurchaseRecord> GetSubjectPurchaseRecord(Object... objects) {
		Session session = getsession();
		String sql = " from SubjectPurchaseRecord p where p.subject.id=" + objects[0] + " and p.member.id="
				+ objects[1] + " order by create_date desc ";
		List list = session.createQuery(sql).list();
		return list;
	}

//	// 根据ID查询产品购买表操作
//	public List<SubjectPurchaseRecord> GetSubjectPurchaseRecordByid(int mid) {
//		Session session = getsession();
//		String sql = " from SubjectPurchaseRecord p where p.member.id=" + mid;
//		List list = session.createQuery(sql).list();
//		if (list.size() > 0) {
//			return list;
//		}
//		return null;
//	}
	
	//根据Id查询投资记录
		public List<SubjectPurchaseRecord>  GetSubjectPurchaseRecordByid(Map map,int mid){
			String hql="from SubjectPurchaseRecord p where p.member.id=" + mid;
			PageBean pb=(PageBean)map.get("pb");
			int page1=pb.getPage1();
			int size=pb.getSize();
			String flag=(String)map.get("flag");
			int count=countNum(map, mid);
			pb.setTotal1(count);
			
			if(flag!=null){
				if("next".equals(flag)){
					if(page1+1>pb.getTotalpage1()){
						page1=pb.getTotalpage1();
					}else{
						page1=page1+1;
					}
				}
				if("up".equals(flag)){
					if(page1-1<1){
						page1=1;
					}else{
						page1=page1-1;
					}
				}
				if("first".equals(flag)){
					page1=1;
				}
				if("last".equals(flag)){
					page1=pb.getTotalpage1();
				}
			}
			pb.setPage1(page1);
			Session session=getsession();
			System.out.println("sdfs");
			List<SubjectPurchaseRecord> list=session.createQuery(hql).setFirstResult((page1-1)*size).setMaxResults(size).list();
			return list;
		}
		public List<SubjectPurchaseRecord>  GetSubjectPurchaseRecordByid1(int mid){
			String hql="from SubjectPurchaseRecord p where p.member.id=" + mid;
			Session session=getsession();
			List<SubjectPurchaseRecord> list=session.createQuery(hql).list();
			return list;
		}
		public List<MembeWithdrawRecord>  GetMembeWithdrawRecordByid1(int mid){
			String hql="from MembeWithdrawRecord p where p.member.id=" + mid;
			Session session=getsession();
			List<MembeWithdrawRecord> list=session.createQuery(hql).list();
			return list;
		}
		public List<MemberDepositRecord>  GetMemberDepositRecordByid1(int mid){
			String hql="from MemberDepositRecord p where p.member.id=" + mid;
			Session session=getsession();
			List<MemberDepositRecord> list=session.createQuery(hql).list();
			return list;
		}
		public int countNum(Map map,int mid){
			String sql=" select count(*) from subject_purchase_record s ,member m where s.member_id=m.id and m.id="+mid;
			Session session=getsession();
			int count=Integer.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
			return count;
		}
	

	// 根据ID查询产品购买表操作
	public List<MemberTradeRecord> GetmemberTradeRecordByid(int mid) {
		Session session = getsession();
		String sql = " from MemberTradeRecord p where p.member.id=" + mid+ " order by create_date desc ";
		List list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	// 根据id查询充值记录表
	public List<MemberDepositRecord> GetMemberDepositRecordByid(int mid,Map map) {
		String sql = " from MemberDepositRecord m where m.member.id=" + mid + " order by create_date desc";
		PageBean pb=(PageBean)map.get("pb");
		int page2=pb.getPage2();
		int size=pb.getSize();
		String info=(String)map.get("info");
		int count=countNum1(map, mid);
		pb.setTotal2(count);
		
		if(info!=null){
			if("next".equals(info)){
				if(page2+1>pb.getTotalpage2()){
					page2=pb.getTotalpage2();
				}else{
					page2=page2+1;
				}
			}
			if("up".equals(info)){
				if(page2-1<1){
					page2=1;
				}else{
					page2=page2-1;
				}
			}
			if("first".equals(info)){
				page2=1;
			}
			if("last".equals(info)){
				page2=pb.getTotalpage1();
			}
		}
		pb.setPage2(page2);
		Session session=getsession();
		System.out.println("sdfs");
		List<MemberDepositRecord> list=session.createQuery(sql).setFirstResult((page2-1)*size).setMaxResults(size).list();
		return list;
	}
	public int countNum1(Map map,int mid){
		String sql=" select count(*) from member_deposit_record md ,member m where md.member_id=m.id and m.id="+mid;
		Session session=getsession();
		int count=Integer.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
		return count;
	}

	// 根据id查询提款记录表
	public List<MembeWithdrawRecord> GetMembeWithdrawRecordByid(int mid,Map map) {
		String sql = " from MembeWithdrawRecord m where m.member.id=" + mid + " order by create_date desc";
		PageBean pb=(PageBean)map.get("pb");
		int page3=pb.getPage3();
		int size=pb.getSize();
		String note=(String)map.get("note");
		int count=countNum2(map, mid);
		System.out.println(count);
		pb.setTotal3(count);
		
		if(note!=null){
			if("next".equals(note)){
				if(page3+1>pb.getTotalpage3()){
					page3=pb.getTotalpage3();
				}else{
					page3=page3+1;
				}
			}
			if("up".equals(note)){
				if(page3-1<1){
					page3=1;
				}else{
					page3=page3-1;
				}
			}
			if("first".equals(note)){
				page3=1;
			}
			if("last".equals(note)){
				page3=pb.getTotalpage2();
			}
		}
		pb.setPage3(page3);
		Session session=getsession();
		System.out.println("sdfs");
		List<MembeWithdrawRecord> list=session.createQuery(sql).setFirstResult((page3-1)*size).setMaxResults(size).list();
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

	// 根据流水号查询提款记录表
	public MembeWithdrawRecord GetMembeWithdrawRecordByliushui(String liushui) {
		Session session = getsession();
		String sql = " from MembeWithdrawRecord m where m.serial_number=" + liushui + " order by create_date desc";
		List list = session.createQuery(sql).list();
		MembeWithdrawRecord membeWithdrawRecord = (MembeWithdrawRecord) list.get(0);
		return membeWithdrawRecord;
	}

	// 根据id查询提款记录表
	public MemberBankcards GetMemberBankcardsByid(int mid) {
		Session session = getsession();
		String sql = " from MemberBankcards m where m.member.id=" + mid + " order by create_date desc";
		List<MemberBankcards> list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 根据id查询成员利润表(暂时用不上，所以查询字段没改，是错的)
	// public List GetMemberProfitRecord(Object... objects) {
	// String sql = "select * from Subject_purchase_record where subject_id=" +
	// objects[0] + " and member_id="
	// + objects[1];
	// List list =
	// sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	// return list;
	// }

	// 根据ID修改产品购买表操作
	public void UpdateSubjectPurchaseRecord(Object... objects) {
		Session session = getsession();
		session.update(objects[0]);
	}

	// 根据ID查询成员账户表操作
	public MemberAccount GetMemberAccount(Object... objects) {
		Session session = getsession();
		String sql = " from MemberAccount u where u.member.id=" + objects[0];
		List<MemberAccount> list = session.createQuery(sql).list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 向交易记录表添加数据
	public void saveMemberTradeRecord(Object... object) {
		System.out.println("我要看进了几次");
		Session session = getsession();
		session.save(object[0]);

	}

	// 向交易记录表添加数据
	public void save1MemberTradeRecord(Object... object) {
		System.out.println("我要看进了几次");
		Session session = getsession();
		session.save(object[0]);

	}

	// 向提现记录中间表添加数据
	public void saveCashFlowProcess(Object... object) {
		Session session = getsession();
		session.saveOrUpdate(object[0]);

	}

	// 往银联表里添加数据
	public void saveMemberBankcards(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// 往奖励表里添加数据
	public void saveAwardRecords(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// 往及账表添加数据
	public void saveMembertally(Object... object) {
		Session session = getsession();
		session.saveOrUpdate(object[0]);
	}

	// 往提现表添加数据
	public void saveMembeWithdrawRecord(Object... object) {
		Session session = getsession();
		session.saveOrUpdate(object[0]);
	}

	// 往充值表添加数据
	public void saveAlipayTradePagePay(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// 往充值表添加数据
	public void updateAlipayTradePagePay(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// 修改成员表金额
	public void saveMemberAccount(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// 修改成员表金额
	public void savesMemberAccount(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

	// 修改标数据
	public void saveSubject(Object... object) {
		Session session = getsession();
		session.update(object[0]);
	}

	// 往购买标的标添加数据
	public void saveSubjectPurchaseRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}
	// 往购买标的标添加数据
		public void updateSubjectPurchaseRecord(Object... object) {
			Session session = getsession();
			session.update(object[0]);
		}
	// 往购买标的标添加数据
	public void saveMemberProfitRecord(Object... object) {
		Session session = getsession();
		session.save(object[0]);
	}

}
