<%@ page
	import="java.util.*,com.demo.service.StudentService,com.demo.service.StudentServiceImpl,com.demo.model.Student"%>
<%
StudentService service = new StudentServiceImpl();
List<Student> students = service.getAll();
%>
<h2>Student List</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Actions</th>
	</tr>
	<%
	for (Student s : students) {
	%>
	<tr>
		<td><%=s.getId()%></td>
		<td><%=s.getName()%></td>
		<td><%=s.getEmail()%></td>
		<td>
			<!-- Update Form -->
			<form action="student" method="post" style="display: inline;">
				<input type="hidden" name="action" value="update"> <input
					type="hidden" name="id" value="<%=s.getId()%>"> Name: <input
					type="text" name="name" value="<%=s.getName()%>"> Email: <input
					type="text" name="email" value="<%=s.getEmail()%>"> <input
					type="submit" value="Update">
			</form> <!-- Delete Form -->
			<form action="student" method="post" style="display: inline;">
				<input type="hidden" name="action" value="delete"> <input
					type="hidden" name="id" value="<%=s.getId()%>"> <input
					type="submit" value="Delete">
			</form>
		</td>
	</tr>
	<%
	}
	%>
</table>
<a href="studentForm.jsp">Add New Student</a>