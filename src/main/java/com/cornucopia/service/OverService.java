package com.cornucopia.service;

import java.util.List;

import com.cornucopia.bean.OverseaConfig;
import com.cornucopia.bean.OverseaConfigSubscribe;

public interface OverService {

	public <T>List<T> listAllSub(OverseaConfigSubscribe overseaConfigSubscribe) ;
	public void save (OverseaConfig overseaConfig);
	public void delete(OverseaConfig overseaConfig);
	public void update(OverseaConfig overseaConfig);
	public OverseaConfig getById(int id);
	public OverseaConfigSubscribe getByIdSub(int oversea_id);
	public List ListAll(OverseaConfig overseaConfig);

	
}
