package com.cornucopia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cornucopia.bean.Member;
import com.cornucopia.dao.PM_UserDaoImpl;
import com.cornucopia.dao.ValidateDao;
import com.cornucopia.service.ValidateService;
@Component
public class ValidateImpl implements ValidateService {
	
	@Autowired
	private PM_UserDaoImpl pM_UserDaoImpl;
	
	@Autowired
	private ValidateDao validateDao;
	@Override
	public Boolean getByPhone(String mobile_Phone) {
		boolean boo=pM_UserDaoImpl.getByPhone(mobile_Phone);
		return boo;
	}
	//判断用户密码是否正确
	@Override
	public Boolean UserLogin(String name, String password) {
		boolean boo=validateDao.UserLogin(name, password);
		return boo;
	}
	//根据用户名查询对象
	@Override
	public Member member(String name) {
		Member member=validateDao.memberLogin(name);
		return member;
	}
	//根据用户id查询金额
	@Override
	public com.cornucopia.bean.MemberAccount MemberAccount(int id) {
		com.cornucopia.bean.MemberAccount memberAccount=validateDao.getMemberAccount(id);
		return memberAccount;
	}
	

}
