<%@ page
	import="java.util.*,com.library.dao.BookDAO,com.library.model.Book"%>
<%
BookDAO dao = new BookDAO();
List<Book> books = dao.getAllBooks();
%>
<h2>Library Books</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
	</tr>
	<%
	for (Book b : books) {
	%>
	<tr>
		<td><%=b.getId()%></td>
		<td><%=b.getTitle()%></td>
		<td><%=b.getAuthor()%></td>
	</tr>
	<%
	}
	%>
</table>