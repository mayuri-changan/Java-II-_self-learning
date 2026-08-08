<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Book</h2>
	<form action="book" method="post">
		<input type="hidden" name="action" value="create"> Title: <input
			type="text" name="title"><br> Author: <input type="text"
			name="author"><br> Price: <input type="text"
			name="price"><br> <input type="submit" value="Save">
	</form>
	<a href="bookList.jsp">Back to Book List</a>
</body>
</html>