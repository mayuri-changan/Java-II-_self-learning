<%@ page
	import="java.util.*,com.library.service.BookService,com.library.service.BookServiceImpl,com.library.model.Book"%>
<%
BookService service = new BookServiceImpl();
List<Book> books = service.getAll();
%>
<h2>Library Books</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Price</th>
		<th>Actions</th>
	</tr>
	<%
	for (Book b : books) {
	%>
	<tr>
		<td><%=b.getId()%></td>
		<td><%=b.getTitle()%></td>
		<td><%=b.getAuthor()%></td>
		<td><%=b.getPrice()%></td>
		<td>
			<!-- Update Form -->
			<form action="book" method="post" style="display: inline;">
				<input type="hidden" name="action" value="update"> <input
					type="hidden" name="id" value="<%=b.getId()%>"> Title: <input
					type="text" name="title" value="<%=b.getTitle()%>"> Author:
				<input type="text" name="author" value="<%=b.getAuthor()%>">
				Price: <input type="text" name="price" value="<%=b.getPrice()%>">
				<input type="submit" value="Update">
			</form> <!-- Delete Form -->
			<form action="book" method="post" style="display: inline;">
				<input type="hidden" name="action" value="delete"> <input
					type="hidden" name="id" value="<%=b.getId()%>"> <input
					type="submit" value="Delete">
			</form>
		</td>
	</tr>
	<%
	}
	%>
</table>
<a href="bookForm.jsp">Add New Book</a>
