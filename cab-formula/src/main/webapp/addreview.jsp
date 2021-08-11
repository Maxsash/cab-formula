<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a review</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<% String driver_id = (String) request.getParameter("driverID"); %>

<form method="post" action="Review.cf">
<div class="form-group d-flex vertical-center justify-content-center p-5">
<div class="d-flex-md p-1 m-3 form-row main white-opaque">
<table>
<tr>
	<th><input type="hidden" value="<%=driver_id%>" name="driverID" id="driverID" class="form-control"><%=driver_id %></th>
</tr>
<tr>
	<th>Your Booking ID</th>
	<td><input type="text" id="book_id" name="book_id" class="form-control" required></td>
</tr>
<tr>
	<th>Review </th>
	<td><textarea name="review" id="review" class="form-control" maxlength="400" required></textarea></td>
</table>
<input type="submit" class="btn btn-primary m-4" value="Submit Review">
</div>
</div>
</form>
</body>
</html>