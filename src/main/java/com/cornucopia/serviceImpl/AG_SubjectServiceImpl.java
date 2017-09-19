package com.cornucopia.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.FinanceProductFunds;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.Subject;
import com.cornucopia.dao.AG_SubjectDao;
import com.cornucopia.service.AG_SubjectService;

@Component
public class AG_SubjectServiceImpl implements AG_SubjectService {

	@Autowired
	private AG_SubjectDao AG_subjectDao;

	@Override
	public  List<Subject> ListAllS(String name) {
		List<Subject> slist=AG_subjectDao.ListAllS(name);
		return slist;
	}

	@Override
	public List<FinanceProductFunds> ListAllF(Objects... objects) {
		List<FinanceProductFunds> flist=AG_subjectDao.ListAllF();
		return flist;
	}

	@Override
	public  List<OverseaConfig> ListAllO(Objects... objects) {
		List<OverseaConfig> olist=AG_subjectDao.ListAllO();
		return olist;
	}

}
