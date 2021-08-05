package com.cabformula.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cabformula.bean.ReviewBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

@WebServlet(name = "Review", urlPatterns = { "/Review.cf" })
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;
	private HttpSession session;
       
	@Override
	public void init() throws ServletException {
			service = new BookingServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		String referer = request.getHeader("referer");
		
		if(referer.contains("Driver")) {
			int driver_id = Integer.parseInt(request.getParameter("driverID"));
			List<ReviewBean> reviews = service.getReviewsFromId(driver_id);
			
			request.setAttribute("REVIEWS", reviews);
		
			request.getRequestDispatcher("review.jsp").forward(request, response);
		} else if(referer.contains("addreview")) {
			int driver_id = Integer.parseInt(request.getParameter("driverID"));
			ReviewBean review = new ReviewBean();
			review.setDriver_id(driver_id);
			review.setDate((LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))));
			review.setReview(request.getParameter("review"));
			review.setBook_id(Integer.parseInt(request.getParameter("book_id")));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
