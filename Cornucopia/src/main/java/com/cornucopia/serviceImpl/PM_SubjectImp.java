package com.cornucopia.serviceImpl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Subject;
import com.cornucopia.dao.PM_Subjectdao;
import com.cornucopia.service.PM_SubjectService;
@Component
public class PM_SubjectImp implements PM_SubjectService {
	
	@Autowired
	private PM_Subjectdao  subject;

	@Override
	public  List SubList(Subject subject) {
		
		return this.subject.SubList();
	}

	@Override
	public void save(Object... objects) {
		this.subject.save(objects);
		
	}

	@Override
	public <T> Subject getById(int id) {
		// TODO Auto-generated method stub
		return this.subject.getById(id);
	}

	@Override
	public void update(Object object) {
		this.subject.update(object);
		
	}
	@Override
	public List proList(Map map) {
		// TODO Auto-generated method stub
		return this.subject.list(map);
	}

	@Override
	public float GetSubjectPurchaseRecordByidTiYan(int subjectId) {
		return  subject.GetSubjectPurchaseRecordByidTiYan(subjectId);
	}

	@Override
	public float GetSubjectPurchaseRecordByid(int subjectId) {
		return subject.GetSubjectPurchaseRecordByid(subjectId);
	}

	@Override
	public List listAllmen(int id) {	
		return subject.listAllmen(id);
	}
	
	
}
