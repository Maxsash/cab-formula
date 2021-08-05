/**
 * 
 */
package com.cabformula.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.cabformula.bean.BookingBean;
import com.cabformula.bean.CarBean;
import com.cabformula.bean.CityBean;
import com.cabformula.bean.DriverBean;
import com.cabformula.bean.ReviewBean;
import com.cabformula.dao.BookingDao;
import com.cabformula.dao.BookingDaoImpl;
import com.cabformula.dao.CItyDaoImpl;
import com.cabformula.dao.CarDao;
import com.cabformula.dao.CarDaoImpl;
import com.cabformula.dao.CityDao;
import com.cabformula.dao.DriverDao;
import com.cabformula.dao.DriverDaoImpl;
import com.cabformula.dao.ReviewDao;
import com.cabformula.dao.ReviewDaoImpl;

/**
 * @author Yash
 *
 */
public class BookingServiceImpl implements BookingService {
	private BookingDao booking_dao;
	private ReviewDao review_dao;
	private CarDao car_dao;
	private DriverDao driver_dao;
	private CityDao city_dao;
	
	public BookingServiceImpl() {
		booking_dao = new BookingDaoImpl();
		review_dao = new ReviewDaoImpl();
		car_dao = new CarDaoImpl();
		driver_dao = new DriverDaoImpl();
		city_dao = new CItyDaoImpl();
	}

	@Override
	public boolean addBooking(BookingBean booking) throws SQLIntegrityConstraintViolationException {
		if(booking.getSource() == null)
			throw new SQLIntegrityConstraintViolationException("Booking is not populated");
		try {
			return booking_dao.persist(booking);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public BookingBean getBookingFromId(int id) {
		try {
			return booking_dao.fetchFromId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addReview(ReviewBean review) {
		try {
			return review_dao.persist(review);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReviewBean> getReviewsFromId(int driver_id) {
		try {
			return review_dao.fetchDriverReviews(driver_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CarBean> getCars() {
		try {
			return car_dao.fetchAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DriverBean> getDrivers() {
		try {
			return driver_dao.fetchAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public DriverBean getDriverFromId(int driver_id) {
		try {
			return driver_dao.fetchFromId(driver_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean sendEmail(BookingBean booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CityBean> getCities() {
		try {
			return city_dao.fetchAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CarBean getCarFromId(int id) {
		try {
			return car_dao.fetchFromId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CityBean getCityFromName(String name) {
		try {
			return city_dao.fetchFromName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public double distance(double lat1, double lon1, double lat2, double lon2) {
		final int R = 6371; // Radius of the earth
		Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
                   Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance;
	}
	
	public double toRad(double value) {
		return value * Math.PI / 180;
	}

}
