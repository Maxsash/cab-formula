package com.cabformula.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cabformula.bean.BookingBean;
import com.cabformula.bean.CarBean;
import com.cabformula.bean.CityBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

@WebServlet(name = "Init", urlPatterns = { "/Init.cf" })
public class InitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;
	
	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		BookingBean booking = new BookingBean();
		
		List<CarBean> cars = service.getCars();
		session.setAttribute("BOOKING", booking);
		session.setAttribute("CARS", cars);
		
		List<CityBean> cities = service.getCities();
		
		session.setAttribute("CITIES", cities);
		System.out.println(session.getId());
		
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
