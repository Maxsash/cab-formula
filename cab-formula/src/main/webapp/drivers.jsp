<%@page import="com.cabformula.service.BookingServiceImpl"%>
<%@page import="com.cabformula.service.BookingService"%>
<%@page import="com.cabformula.bean.DriverBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Drivers</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<% List<DriverBean> drivers = (List<DriverBean>) request.getAttribute("DRIVERS"); %>
<% BookingService service = new BookingServiceImpl(); %>

<div class="card-deck">
<% for(DriverBean d : drivers) { %>
<div class="card" style="max-width: 45rem;">
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src="media/drivers/<%= d.getImage() %>" class="card-img" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title"><%= d.getName() %></h5>
        <p class="card-text">
		<ul class="list-group list-group-flush">
      		<!-- <li class="list-group-item">Driven By: //service.getDriverFromId(c.getDriver_id()).getName()</li>-->
      		<li class="list-group-item">Age: <%=d.getAge() %></li>
      		<li class="list-group-item">Experience: <%=d.getExperience() %>kmph</li>
      </ul>
        </p>
        <div class="card-footer">
        <a href="Review.cf?driverID=<%=d.getId()%>" class="link-dark">Reviews</a>
        <form method="post" action="addreview.jsp?driverID=<%=d.getId() %>">
        <input type="submit" class="btn btn-outline-dark ml-2" value="Add Review">
        </form>
        </div>
      </div>
    </div>
  </div>
</div>
<% } %>
</div>

</body>
</html>