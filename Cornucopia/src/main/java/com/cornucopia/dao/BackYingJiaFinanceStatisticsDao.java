package com.cornucopia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.BackYingJiaFinanceAwardVo;
import com.cornucopia.bean.BackYingJiaFinanceDepositVo;
import com.cornucopia.bean.BackYingJiaFinancePayVo;
import com.cornucopia.bean.BackYingJiaFinanceWithdrawVo;



/**
 * ��̨-->ӯ+ͳ��-->����ͳ��-->dao����
 * @author PC
 *
 */
@Component
public class BackYingJiaFinanceStatisticsDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	/**
	 * �˻���ֵ
	 */
	public List deposit(Map map){
		Session session=getSession();
		String sql="select pay_channel_name,sum(amount) as samount from member_deposit_record  where 0=0 GROUP BY pay_channel_name";
		sql=listSql(map, sql);
		List list=session.createSQLQuery(sql).list();
		
		List<BackYingJiaFinanceDepositVo> depositList=new ArrayList<BackYingJiaFinanceDepositVo>();
		for(int i=0;i<list.size();i++){
			Object[] objs=(Object[]) list.get(i);
			BackYingJiaFinanceDepositVo depositVo=new BackYingJiaFinanceDepositVo();
			depositVo.setPay_channel_name(objs[0].toString());
			depositVo.setSamount(Float.valueOf(objs[1].toString()));
			
			depositList.add(depositVo);
		}
		return depositList;
	}
	
	/**
	 * �˻�����
	 */
	public List withdraw(Map map){
		Session session=getSession();
		
		String sql="select channel_name,sum(amount) as wamount from member_withdraw_record  where 0=0 GROUP BY channel_name ";
		sql=listSql(map, sql);
		
		List list=session.createSQLQuery(sql).list();
		
		List<BackYingJiaFinanceWithdrawVo> withdrawList=new ArrayList<BackYingJiaFinanceWithdrawVo>();
		for(int i=0;i<list.size();i++){
			Object[] objs=(Object[]) list.get(i);
			BackYingJiaFinanceWithdrawVo withdrawVo=new BackYingJiaFinanceWithdrawVo();
			withdrawVo.setChannel_name(objs[0].toString());
			withdrawVo.setWamount(Float.valueOf(objs[1].toString()));
			
			withdrawList.add(withdrawVo);
		}
		return withdrawList;
	}
	
	/**
	 * �û��ܺ��
	 */
	public List award(Map map){
		Session session=getSession();
		String sql="select type,sum(amount) from award_records where 0=0 group by type ";
		sql=addSql(map, sql);
		List list=session.createSQLQuery(sql).list();
		
		List<BackYingJiaFinanceAwardVo> awardList=new ArrayList<BackYingJiaFinanceAwardVo>();
		for(int i=0;i<list.size();i++){
		Object[] objs=(Object[]) list.get(i);
		BackYingJiaFinanceAwardVo awardVo=new BackYingJiaFinanceAwardVo();
		awardVo.setType(objs[0].toString());
		awardVo.setAmount(Float.valueOf(objs[1].toString()));
		
		awardList.add(awardVo);
		}
		return awardList;
	}
	
	/**
	 * Ͷ��������-->˽ļ����
	 */
	public String placement(Map map){
		Session session=getSession();
		String sql="select ifnull(SUM(interest),0) as interest from finance_product_subscribe where 0=0";
		sql=listSql(map, sql);
		if(session.createSQLQuery(sql).uniqueResult().toString()!=null||session.createSQLQuery(sql).uniqueResult().toString()!="0"){
			return session.createSQLQuery(sql).uniqueResult().toString();
		}else{
			return null;
		}
	}
	/**
	 * Ͷ��������-->�������
	 */
	public String purchase(Map map){
		Session session=getSession();
		String sql="select ifnull(SUM(interest),0) from subject_purchase_record where 0=0";
		sql=listSql(map, sql);
		if(session.createSQLQuery(sql).uniqueResult().toString()!=null||session.createSQLQuery(sql).uniqueResult().toString()!="0"){
			return session.createSQLQuery(sql).uniqueResult().toString();
		}else{
			return null;
		}
	}
	
	/**
	 * ������-->��ֵ
	 */
	public List pay(Map map){
		Session session=getSession();
		String sql="select type,sum(sell_price) as price from sys_recharge_price_config where 0=0 group by type ";
		sql=listSql(map, sql);
		List list=session.createSQLQuery(sql).list();
		
		List<BackYingJiaFinancePayVo> payList=new ArrayList<BackYingJiaFinancePayVo>();
		for(int i=0;i<list.size();i++){
			Object[] objs=(Object[]) list.get(i);
			BackYingJiaFinancePayVo payVo=new BackYingJiaFinancePayVo();
			payVo.setType(objs[0].toString());
			payVo.setPrice(Float.valueOf(objs[1].toString()));
			
			payList.add(payVo);
		}
		return payList;
	}
	
	/**
	 * ������-->��������
	 */
	public String lifePay(Map map){
		Session session=getSession();
		String sql="select ifnull(sum(amount),0) from member_tally where type_id=0 group by type_id ";
		sql=listSql(map, sql);
		if(session.createSQLQuery(sql).uniqueResult().toString()!=null||session.createSQLQuery(sql).uniqueResult().toString()!="0"){
			return session.createSQLQuery(sql).uniqueResult().toString();
		}else{
			return null;
		}
	}
	
	/**
	 * ��Ͷ��-->˽ļ����
	 * @return
	 */
	public String place(Map map){
		Session session=getSession();
		String sql="select ifnull(SUM(amount),0) from finance_product_subscribe where 0=0";
		sql=listSql(map, sql);
		String  place=session.createSQLQuery(sql).uniqueResult().toString();
		return place;
	}
	
	/**
	 * ��Ͷ��-->�������
	 */
	public String purch(Map map){
		Session session=getSession();
		String sql="select ifnull(SUM(amount),0) from subject_purchase_record where 0=0";
		sql=listSql(map, sql);
		String  purch=session.createSQLQuery(sql).uniqueResult().toString();
		return purch;
	}
	
	//������ѯ
	public String listSql(Map map,String sql){
		 String start=(String)map.get("start");
		 String end=(String)map.get("end");
		 String mons=(String)map.get("mons");
		 System.out.println(mons);
		 if(mons!=null&&!mons.equals("")){
			if(mons.equals("'0'")){    //��ǰ
				sql+=" and PERIOD_DIFF(DATE_FORMAT(now(),'%Y%m'),DATE_FORMAT(create_date,'%Y%m'))=0 ";
			}else if(mons.equals("'1'")){   //�ϸ���
				sql+=" and PERIOD_DIFF(DATE_FORMAT(now(),'%Y%m'),DATE_FORMAT(create_date,'%Y%m'))=1 ";
			}else if(mons.equals("'3'")){    //���������
				sql+=" and date_sub(curdate(),interval 90 day)<create_date ";
			}
		}else{
		  if(map.get("start")!=null&&!start.equals("")){
			  sql+=" and create_date>'"+start+"' ";
		  }
		  if(end!=null&&!end.equals("")){
		    sql+=" and create_date<'"+end+"' ";
			}
		}
		return sql;
	}
	
	//���ģ����ѯ
	public String addSql(Map map,String sql){
		 String start=(String)map.get("start");
		 String end=(String)map.get("end");
		 String mons=(String)map.get("mons");
		 
        if(mons!=null&&!mons.equals("")){
			if(mons.equals("'0'")){    //��ǰ
				sql+=" and PERIOD_DIFF(DATE_FORMAT(now(),'%Y%m'),DATE_FORMAT(addTime,'%Y%m'))=0 ";
			}else if(mons.equals("'1'")){   //�ϸ���
				sql+=" and PERIOD_DIFF(DATE_FORMAT(now(),'%Y%m'),DATE_FORMAT(addTime,'%Y%m'))=1 ";
			}else if(mons.equals("'3'")){    //���������
				sql+=" and date_sub(curdate(),interval 90 day)<addTime ";
			}
		}else{
		  if(start!=null&&!start.equals("")){
			  sql+=" and addTime>'"+start+"' ";
		  }
          if(end!=null&&!end.equals("")){
       	      sql+=" and addTime<'"+end+"' ";
		  }
		}
		return sql;
	}
}
