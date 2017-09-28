package com.cornucopia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;

/**
 * 后台-->盈+统计-->用户综合统计-->dao方法
 * @author PC
 *
 */
@Component
public class BackYingJiaUsersCountDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	
	/**
	 * 用户基本信息
	 */
	public Member member(Object obj){
		Session session=getSession();
		String phone=(String) obj;
		if(phone!=null&&!phone.equals("")){
		String hql=" from Member where mobile_Phone='"+phone+"' ";
		List<Member> list=session.createQuery(hql).list(); //list只有一条数据
		if(list.size()>0){
			return list.get(0);
		}
		}
		return null;
	}
	
	/**
	 * 资金信息-->充值总额
	 */
	public String deposit(Object obj){
		Session session=getSession();
		String phone=(String) obj;
		String sql="select COALESCE(sum(amount),0) as damount from member_deposit_record where member_id=(select id from member where mobile_Phone='"+phone+"')";
		//String类型接收，因为只需一个字段
		if(session.createSQLQuery(sql).uniqueResult().toString()!="0"){
			return session.createSQLQuery(sql).uniqueResult().toString();
		}else{
			return "0";
		}
}
	
	/**
	 * 资金信息-->提现总额
	 */
	public String withdraw(Object obj){
		Session session=getSession();
		String phone=(String) obj;
		String sql="select  COALESCE(sum(amount),0) as wamount from member_withdraw_record where member_id=(select id from member where mobile_Phone='"+phone+"')";
		if(session.createSQLQuery(sql).uniqueResult().toString()!="0"){
			return session.createSQLQuery(sql).uniqueResult().toString();
		}else{
			return "0";
		}
	}
		
	
	/**
	 * 资金信息-->账户各类金额
	 */
	public MemberAccount account(Object obj){
		Session session=getSession();
		String phone=(String) obj;
		if(phone!=null&&!phone.equals("")){ 
		String hql=" from MemberAccount m where m.member.mobile_Phone='"+phone+"'";
		List<MemberAccount> list=session.createQuery(hql).list();
		if(list.size()>0){
			return list.get(0);
		}
		}
		return null;
	}
	
	/**
	 * 资金信息-->红包金额
	 */
	public String amount(Object obj){
		Session session=getSession();
		int phone=(int) obj;
		String sql="select  COALESCE(sum(amount),0) from award_records where invitingid='"+phone+"'";
		if(session.createSQLQuery(sql).uniqueResult().toString()!="0"){
			return session.createSQLQuery(sql).uniqueResult().toString();
		}else{
			return "0";
		}
	}
	
	/**
	 * 交易记录信息
	 * @param mobile_Phone
	 * @return
	 */
	public List tradeList(Object obj){
		Session session=getSession();
		Map map=(Map) obj;
		String mobile_Phone=(String) map.get("phone");
		if(mobile_Phone!=null&&!mobile_Phone.equals("")){
		String hql=" from MemberTradeRecord t inner join fetch t.member where t.member.mobile_Phone='"+mobile_Phone+"'";
		hql=listHql(hql,map);
		List tradeList=session.createQuery(hql).list();
		if(tradeList.size()>0){
			return tradeList;
		}
		
		}
		return  null;
	}
	
	/**
	 * 交易记录模糊查询
	 * @param sql
	 * @param map
	 * @return
	 */
	public String listHql(String hql,Map map){
		String start=(String) map.get("start");
		String end=(String) map.get("end");
		String qtrade_type=(String) map.get("qtrade_type");
		if(start!=null&&!start.equals("")){
			hql+=" and t.create_date>='"+start+"'";
		}
		if(end!=null&&!end.equals("")){
			hql+=" and t.create_date<='"+end+"'";
		}
		if(qtrade_type!=null&&!qtrade_type.equals("")){
			if(qtrade_type.equals("-1")){
				hql+="";
			}else{
				hql+=" and t.trade_type='"+qtrade_type+"'";
			}
		}
		return hql;
	}
	
	/*
	 * 基本信息显示，一条数据，返回值域类
	 * @return
	 */
//	public BackYingJiaUsersCountVo usersCount(Object obj){
//		Session session=getSession();
//		String phone=(String) obj;
//		if(phone!=null&&!phone.equals("")){
//		String sql="select m.member_name,m.identity,m.mobile_Phone,m.create_date,m.weixinAccount,m.qqNumber,m.invitationCode,m.invitedCode,"
//				+ "count(d.amount) as damount,count(w.amount) as wamount,a.invest_amount,count(t.amount) as tamount,a.total_profit,count(r.amount) as ramount,a.useable_balance,a.imuseale_balance,a.bonus_amount,a.bbin_amount"
//				+ " from member m,member_deposit_record d,member_withdraw_record w,member_account a,member_trade_record t,award_records r where"
//				+ " m.id=d.member_id and m.id=w.member_id and m.id=a.member_id and m.id=t.member_id and m.id=r.member_id and"
//				+ " a.member_id=(select id from member where mobile_Phone='"+phone+"')";
//		List list=session.createSQLQuery(sql).list();
//		for(int i=0;i<list.size();i++){
//			Object[] objs=(Object[]) list.get(0);
//			BackYingJiaUsersCountVo countVo=new BackYingJiaUsersCountVo();
//			countVo.setMember_name(objs[0].toString());
//			countVo.setIdentity(objs[1].toString());
//			countVo.setMobile_Phone(objs[2].toString());
//			countVo.setCreate_date(objs[3].toString());
//			countVo.setWeixinAccount(objs[4].toString());
//			countVo.setQqNumber(objs[5].toString());
//			countVo.setInvitationCode(objs[6].toString());
//			countVo.setInvitedCode(objs[7].toString());
//			countVo.setDamount(Float.valueOf(objs[8].toString()));
//			countVo.setWamount(Float.valueOf(objs[9].toString()));
//			countVo.setInvest_amount(Float.valueOf(objs[10].toString()));
//			countVo.setTamount(Float.valueOf(objs[11].toString()));
//			countVo.setTotal_profit(Float.valueOf(objs[12].toString()));
//			countVo.setRamount(Float.valueOf(objs[13].toString()));
//			countVo.setUseable_balance(Float.valueOf(objs[14].toString()));
//			countVo.setImuseale_balance(Float.valueOf(objs[15].toString()));
//			countVo.setBonus_amount(Float.valueOf(objs[16].toString()));
//			countVo.setBbin_amount(Float.valueOf(objs[17].toString()));
//			return countVo;
//		}
//		}
//		return  null;
//	} 
}
