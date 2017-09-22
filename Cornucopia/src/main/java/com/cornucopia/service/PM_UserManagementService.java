package com.cornucopia.service;

import java.util.List;

public interface PM_UserManagementService {
     public <T>List<T>  ListmemberList(String name,String mobile_Phone,String member_name,String invitationCode,String create_date);
}
