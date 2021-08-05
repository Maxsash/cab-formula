package com.cabformula.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cabformula.bean.CarBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

@WebServlet(name = "Car", urlPatterns = { "/Car.cf" })
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;
       

	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String referer = request.getHeader("referer");
		
		if(referer.contains("Booking")) {
			request.getRequestDispatcher("showroom.jsp?selectCar=true").forward(request, response);
		}
		request.getRequestDispatcher("showroom.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
