package com.cabformula.dao;

import java.sql.SQLException;

import com.cabformula.bean.BookingBean;

public interface BookingDao {
	
	boolean persist(BookingBean booking) throws SQLException;
	
	BookingBean fetchFromId(int book_id) throws SQLException;
}
