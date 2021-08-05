package com.cabformula.dao;

import java.sql.SQLException;
import java.util.List;

import com.cabformula.bean.ReviewBean;

public interface ReviewDao {
	
	boolean persist(ReviewBean review) throws SQLException;
	
	List<ReviewBean> fetchAll() throws SQLException;
	
	List<ReviewBean> fetchDriverReviews(int driver_id) throws SQLException;

}
