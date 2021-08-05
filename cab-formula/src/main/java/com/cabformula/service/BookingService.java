/**
 * 
 */
package com.cabformula.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.cabformula.bean.BookingBean;
import com.cabformula.bean.CarBean;
import com.cabformula.bean.CityBean;
import com.cabformula.bean.DriverBean;
import com.cabformula.bean.ReviewBean;

/**
 * @author Yash
 * 
 */
public interface BookingService {
	
	boolean addBooking(BookingBean booking) throws SQLIntegrityConstraintViolationException;
	BookingBean getBookingFromId(int id);
	
	boolean addReview(ReviewBean review);
	List<ReviewBean> getReviewsFromId(int driver_id);
	
	List<CarBean> getCars();
	CarBean getCarFromId(int id);
	
	List<DriverBean> getDrivers();
	DriverBean getDriverFromId(int id);
	
	boolean sendEmail(BookingBean booking);
	
	List<CityBean> getCities();
	CityBean getCityFromName(String name);
	
	double distance(double lat1, double lon1, double lat2, double lon2); 
	
	double toRad(double value); 
}
