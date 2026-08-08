<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Student</h2>
	<form action="student" method="post">
		<input type="hidden" name="action" value="create"> Name: <input
			type="text" name="name"><br> Email: <input type="text"
			name="email"><br> <input type="submit" value="Save">
	</form>
</body>
</html>