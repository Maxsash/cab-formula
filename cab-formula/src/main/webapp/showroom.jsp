<%@page import="com.cabformula.bean.BookingBean"%>
<%@page import="com.cabformula.service.BookingServiceImpl"%>
<%@page import="com.cabformula.service.BookingService"%>
<%@page import="com.cabformula.bean.CarBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="stylescripts/bootstrap.css">
    <link rel="stylesheet" href="stylescripts/theme.css">

    <title>Showroom</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<% List<CarBean> cars = (List<CarBean>)session.getAttribute("CARS"); %>
<% BookingBean booking = (BookingBean) session.getAttribute("BOOKING"); %>
<% BookingService service = new BookingServiceImpl(); %>

<div class="card-deck">
<%= booking.getSource() %>
<% for(CarBean c : cars) { %>
  <div class="card">
    <img class="card-img" src="media/cars/<%= c.getImage() %>" alt="<%=c.getName()%>">
    <div class="card-body">
      <h5 class="card-title"><%=c.getName() %></h5><hr>
      <p class="card-text">
      <ul class="list-group list-group-flush">
      		<%if(service.getDriverFromId(c.getDriver_id()) != null) { %>
      		<li class="list-group-item">Driven By: <%=service.getDriverFromId(c.getDriver_id()).getName() %></li>
      		<% } %>
      		<li class="list-group-item">Manufactured By: <%=c.getManufacturer() %></li>
      		<li class="list-group-item">Year: <%=c.getYear() %></li>
      		<li class="list-group-item">Top Speed: <%=c.getTop_speed() %>kmph</li>
      		<li class="list-group-item">Odometer: <%=c.getTotal_distance() %>km</li>
      </ul>
    </div>
    <% if(booking.getSource() != null) { %>
    <div class="card-footer">
    <a href="Checkout.cf?carID=<%=c.getId()%>" class="link-dark">Book This Car!</a>
    </div>
    <% } %>
  </div>
<% } %>
</div>
</body>
</html>