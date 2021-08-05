<%@page import="com.cabformula.bean.BookingBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="stylescripts/bootstrap.css">
<link rel="stylesheet" href="stylescripts/theme.css">
<title>Checkout</title>
</head>
<body>
<% BookingBean booking = (BookingBean) session.getAttribute("BOOKING"); %>
<% if(request.getParameter("carID") != null) 
	booking.setCar_id(Integer.parseInt(request.getParameter("carID"))); %>
<div class="vertical-center p-3 justify-content-start">
<div class="white-opaque p-5">
<p class="h1">Tell us about yourself!</p>

<form method="post" action="Booking.cf">
<div class="form-group">
<table>
<tr>
	<th>Full Name</th>
	<td><input type="text" id="name" name="name" class="form-control" required></td>
</tr>
<tr>
	<th>Email</th>
	<td><input type="email" id="email" name="email" class="form-control" required></td>
</tr>
<tr>
	<th>Gender</th>
	<th><div class="form-check">
  <input class="form-check-input" type="radio" name="gender" id="gender" value="male" required>
  <label class="form-check-label" for="gender">
  	Male
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="gender" id="gender" value="female" checked required>
  <label class="form-check-label" for="gender">
  	Female
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="gender" id="gender" value="others" required>
  <label class="form-check-label" for="gender">
  	Prefer Not to say
  	</label>
</div></th>
</tr>
<tr>
	<th>Age</th>
	<td><select name="age" class="form-control" required>
	<% for(int n=1;n<=120;n++) { %>
	<option value="<%= n %>"><%=n %></option>
	<% } %>
	</select>
	</td>
</tr>
<tr>
	<th>Mobile</th>
	<td><input type="text" id="mobile" name="mobile" class="form-control" pattern="[6-9]{1}[0-9]{9}" required></td>
</table>
<input type="submit" class="btn btn-primary mt-4" value="Proceed to Payment">
</div>
</form>
</div>
</div>
</body>
</html>