<%@ page session="true"%>
<%
String user = (String) session.getAttribute("username");
if (user == null) {
	response.sendRedirect("login.jsp");
}
%>
<h2>
	Welcome,
	<%=user%>! Book your ticket
</h2>
<form action="reserve" method="post">
	Passenger Name: <input type="text" name="pname"><br>
	Flight No: <input type="text" name="fno"><br> Source: <input
		type="text" name="src"><br> Destination: <input
		type="text" name="dest"><br> Date of Journey: <input
		type="date" name="doj"><br> <input type="submit"
		value="Book Ticket">
</form>

<a href="logout">Logout</a>
