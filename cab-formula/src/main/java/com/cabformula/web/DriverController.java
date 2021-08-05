package com.cabformula.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cabformula.bean.DriverBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

@WebServlet(name = "Driver", urlPatterns = { "/Driver.cf" })
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;
       
	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DriverBean> drivers = service.getDrivers();
		
		request.setAttribute("DRIVERS", drivers);
		
		request.getRequestDispatcher("drivers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
