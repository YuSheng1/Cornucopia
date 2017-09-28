package com.cornucopia.service;

import java.util.List;
import java.util.Map;

import com.cornucopia.bean.Subject;


public interface PM_SubjectService {
	//查询所有固收类
	    public <T> List<T> SubList(Subject subject);
		//添加
		public void save (Object...objects);
		//根据id查询内容
		public <T> Subject getById(int id);
		//修改
		public void update(Object object);
        //模糊查询
		public List proList(Map map);
		//体验金总金额
		public float GetSubjectPurchaseRecordByidTiYan(int subjectId);
		//标的总金额
		public float GetSubjectPurchaseRecordByid(int subjectId);
		
		public List listAllmen(int id);

}
