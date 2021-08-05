/**
 * 
 */
package com.cabformula.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cabformula.bean.CityBean;
import com.cabformula.util.JdbcFactory;

/**
 * @author Yash
 *
 */
public class CItyDaoImpl implements CityDao {

	@Override
	public List<CityBean> fetchAll() throws SQLException {
		String sql = "select * from cities";
		Connection conn = null;
		List<CityBean> catalog = new ArrayList<CityBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				CityBean city = new CityBean();
				city.setId(rs.getInt(1));
				city.setName(rs.getString(2));
				city.setLatitude(rs.getDouble(3));
				city.setLongitude(rs.getDouble(4));
				city.setState_id(rs.getInt(5));
				
				catalog.add(city);
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
	public CityBean fetchFromName(String name) throws SQLException {
		String sql = "select * from cities where city_name='" +name +"'";
		Connection conn = null;
		CityBean city = null;
		
		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				city = new CityBean();
				city.setId(rs.getInt(1));
				city.setName(rs.getString(2));
				city.setLatitude(rs.getDouble(3));
				city.setLongitude(rs.getDouble(4));
				city.setState_id(rs.getInt(5));
			}
			return city;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			conn.close();
		}
	}

}
