package com.cabformula.web;

import java.io.IOException;

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

@WebServlet(name = "Checkout", urlPatterns = { "/Checkout.cf" })
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;
       
	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookingBean booking = (BookingBean) session.getAttribute("BOOKING");
		
		if(request.getParameter("carID") != null) {
			booking.setCar_id(Integer.parseInt(request.getParameter("carID")));
			
			CarBean car = service.getCarFromId(booking.getCar_id());
			int charge = car.getCharge();
			
			System.out.println(booking.getSource() + booking.getDestination());
			double lat1 = service.getCityFromName(booking.getSource()).getLatitude();
			double lon1 = service.getCityFromName(booking.getSource()).getLongitude();
			 
			double lat2 = service.getCityFromName(booking.getDestination()).getLatitude();
			double lon2 = service.getCityFromName(booking.getDestination()).getLongitude();
			 
			double distance = service.distance(lat1,lon1,lat2,lon2);
			
			int cost = (int) Math.round(booking.getDays()*charge + distance*100);
			
			booking.setCost(cost);
			
			session.setAttribute("BOOKING", booking);

			request.setAttribute("CAR", car);

			response.sendRedirect("checkout.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
