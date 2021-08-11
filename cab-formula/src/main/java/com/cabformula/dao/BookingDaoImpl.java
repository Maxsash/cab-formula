/**
 * 
 */
package com.cabformula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cabformula.bean.BookingBean;
import com.cabformula.util.JdbcFactory;

/**
 * @author Yash
 * 
 */
public class BookingDaoImpl implements BookingDao {

	@Override
	public boolean persist(BookingBean booking) throws SQLException {
		String sql = "insert into bookings values (seq_bookings.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, booking.getSource());
			stmt.setString(2, booking.getDestination());
			System.out.println(booking.getBook_date());
			stmt.setString(3, booking.getBook_date());
			stmt.setString(4, booking.getTrip_date());
			stmt.setInt(5, booking.getDays());
			stmt.setInt(6, booking.getRound_trip());
			stmt.setString(7, booking.getStatus());
			stmt.setInt(8, booking.getCost());
			stmt.setString(9, booking.getName());
			stmt.setString(10, booking.getEmail());
			stmt.setString(11, booking.getGender());
			stmt.setInt(12, booking.getAge());
			stmt.setString(13, booking.getMobile());
			stmt.setInt(14, booking.getReviewed());
			stmt.setInt(15, booking.getCar_id());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}

	}

	@Override
	public BookingBean fetchFromId(int book_id) throws SQLException {
		String sql = "select * from bookings where book_id=" + book_id;
		Connection conn = null;
		BookingBean booking = null;
		
		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				booking = new BookingBean();
				booking.setId(rs.getInt(1));
				booking.setSource(rs.getString(2));
				booking.setDestination(rs.getString(3));
				booking.setBook_date(rs.getString(4));
				booking.setTrip_date(rs.getString(5));
				booking.setDays(rs.getInt(6));
				booking.setRound_trip(rs.getInt(7));
				booking.setStatus(rs.getString(8));
				booking.setCost(rs.getInt(9));
				booking.setName(rs.getString(10));
				booking.setEmail(rs.getString(11));
				booking.setGender(rs.getString(12));
				booking.setAge(rs.getInt(13));
				booking.setMobile(rs.getString(14));
				booking.setReviewed(rs.getInt(15));
				booking.setCar_id(rs.getInt(16));
			}
			return booking;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			conn.close();
		}
	}

}
