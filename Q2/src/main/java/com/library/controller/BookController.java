package com.library.controller;

import java.io.IOException;

import com.library.model.Book;
import com.library.service.BookService;
import com.library.service.BookServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private BookService service = new BookServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("create".equals(action)) {
			Book b = new Book(0, request.getParameter("title"), request.getParameter("author"),
					Double.parseDouble(request.getParameter("price")));
			service.addBook(b);
		} else if ("update".equals(action)) {
			Book b = new Book(Integer.parseInt(request.getParameter("id")), request.getParameter("title"),
					request.getParameter("author"), Double.parseDouble(request.getParameter("price")));
			service.updateBook(b);
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			service.deleteBook(id);
		}
		response.sendRedirect("bookList.jsp");
	}
}
