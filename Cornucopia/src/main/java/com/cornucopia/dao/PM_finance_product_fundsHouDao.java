package com.cornucopia.dao;

import java.util.List;



import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.FinanceProductSubscribe;


@Component
public class PM_finance_product_fundsHouDao {
	
	/**
	 * 锟斤拷台锟斤拷锟斤拷锟斤拷Do 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public List listFun(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		String hql="from FinanceProductFunds";
		List list=session.createQuery(hql).list();
		return list;
	}
		
	
	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param subject
	 */
	public void save(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.save(financeProductFunds);
	}
	/**
	 * 锟斤拷锟斤拷锟斤拷锟窖拷锟斤拷锟絣ist锟斤拷锟斤拷
	 * @return
	 */
	public List<FinanceProductFunds> list(Map map){
		Session session=getSession();
//		int index=pagebean.getPage();  //锟斤拷前页
//		int max=pagebean.getPagesize(); //每页锟斤拷锟斤拷
		String hql="from FinanceProductFunds where 0=0";
		//System.out.println("hql");
		hql+=getHql(hql, map);
		List<FinanceProductFunds> list=session.createQuery(hql).list();
		//System.out.println(list);
		return list;
	}
	//锟斤拷取锟斤拷锟斤拷锟斤拷
//	public int getCountOver(Map map){
//		Session session=getSession();
//		String sql="select count(*) from finance_product_funds where 0=0";
//		sql+=getHql(sql,map);
//		String count=session.createSQLQuery(sql).uniqueResult().toString();
//		return Integer.valueOf(count);
//	}
	/**
	 * 模锟斤拷锟窖拷锟斤拷锟斤拷锟�
	 */
	public String getHql(String hql,Map map){
		String name=(String)map.get("name");
		String type=(String)map.get("type");
		String status=(String)map.get("status");
		//System.out.println(name);
		hql="";
		if(name!=null&&!name.trim().equals("")){
			hql+=" and name like '%"+name+"%'";
		}
		if(type!=null&&!type.trim().equals("")){
			hql+=" and type like "+type+"";
		}
		if(status!=null&&!status.trim().equals("")){
			hql+=" and status like "+status+"";
		}
		return hql;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public FinanceProductFunds getById(int id){
		Session session=getSession();
		System.out.println(id);
		FinanceProductFunds financeProductFunds=(FinanceProductFunds)session.get(FinanceProductFunds.class, id);
		return financeProductFunds;
	}
	/**
	 * @param FinanceProductFunds
	 */
	public void update(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.update(financeProductFunds);
	}
	//
//	public int getCount(int id){
//		String sql="select count(*) from subject_purchase_record where subject_id="+id+"";
//		Session session=getSession();
//		String count=session.createSQLQuery(sql).uniqueResult().toString();
//		return Integer.valueOf(count);
//	}
	/**
	 * 
	 */
	public List listAll(int id){
		Session session=getSession();
		String hql=" from FinanceProductSubscribe w where w.financeProductFunds.id="+id;
		List list=session.createQuery(hql).list();
		return list;
	}
	/**
	 * 
	 */
	public FinanceProductSubscribe getFpsId(int id){
		Session session=getSession();
		FinanceProductSubscribe FinanceProductSubscribe=(FinanceProductSubscribe)session.get(FinanceProductSubscribe.class, id);
		return FinanceProductSubscribe;
	}
	/**
	 * 
	 */
	public void updateFps(FinanceProductSubscribe financeProductSubscribe){
		Session session=getSession();
		session.update(financeProductSubscribe);
	}
	/**
	 * 
	 */
	public List personList(int id){
		Session session=getSession();
		String hql="from FinanceProductSubscribe w where w.member.id="+id;
		List list=session.createQuery(hql).list();
		return list;
	}
	/**
	 * 
	 */
	public void personUpdate(FinanceProductSubscribe financeProductSubscribe){
		Session session=getSession();
		session.update(financeProductSubscribe);
	}
	
	
}
