package com.cornucopia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.dao.UserDaoImpl;
import com.cornucopia.service.ValidateService;
@Component
public class ValidateImpl implements ValidateService {
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Override
	public Boolean getByPhone(String mobile_Phone) {
		boolean boo=userDaoImpl.getByPhone(mobile_Phone);
		return boo;
	}

}
