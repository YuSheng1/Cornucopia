package com.shiro.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.cornucopia.bean.Users;
import com.cornucopia.service.PM_UserService;


public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private PM_UserService PM_UserRoleServiceImpl;
	@Resource
	private PM_UserService PM_UserServiceImpl;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String) principals.getPrimaryPrincipal();
		System.out.println(userName+"genju");
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles((Set<String>)PM_UserRoleServiceImpl.ListAllByName(userName));
		authorizationInfo.setStringPermissions((Set<String>)PM_UserRoleServiceImpl.ListResourcesByName(userName));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String) token.getPrincipal();
		Users user=PM_UserServiceImpl.getByName(userName);
		if(user.getUser_name()!=null){
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUser_name(), user.getPassword(), "xx");
			return authcInfo;
		}else{
			return null;
		}
	}

}
