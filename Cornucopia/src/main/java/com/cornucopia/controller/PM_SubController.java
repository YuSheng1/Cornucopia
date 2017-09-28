package com.cornucopia.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cornucopia.bean.Subject;
import com.cornucopia.service.PM_SubjectService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/BgSubject")
public class PM_SubController {
	
	@Resource
	private PM_SubjectService PM_SubjectImp;

	@RequestMapping("/list1")
	public String list1(Subject subject, Model model) {
		System.out.println("123s");
		List lists = PM_SubjectImp.SubList(subject);
		model.addAttribute("lists", lists);
		return "Bggu";
	}

	/**
	 * 查询所有固收类信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/list2")
	public String list2(Model model, Map map, String name, String type, String status) {
		map.put("name", name);
		map.put("type", type);
		map.put("status", status);
		List lists = PM_SubjectImp.proList(map);
		model.addAttribute("lists", lists);
		return "Bggu";
	}

	// * 计算总金额

	@RequestMapping("/getTotalMoney")
	@ResponseBody
	public float getTotalMoney(int id) {
		System.out.println("id:" + id);
		Subject sub = this.PM_SubjectImp.getById(id);
		float tiyanmoney = PM_SubjectImp.GetSubjectPurchaseRecordByidTiYan(sub.getId());
		System.out.println(tiyanmoney);
		float money = PM_SubjectImp.GetSubjectPurchaseRecordByid(sub.getId());
		System.out.println(money);
		return tiyanmoney + money;
	}

	@RequestMapping("togusave")
	public String togusave() {
		return "BgguSave";
	}

	@RequestMapping("/listAllmen")
	public String listAllmen(int id, Model model) {
		System.out.print(id);
		List listAll = PM_SubjectImp.listAllmen(id);
		model.addAttribute("listAll", listAll);
		return "Bggulist";

	}

	@RequestMapping("/save")
	public String save(Subject sub, String start_date1, String end_date1, String raise_start1, String end_start1,
			String create_date) {
		//// System.out.println("添加");
		// System.out.println(start_date1.toString());
		// System.out.println(sub.getCreate_date());
		// System.out.println(end_date1.toString());

		sub.setEnd_date(end_date1.toString());
		sub.setCreate_date(create_date);
		sub.setRaise_start(raise_start1.toString());
		sub.setStart_date(start_date1.toString());
		sub.setUpdate_date(start_date1.toString());
		sub.setRaise_end(end_start1.toString());
		PM_SubjectImp.save(sub);
		return "redirect:/BgSubject/list1";
	}

	@RequestMapping("/toupdate")
	public String toupdate(int id, Model model) {
		System.out.print("你的" + id);
		Subject subject = PM_SubjectImp.getById(id);
		model.addAttribute("sub", subject);
		return "Bggupdate";
	}

	@RequestMapping("/update")
	public String update(Subject subject, int wid,String update_date,String end_date,String raise_start,String start_date,
			String raise_end,String name,int type,String serial_no,String purpose,float floor_amount,int safeGuard_way,int year_rate,
			int exper_status,int status,int bought,String borrowername,float amount,String comment,
			String projectDetails,String safetyControl) {
		System.out.println("update");
		System.out.println(update_date);
		subject=PM_SubjectImp.getById(wid);
		subject.setUpdate_date(update_date);
		subject.setEnd_date(end_date.toString());
		subject.setRaise_start(raise_start.toString());
		subject.setExper_status(exper_status);
		subject.setStatus(status);
		subject.setBought(bought);
		subject.setBorrowerid(wid);
		subject.setAmount(amount);
		subject.setComment(comment);
		subject.setStart_date(start_date.toString());
		subject.setRaise_end(raise_end.toString());
		subject.setName(name);
		subject.setType(type);
		subject.setSerial_no(serial_no);
		subject.setPurpose(purpose);
		subject.setFloor_amount(floor_amount);
		subject.setSafeGuard_way(safeGuard_way);
		subject.setYear_rate(year_rate);
		subject.setProjectDetails(projectDetails);
		subject.setSafetyControl(safetyControl);
		PM_SubjectImp.update(subject);
		return "redirect:/BgSubject/list1";

	}
}
