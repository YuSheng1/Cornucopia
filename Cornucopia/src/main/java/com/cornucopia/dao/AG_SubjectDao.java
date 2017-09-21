package com.cornucopia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.News;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.Subject;

@Component
public class AG_SubjectDao {

	@Autowired
	private SessionFactory sf; 
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public List<Subject> list(Map map) {
		String hql="from Subject where 0=0 ";
		hql=listDataHql(hql,map);
        Session session=getSession();
  	    List<Subject> slist=session.createQuery(hql).list();
		return slist;
	}

public String listDataHql(String hql, Map map) {
	 String year_rate=(String)map.get("year_rate");
	   String period_start=(String)map.get("period_start");
	   String period_end=(String)map.get("period_end");
	   String type=(String)map.get("type");
	   String status=(String)map.get("status");
	   String flag=(String)map.get("flag");
	   if(year_rate!=null&&!year_rate.equals("")){
		   if("0".equals(flag)){
			   hql+=" and year_rate="+Double.valueOf(year_rate);
		 }else if("1".equals(flag)){
			   hql+=" and year_rate>"+Double.valueOf(year_rate);  
		   }
	   }
	   if((period_start!=null&&!period_start.equals(""))&&(period_end!=null&&!period_end.equals(""))){
		      if(period_end.equals("-1")){
		    	  hql+=" and period >="+Integer.valueOf(period_start);
		      }else{
			    hql+=" and period between "+Integer.valueOf(period_start)+ " and "+Integer.valueOf(period_end);
		      }
	   }
	   if(status!=null&&!status.equals("")){
		    hql+=" and status="+Integer.valueOf(status);
	   }
	   return hql;
   }

public List<Subject> query(String hql) {
	 Session session=getSession();
	  List<Subject> slist=session.createQuery(hql).list();
	  return slist;
	  //
}
	
	
	public List<FinanceProductFunds> ListAllF(){
		Session session=getSession();
		String hql="from FinanceProductFunds";
		List<FinanceProductFunds> flist=session.createQuery(hql).list();
		return flist;
	}
	public FinanceProductFunds ListAllFById(int id){
		Session session=getSession();
		FinanceProductFunds financeProductFunds = (FinanceProductFunds) session.get(News.class, id);
		return financeProductFunds;
	}

	public List<OverseaConfig> ListAllO(){
		Session session=getSession();
		String hql="from OverseaConfig";
		List<OverseaConfig> olist=session.createQuery(hql).list();
		return olist;
	}

}
