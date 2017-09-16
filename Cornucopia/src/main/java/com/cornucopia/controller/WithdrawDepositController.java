package com.cornucopia.controller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cornucopia.bean.CashFlowProcess;
import com.cornucopia.bean.CashFlowProcessVo;
import com.cornucopia.bean.MembeWithdrawRecord;
import com.cornucopia.bean.Member;
import com.cornucopia.bean.MemberAccount;
import com.cornucopia.bean.UserRole;
import com.cornucopia.service.AG_ProductService;
import com.cornucopia.service.ValidateService;

@Controller
@RequestMapping("Wi")
public class WithdrawDepositController {
	public int i=2;
	/**
	 * 获取默认流程引擎实例，会自动读取activiti.cfg.xml文件
	 */
	       
	    @Autowired  
	     private ProcessEngine processEngine;  
	     @Autowired  
	     protected RepositoryService repositoryService;  
	    @Autowired  
	     protected RuntimeService runtimeService;  
	     @Autowired  
	     protected TaskService taskService;  
	     @Autowired  
	     protected HistoryService historyService;  
	     @Autowired  
	     protected ManagementService managementService;  
	       
	     protected String deploymentId;  
	     @Resource
	 	private AG_ProductService AG_ProductServiceImpl;
	   //杂查询类
	 	@Resource
	 	private ValidateService validateImpl;
	
	/**
	 * 部署流程定义
	 */
	@RequestMapping("statu")
	public String BgRight(MembeWithdrawRecord membeWithdrawRecord,CashFlowProcess cashflowprocess,HttpSession session,String date) {
		System.out.println("123");
		Member member=(Member) session.getAttribute("member");
		//给表字段赋值
		membeWithdrawRecord.setStatus(0);
		membeWithdrawRecord.setChannel_name("支付宝提现");
		membeWithdrawRecord.setCreate_date(date);
		membeWithdrawRecord.setUpdate_date(date);
		membeWithdrawRecord.setDelFlag(0);
		membeWithdrawRecord.setMember(member);
		AG_ProductServiceImpl.saveMembeWithdrawRecord(membeWithdrawRecord);
		System.out.println("432");
				Deployment deployment=processEngine.getRepositoryService() // 获取部署相关Service
				.createDeployment() // 创建部署
				.addClasspathResource("diagrams/Withdraw.bpmn") // 加载资源文件
				.addClasspathResource("diagrams/Withdraw.png") // 加载资源文件
				.name("提现流程") // 流程名称
				.deploy(); // 部署
		System.out.println("流程部署ID:"+deployment.getId()); 
		System.out.println("流程部署Name:"+deployment.getName());
		ProcessInstance pi=processEngine.getRuntimeService() // 运行时Service
				.startProcessInstanceByKey("cashflowprocess"); // 流程定义表的KEY字段值
		cashflowprocess.setProcessInstanceId(Integer.parseInt(pi.getId()));
		System.out.println("流水号"+membeWithdrawRecord.getSerial_number());
		cashflowprocess.setSerialNumbe(membeWithdrawRecord.getSerial_number());
		cashflowprocess.setDeploymentId(deployment.getId());
		System.out.println(cashflowprocess.getDeploymentId()+"123*********8");
		AG_ProductServiceImpl.saveCashFlowProcess(cashflowprocess);
			System.out.println("流程实例ID:"+pi.getId());
			System.out.println("流程定义ID:"+pi.getProcessDefinitionId()); 
			return "redirect:/item/Contact";
	}
	/**
	 * 查看任务
	 */
	@RequestMapping("findTask")
	public String findTask(Model model,HttpSession session){
		String set=(String) session.getAttribute("url");
		List<Task> taskList=processEngine.getTaskService() // 任务相关Service
			.createTaskQuery() // 创建任务查询
			.taskAssignee(set) // 指定某个人
			.list();
		List list=new ArrayList<>();
		for(Task task:taskList){
			
			//根据流程实例id查询CashFlowProcess.java表数据
			CashFlowProcessVo cashFlowProcessVo =validateImpl.cashFlowProcessVo(Integer.parseInt(task.getProcessInstanceId()));
			cashFlowProcessVo.setRid(task.getId());//任务id
			list.add(cashFlowProcessVo);
		}
		model.addAttribute("cashFlowProcessVo", list);
		return "BgwithdrawDeposit";
	}
	
