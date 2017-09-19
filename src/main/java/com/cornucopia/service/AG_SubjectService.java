package com.cornucopia.service;

import java.util.List;
import java.util.Objects;

import com.cornucopia.bean.OverseaConfig;

public interface AG_SubjectService {

	public <T>List<T> ListAllS(String name);
	public <T>List<T> ListAllF(Objects...objects);
	public <T>List<T> ListAllO(Objects...objects);
}
