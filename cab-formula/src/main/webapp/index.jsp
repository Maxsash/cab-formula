<%@page import="com.cabformula.bean.CityBean"%>
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

    <title>Premium Cab Booking</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<% List<CityBean> cities = (List<CityBean>) session.getAttribute("CITIES");%>

<form method="post" action="Booking.cf">
<div class="vertical-center d-flex justify-content-end pb-5">
<div class="d-flex-md p-1form-row main white-opaque">
    <div class="col-xs form-group px-5">
        <label for="inputFrom" class="h3">Pick up from</label>
        <select id="inputFrom" name="fromCity" class="form-control">
        	<% for (CityBean c: cities) { %>
        		<option value="<%= c.getName()%>"><%= c.getName()%> </option>
        	<% } %>
        </select>
    </div>
    <div class="col-xs form-group px-5">
        <label for="inputTo" class="h3">Drop off at</label>
        <select id="inputTo" name="toCity" class="form-control">
        	<%for (CityBean c: cities) { %>
            <option value="<%= c.getName()%>"><%= c.getName()%></option>
            <% } %>
        </select>
    </div>
</div>
<div class="d-flex-md pt-2 ml-3 form-row main white-opaque">
    <div class="col-xs form-group px-5 h5">
    <label for="fromDate">Pick up on:</label>
		<input type="date" id="fromDate" name="fromDate">
	</div>
	<div class="col-xs form-group px-5 h5">
	<label for="toDate">Drop off on:</label>
		<input type="date" id="toDate" name="toDate">
	</div>

	<div class="col-xs form-check">
  	<input class="form-check-input" type="checkbox" value="1" name="round_trip" id="round_trip">
  		<label class="form-check-label h5 pr-2" for="round_trip">
  		Round Trip
  		</label>
	</div>
</div>

<input type="submit" class="btn btn-outline-light ml-3" value="Select Car">

</div>
</form>

</body>
</html>