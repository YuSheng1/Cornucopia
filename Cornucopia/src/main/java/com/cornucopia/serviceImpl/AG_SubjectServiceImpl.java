package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Subject;
import com.cornucopia.dao.AG_SubjectDao;
import com.cornucopia.service.AG_SubjectService;

@Component
public class AG_SubjectServiceImpl implements AG_SubjectService {

	@Autowired
	private AG_SubjectDao AG_subjectDao;

	@Override
	public  List<Subject> ListAll(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
