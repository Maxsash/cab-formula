package com.cabformula.dao;

import java.sql.SQLException;
import java.util.List;

import com.cabformula.bean.CarBean;

public interface CarDao {
	
	List<CarBean> fetchAll() throws SQLException;
	
	CarBean fetchFromId(int id) throws SQLException;

}
