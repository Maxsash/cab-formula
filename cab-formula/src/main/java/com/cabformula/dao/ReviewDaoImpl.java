/**
 * 
 */
package com.cabformula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cabformula.bean.ReviewBean;
import com.cabformula.util.JdbcFactory;

/**
 * @author there
 *
 */
public class ReviewDaoImpl implements ReviewDao {

	@Override
	public boolean persist(ReviewBean review) throws SQLException {
		String sql = "insert into reviews values (seq_reviews.nextval,?,?,?,?)";
		Connection conn = null;
		
		conn = JdbcFactory.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, review.getBook_id());
		stmt.setInt(2, review.getDriver_id());
		stmt.setString(3, review.getReview());
		stmt.setString(4, review.getDate());
		
		stmt.executeUpdate();
		return true;
	}

	@Override
	public List<ReviewBean> fetchAll() throws SQLException {
		String sql = "select * from reviews";
		Connection conn = null;
		List<ReviewBean> catalog = new ArrayList<ReviewBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				ReviewBean review = new ReviewBean();
				review.setId(rs.getInt(1));
				review.setBook_id(rs.getInt(2));
				review.setDriver_id(rs.getInt(3));
				review.setReview(rs.getString(4));
				review.setDate(rs.getString(5));
				
				catalog.add(review);
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
	public List<ReviewBean> fetchDriverReviews(int driver_id) throws SQLException {
		String sql = "select * from reviews where driver_id=" + driver_id;
		Connection conn = null;
		List<ReviewBean> catalog = new ArrayList<ReviewBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				ReviewBean review = new ReviewBean();
				review.setId(rs.getInt(1));
				review.setBook_id(rs.getInt(2));
				review.setDriver_id(rs.getInt(3));
				review.setReview(rs.getString(4));
				review.setDate(rs.getString(5));
				
				catalog.add(review);
			}
			return catalog;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			conn.close();
		}
	}

}
