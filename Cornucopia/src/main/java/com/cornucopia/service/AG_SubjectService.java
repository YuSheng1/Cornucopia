package com.cornucopia.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.Subject;

public interface AG_SubjectService {

	public <T>List<T> ListAllS(Map map);

	public String listDataHql(String hql, Map map);

	public List<Subject> query(String hql);
	public <T>List<T> ListAllF(Objects...objects);
	public <T>List<T> ListAllO(Objects...objects);
	public FinanceProductFunds ListAllFById(int id);
	
}
