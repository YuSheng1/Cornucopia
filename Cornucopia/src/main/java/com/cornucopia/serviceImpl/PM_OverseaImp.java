package com.cornucopia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.OverseaConfigSubscribe;
import com.cornucopia.dao.PM_Oversea_config;
import com.cornucopia.service.PM_OverService;

@Component
public class PM_OverseaImp implements PM_OverService {
	
	
	@Autowired
	private PM_Oversea_config overdao;
	
	@Override
	public  List listAllSub(OverseaConfigSubscribe overseaConfigSubscribe){
	      return overdao.listAllSub();
	}
	@Override
	public List ListAll(OverseaConfig overseaConfig) {
        return this.overdao.listAll();
	}
	@Override
	public List ListAlll(int id) {
        return this.overdao.listAlll(id);
	}
	@Override
	public void save(OverseaConfig overseaConfig) {
		this.overdao.save(overseaConfig);
	}
	@Override
	public void delete(OverseaConfig overseaConfig) {
       this.overdao.delete(overseaConfig);     
	}
	@Override
	public  void update(OverseaConfig overseaConfig) {
		 this.overdao.update(overseaConfig);
	}
	@Override
	public OverseaConfig getById(int id) {
		// TODO Auto-generated method stub
		return this.overdao.getById(id);
	}
	@Override
	public OverseaConfigSubscribe getByIdSub(int oversea_id) {
		// TODO Auto-generated method stub
		return this.getByIdSub(oversea_id);
	}
	

}
