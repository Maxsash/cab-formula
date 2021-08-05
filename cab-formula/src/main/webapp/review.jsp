<%@page import="com.cabformula.service.BookingServiceImpl"%>
<%@page import="com.cabformula.service.BookingService"%>
<%@page import="com.cabformula.bean.ReviewBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reviews</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<% List<ReviewBean> reviews = (List<ReviewBean>) request.getAttribute("REVIEWS"); %>
<% BookingService service = new BookingServiceImpl(); %>

<div class="card-deck">
<% for(ReviewBean r : reviews) { %>
<div class="card" style="max-width: 45rem;">
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Review</h5>
        <p class="card-text">
        <%= r.getReview() %>
        </p>
        </div>
      </div>
    </div>
<% } %>
</div>
</body>
</html>