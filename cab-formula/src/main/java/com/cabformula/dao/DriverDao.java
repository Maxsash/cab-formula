package com.cabformula.dao;

import java.sql.SQLException;
import java.util.List;

import com.cabformula.bean.DriverBean;

public interface DriverDao {
	
	List<DriverBean> fetchAll() throws SQLException;

	DriverBean fetchFromId(int driver_id) throws SQLException;

}