	/**
	 * 完成任务
	 */
	@RequestMapping("findRW")
	public String findRW(String rid,String roles,String mname,String serialNumbe,String money){
		processEngine.getTaskService() // 任务相关Service
			.complete(rid);//任务ID
		if(roles.equals("经理")){
			System.out.println("123");
			Member member=validateImpl.member(mname);
			MembeWithdrawRecord membeWithdrawRecord=AG_ProductServiceImpl.GetMembeWithdrawRecordByliushui(serialNumbe);
		     membeWithdrawRecord.setStatus(1);
		     membeWithdrawRecord.setMember(member);
		     MemberAccount memberAccount=validateImpl.MemberAccount(member.getId());
		     memberAccount.setUseable_balance((int)(memberAccount.getUseable_balance()-Float.parseFloat(money)));
		     memberAccount.setMember(member);
		     AG_ProductServiceImpl.saveMembeWithdrawRecord(membeWithdrawRecord);
		     AG_ProductServiceImpl.saveMemberAccount(memberAccount);
		}
		return "redirect:/Wi/findTask";
	}
	@RequestMapping("delete")
	public String deleteCascade(String rid,String roles,String mname,String serialNumbe,String money){
		  processEngine.getRepositoryService()
	        .deleteDeployment(rid, true); // 默认是false true就是级联删除
		Member member=validateImpl.member(mname);
		MembeWithdrawRecord membeWithdrawRecord=AG_ProductServiceImpl.GetMembeWithdrawRecordByliushui(serialNumbe);
	     membeWithdrawRecord.setStatus(3);
	     membeWithdrawRecord.setMember(member);
	     AG_ProductServiceImpl.saveMembeWithdrawRecord(membeWithdrawRecord);
	    System.out.println("驳回");
	    return "redirect:/Wi/findTask";
	}
	
	/**
	 * 查询流程状态（正在执行 or 已经执行结束）
	 */
	@Test
	public void processState(){
	    ProcessInstance pi=processEngine.getRuntimeService() // 获取运行时Service
	        .createProcessInstanceQuery() // 创建流程实例查询
	        .processInstanceId("45001") // 用流程实例ID查询  proc_inst
	        .singleResult();
	    if(pi!=null){
	        System.out.println("流程正在执行！");
	    }else{
	        System.out.println("流程已经执行结束！");
	    }
	}
	
	/**
	 * 历史任务查询
	 */
	@Test
	public void historyTaskList(){
	    List<HistoricTaskInstance> list=processEngine.getHistoryService() // 历史任务Service
	            .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
	            .taskAssignee("baolei") // 指定办理人
	            .finished() // 查询已经完成的任务  
	            .list();
	    for(HistoricTaskInstance hti:list){
	        System.out.println("任务ID:"+hti.getId());
	        System.out.println("流程实例ID:"+hti.getProcessInstanceId());
	        System.out.println("班里人："+hti.getAssignee());
	        System.out.println("创建时间："+hti.getCreateTime());
	        System.out.println("结束时间："+hti.getEndTime());
	        System.out.println("===========================");
	    }
	}
	/**
	 * 查询历史流程实例
	 */
	@Test
	public void getHistoryProcessInstance(){
	    HistoricProcessInstance hpi= processEngine.getHistoryService() // 历史任务Service
	        .createHistoricProcessInstanceQuery() // 创建历史流程实例查询
	        .processInstanceId("30001") // 指定流程实例ID
	        .singleResult();
	    System.out.println("流程实例ID:"+hpi.getId());
	    System.out.println("创建时间："+hpi.getStartTime());
	    System.out.println("结束时间："+hpi.getEndTime());
	}
}
	
