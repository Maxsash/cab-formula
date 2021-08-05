/**
 * 
 */
package com.cabformula.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cabformula.bean.DriverBean;
import com.cabformula.util.JdbcFactory;

/**
 * @author Yash	
 *
 */
public class DriverDaoImpl implements DriverDao {

	@Override
	public List<DriverBean> fetchAll() throws SQLException {
		String sql = "select * from drivers";
		Connection conn = null;
		List<DriverBean> catalog = new ArrayList<DriverBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				DriverBean driver = new DriverBean();
				driver.setId(rs.getInt(1));
				driver.setName(rs.getString(2));
				driver.setAge(rs.getInt(3));
				driver.setExperience(rs.getInt(4));
				driver.setImage(rs.getString(5));
				driver.setCar_id(rs.getInt(6));
				driver.setContact(rs.getString(7));
				
				catalog.add(driver);
			}
			return catalog;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			conn.close();
		}
	}
	
	@Override
	public DriverBean fetchFromId(int driver_id) throws SQLException {
		String sql = "select * from drivers where driver_id=" + driver_id;
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			DriverBean driver = null;
			
			if(rs.next()) {
				driver = new DriverBean();
				driver.setId(rs.getInt(1));
				driver.setName(rs.getString(2));
				driver.setAge(rs.getInt(3));
				driver.setExperience(rs.getInt(4));
				driver.setImage(rs.getString(5));
				driver.setCar_id(rs.getInt(6));
				driver.setContact(rs.getString(7));
			}
			return driver;
		} finally {
			conn.close();
		}
	}

}
