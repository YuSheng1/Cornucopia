package com.cornucopia.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.FinanceProductSubscribe;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.service.PM_FinalService;
import com.cornucopia.service.ValidateService;

@Controller
@RequestMapping("/finance")
public class PM_Finance_product_fundsHouController {
	
	
	@Resource
	private PM_FinalService PM_FinaImpl;
	@Resource
	private ValidateService validateImpl;

	@RequestMapping("/listFunds")
	public String listFunds(FinanceProductFunds financeProductFunds,Model model){	 
		 List list=PM_FinaImpl.FundList(financeProductFunds);
	     model.addAttribute("list",list);
		 return "BgImgTable";
	}
	@RequestMapping("/tosave")
	public String tosave(){
		return "BgStosave";
	}
	
	
	@RequestMapping("/saveFinance_product_funds")
	public String saveFinance_product_funds(FinanceProductFunds FinanceProductFunds,String create_date){
//		Date date=new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time=df.format(new Date());
//		FinanceProductFunds.setCreate_date(time);
		FinanceProductFunds.setCreate_date(create_date);
		this.PM_FinaImpl.save(FinanceProductFunds);
		return "redirect:/finance/listFunds";
	}
	/**
	 *
	 * 
	 *條件查詢
	 */
	@RequestMapping("/listll")
	public String listll(Model model, Map map, String name, String type, String status) {
		map.put("name", name);
		map.put("type", type);
		map.put("status", status);
		List list= PM_FinaImpl.proList(map);
		model.addAttribute("list", list);
		return "BgImgTable";
	}

	
	
//	@RequestMapping("/finance_product_fundsList")
//	public String list(Model model,Map map,String name,String type,String status,PageSubjectHouBean pagebean,String flag,String page){
//		map.put("name", name);
//		map.put("type", type);
//		//System.out.println(type);
//		map.put("status", status);
//		//System.out.println("qing");
//		//System.out.println("ddddddddddddd"+flag);
//		 int count=finance_product_fundsHouService.getCountOver(map);
//		 pagebean.setTotal(count);      //������
//		// System.out.println("page-----------"+page);
//		// System.out.println("flag-----------"+flag);
//		    if(page==null){
//		    	pagebean.setPage(1);
//		    }else{
//		    	pagebean.setPage(Integer.valueOf(page));
//		    }
//		    if(flag!=null){
//		    	if(flag.equals("up")){
//		    		if(pagebean.getPage()==1){
//		    			pagebean.setPage(1);
//		    		}
//		    		else{
////		    			pagebean.setPage(pagebean.getPage()-1);
//		    		}
//		    	}
//		    	if(flag.equals("down")){
//		    		if(pagebean.getPage()>=pagebean.getTotalpage()){
//		    			pagebean.setPage(pagebean.getPage());
//		    		}
//		    		else{
//		    			pagebean.setPage(pagebean.getPage()+1);
//		    		}
//		    	}
//		    	if(flag.equals("first")){
//		    		pagebean.setPage(1);
//		    	}
//		    	if(flag.equals("last")){
//		    		pagebean.setPage(pagebean.getTotalpage());
//		    	}
//		    }
//		List list=finance_product_fundsHouService.list(map,pagebean);
//		model.addAttribute("list",list);
//		return "finance_product_fundsList";
//	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(int id,Model model){
		FinanceProductFunds FinanceProductFunds=PM_FinaImpl.getByIdFun(id);
		model.addAttribute("financeProductFunds",FinanceProductFunds);
		return "BgSiUp";
	}
	/**
	 * 
    private int id;//主键
	private String type;//产品类型
	private String name;//名称
	private int status;//状态(0:未发布，1:募集中，2:已结束)
	private int period;//周期
	private int floor_amount;//起投金额
	private int year_rate;//年化率
	private int subscribe_count;//预约人数
	private String product_topic;//基金专题/关于基金
	private String product_factor;//产品要素
	private String product_strategy;//产品策略
	private String product_manager;//基金经理详细
	private String create_date;//创建时间
	private String update_date;//修改时间
	private String product_manager_name;//管理人名称
	private String product_manager_pic;//管理人图片
	private String product_manager_title;//管理人头衔
	private String product_manager_desc;//产品管理人介绍
	private String invest_points;//投资方向
	private int amount;//募集金额
	private int sold_amount;//已售金额
	private int buyer_count;//购买人数
	private String start_date;//开始时间
	private String end_date;//结束时间
	private String ratio;//返佣比例
	private String contract;//私募合同
	private String bank_account;//银行账户（支行名称|银行账号|户名）
	 * 
	 * @param subject
	 * @return
	 */
	@RequestMapping("/update")
	public String update(FinanceProductFunds financeProductFunds,String name,int wid,String type,int floor_amount,
		int year_rate,String start_date,String end_date	,int status	,String invest_points,String update_date,
		int period,String product_topic,String product_factor,String product_manager_name, String product_manager_title,
		String product_manager,String product_manager_pic,String bank_account){
		financeProductFunds=PM_FinaImpl.getByIdFun(wid);
		System.out.println(PM_FinaImpl.getByIdFun(wid));
		System.out.println(name);
		financeProductFunds.setName(name);
		financeProductFunds.setType(type);
		financeProductFunds.setFloor_amount(floor_amount);
		financeProductFunds.setYear_rate(year_rate);
		financeProductFunds.setStart_date(start_date);
		financeProductFunds.setEnd_date(end_date);
		financeProductFunds.setStatus(status);
		financeProductFunds.setInvest_points(invest_points);
		financeProductFunds.setUpdate_date(update_date);
		financeProductFunds.setPeriod(period);
		financeProductFunds.setProduct_topic(product_topic);
		financeProductFunds.setProduct_factor(product_factor);
		financeProductFunds.setProduct_manager_name(product_manager_name);
		financeProductFunds.setProduct_manager_title(product_manager_title);
		financeProductFunds.setProduct_manager(product_manager_pic);
		financeProductFunds.setProduct_manager(product_manager);
		financeProductFunds.setProduct_manager_pic(product_manager_pic);
		financeProductFunds.setBank_account(bank_account);
		this.PM_FinaImpl.update(financeProductFunds);
		return "redirect:/finance/listFunds";
		}
	/**
	 *签署情况表
	 */
	int did=0;
	@RequestMapping("/fpsList")
	public String fpsList(int id,Model model){
		List list=PM_FinaImpl.listAll(id);
		model.addAttribute("seeList", list);
		did=id;
		return "BgSulist";
	}
	/**
	 * 
	 * 
	 * 
	 */
	@RequestMapping("/fpsListFalse/{id}")
	public String fpsListFalse(@PathVariable("id")int id,Model model){
		System.out.println("123");
		System.out.println(id);
		FinanceProductSubscribe financeProductSubscribe=PM_FinaImpl.getByIdSub(id);
		financeProductSubscribe.setStatus(3);
		PM_FinaImpl.updateFps(financeProductSubscribe);
		List list=PM_FinaImpl.listAll(did);
		model.addAttribute("seeList", list);
		return "BgSulist";
	}	
	/**
	 * 
	 */
	@RequestMapping("/toListTrue")
	public String toListTrue(int id,Model model){
		FinanceProductSubscribe financeProductSubscribe =PM_FinaImpl.getByIdSub(id);
		financeProductSubscribe.setStatus(1);		
		PM_FinaImpl.updateFps(financeProductSubscribe);
		System.out.println("id:"+id);
	    System.out.println("did:"+did);
		model.addAttribute("sub", financeProductSubscribe);
		return "Bgqisu"; 
	}	

    @RequestMapping("/updatesub")
	public String updatesub(FinanceProductSubscribe subscribe,String update_date,int sid,int amount,
			int interest,String start_date,String end_date ){
    	subscribe=PM_FinaImpl.getByIdSub(sid);		
    	System.out.println(subscribe.getMember().getId()+"*******");
		subscribe.setCreate_date(update_date);
		subscribe.setAmount(amount);
		subscribe.setUpdate_date(update_date);
		subscribe.setEnd_date(end_date);
		subscribe.setInterest(interest);
		subscribe.setStart_date(start_date);
		PM_FinaImpl.personUpdate(subscribe);
		return "redirect:/finance/listFunds";
	}
    
    
	
}
