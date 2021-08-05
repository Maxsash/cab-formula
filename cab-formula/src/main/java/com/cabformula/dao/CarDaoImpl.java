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

import com.cabformula.bean.BookingBean;
import com.cabformula.bean.CarBean;
import com.cabformula.util.JdbcFactory;

/**
 * @author Yash
 *
 */
public class CarDaoImpl implements CarDao {

	@Override
	public List<CarBean> fetchAll() throws SQLException {
		String sql = "select * from cars";
		Connection conn = null;
		List<CarBean> catalog = new ArrayList<CarBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				CarBean car = new CarBean();
				car.setId(rs.getInt(1));
				car.setName(rs.getString(2));
				car.setYear(rs.getInt(3));
				car.setTotal_distance(rs.getInt(4));
				car.setDriver_id(rs.getInt(5));
				car.setManufacturer(rs.getString(6));
				car.setTop_speed(rs.getInt(7));
				car.setPassengers(rs.getInt(8));
				car.setImage(rs.getString(9));
				car.setCharge(rs.getInt(10));
				
				catalog.add(car);
			}
			return catalog;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} 
	}

	@Override
	public CarBean fetchFromId(int id) throws SQLException {
		String sql = "select * from cars where car_id=" + id;
		Connection conn = null;
		CarBean car = null;
		
		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				car = new CarBean();
				car.setId(rs.getInt(1));
				car.setName(rs.getString(2));
				car.setYear(rs.getInt(3));
				car.setTotal_distance(rs.getInt(4));
				car.setDriver_id(rs.getInt(5));
				car.setManufacturer(rs.getString(6));
				car.setTop_speed(rs.getInt(7));
				car.setPassengers(rs.getInt(8));
				car.setImage(rs.getString(9));
				car.setCharge(rs.getInt(10));
			}
			return car;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			conn.close();
		}
	}

}
