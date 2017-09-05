package com.shiro.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	private UserDao userDao;
//
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String userName=(String) principals.getPrimaryPrincipal();
//		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
//		authorizationInfo.setRoles((Set<String>) userDao.getRolesByUserName(userName));
//		authorizationInfo.setStringPermissions((Set<String>) userDao.getPersByUserName(userName));
//		System.out.println("12312");
//		return authorizationInfo;
//	}
//
//	/**
//	 * 
//	 * 楠岃瘉褰撳墠鐧诲綍鐨勭敤鎴�
//	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		String userName=(String) token.getPrincipal();
//		User user=userDao.getUserByUserName(userName);
//		if(user!=null){
//			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getName(), user.getPassword(), "xx");
//			return authcInfo;
//		}else{
//			return null;
//		}
//	}

}
