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
<form method="post" action="Review.cf">
<div class="form-group d-flex vertical-center justify-content-center p-5">
<div class="d-flex-md p-1 m-3 form-row main white-opaque">
<table>
<tr>
	<th>Your Booking ID</th>
	<td><input type="text" id="book_id" name="book_id" class="form-control" required></td>
</tr>
<tr>
	<th>Review </th>
	<td><input type="text" id="review" name="review" class="form-control" maxlength="400" required></td>
</table>
<input type="submit" class="btn btn-primary m-4" value="Submit Review">
</div>
</div>
</form>
</body>
</html>