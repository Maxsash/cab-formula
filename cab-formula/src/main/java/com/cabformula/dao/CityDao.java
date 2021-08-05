package com.cabformula.dao;

import java.sql.SQLException;
import java.util.List;

import com.cabformula.bean.CityBean;

public interface CityDao {
	
	List<CityBean> fetchAll() throws SQLException;
	
	CityBean fetchFromName(String name) throws SQLException;
	
}
