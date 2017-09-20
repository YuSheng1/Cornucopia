package com.cornucopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.Subject;
import com.cornucopia.service.AG_SubjectService;

@Controller
@RequestMapping("AGSub")
public class AG_SubjectController {

	@Autowired
	private AG_SubjectService AG_subjectServiceImpl;
	
	@RequestMapping("subject")
	public String showsubject(Model model,HttpServletRequest request,HttpServletResponse response){
		Map map=new HashMap();
		map=initMap(request, map);
		List<Subject>slist=AG_subjectServiceImpl.ListAllS(map);//查询所有
		model.addAttribute("slist",slist);
		return "Example";
	}
	
	public Map initMap(HttpServletRequest request,Map map){
		String type=request.getParameter("type");
		String year_rate=request.getParameter("year_rate");
		String period_start=request.getParameter("period_start");
		String period_end=request.getParameter("period_end");
		String status=request.getParameter("status");
		String flag=request.getParameter("flag");
		map.put("type",type);
		map.put("year_rate",year_rate);
		map.put("period_start",period_start);
		map.put("period_end",period_end);
		map.put("status",status);
		map.put("flag",flag);
		if(type!=null){
			request.setAttribute("type",type);
		}
		if(year_rate!=null){
			request.setAttribute("year_date",year_rate);
		}
		if(period_start!=null){
			request.setAttribute("period_start",period_start);
		}
		if(period_end!=null){
			request.setAttribute("period_end",period_end);
		}
		if(status!=null){
			request.setAttribute("status",status);
		}
		if(flag!=null){
			request.setAttribute("flag",flag);
		}
		return map;
	}   
	    @RequestMapping("/queryType")
	    public String queryType(int type,Model model,HttpServletRequest re){
	    	System.out.println(11111);
	    	String hql="from Subject where 0=0 and type like'%"+type+"%'";
	    	 List<Subject> slist=AG_subjectServiceImpl.query(hql);
			 model.addAttribute("slist",slist);
			 System.out.println(slist.size());
	    	return "Example";
	    }
	    
	    @RequestMapping("/queryYear_rate")
	    public String queryYear_rate(int year_rate,Model model){
	    	System.out.println(22222);
	    	System.out.println(year_rate);
	    	String hql="from Subject where 0=0 and year_rate like'%"+year_rate+"%'";
	    	List<Subject> slist=AG_subjectServiceImpl.query(hql);
			 model.addAttribute("slist",slist);
	    	return "Example";
	    }
	    
	    @RequestMapping("/queryStatus")
	    public String querystatus(int status,Model model){
	    	String hql="from Subject where 0=0 and status like'%"+status+"%'";
	    	List<Subject> slist=AG_subjectServiceImpl.query(hql);
			 model.addAttribute("slist",slist);
	    	return "Example";
	    }
	    @RequestMapping("/queryDays")
	    public String queryDays(int days,Model model){
	    	System.out.println(66666);
	    	String hql="from Subject where 0=0";
	    	if(days==1){
	    	 hql=hql+" and period<=15";
	    	}else if(days==2){
	          hql=hql+" and 30>period and period>=15";	
	    	}else if(days==3){
		          hql=hql+" and 180>period and period>=30";	
		    }else if(days==4){
		          hql=hql+" and 365>period and period>=180";	
		    }else if(days==5){
		          hql=hql+" and period>=365";	
		    	}
	    	List<Subject> slist=AG_subjectServiceImpl.query(hql);
			 model.addAttribute("slist",slist);
	    	return "Example";
	    }
	
	
	
	@RequestMapping("fund")
	public String fund(Model model){
		System.out.println("000");
		List<FinanceProductFunds> flist=AG_subjectServiceImpl.ListAllF();
		model.addAttribute("flist", flist);
		return "AGFund";
	}
	
	@RequestMapping("overseas")
	public String overseas(Model model){
		System.out.println("111");
		List<OverseaConfig> olist=AG_subjectServiceImpl.ListAllO();
		model.addAttribute("olist", olist);
		return "AGOverseas";
	}
}
