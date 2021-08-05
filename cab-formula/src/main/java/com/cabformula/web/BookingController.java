package com.cabformula.web;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cabformula.bean.BookingBean;
import com.cabformula.bean.CarBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

@WebServlet(name = "Booking", urlPatterns = { "/Booking.cf" })
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;
	private HttpSession session;
       
	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		System.out.println("session" + session.getId());
		List<CarBean> cars = service.getCars();
		request.setAttribute("CARS", cars);
		
		String referer = request.getHeader("referer");
		
		if(referer.contains("index")) {
			BookingBean booking = (BookingBean) session.getAttribute("BOOKING");
			 booking.setSource(request.getParameter("fromCity"));
			 booking.setDestination(request.getParameter("toCity"));
			 booking.setTrip_date(request.getParameter("fromDate"));
			 booking.setDays((int) ChronoUnit.DAYS.between(LocalDate.parse(request.getParameter("fromDate")), LocalDate.parse(request.getParameter("toDate"))));
			 booking.setBook_date((LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
			 if(request.getParameter("round_trip") != null)
				 booking.setRound_trip(Integer.parseInt(request.getParameter("round_trip")));
			 else
				 booking.setRound_trip(0);
			 
			 
			 session.setAttribute("BOOKING", booking);
			 request.getRequestDispatcher("Car.cf").forward(request, response);

		} else if(referer.contains("checkout")) {
			BookingBean booking = (BookingBean) session.getAttribute("BOOKING");
			booking.setName(request.getParameter("name"));
			booking.setEmail(request.getParameter("email"));
			booking.setGender(request.getParameter("gender"));
			booking.setAge(Integer.parseInt(request.getParameter("age")));
			booking.setMobile(request.getParameter("mobile"));
			booking.setReviewed(0);
			
			try {
				service.addBooking(booking);
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
			}
			
			session.invalidate();
			request.setAttribute("COST", booking.getCost());
			request.getRequestDispatcher("payment.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
