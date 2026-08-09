<%@ page import="java.util.*,com.mvc.model.Student"%>
<%
List<Student> students = (List<Student>) request.getAttribute("students");
%>
<h2>All Students</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Course</th>
		<th>Marks</th>
	</tr>
	<%
	for (Student s : students) {
	%>
	<tr>
		<td><%=s.getId()%></td>
		<td><%=s.getName()%></td>
		<td><%=s.getCourse()%></td>
		<td><%=s.getMarks()%></td>
	</tr>
	<%
	}
	%>
</table>