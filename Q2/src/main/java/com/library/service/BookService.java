package com.library.service;

import java.util.List;

import com.library.model.Book;

public interface BookService {
	boolean addBook(Book b);

	List<Book> getAll();

	Book getById(int id);

	boolean updateBook(Book b);

	boolean deleteBook(int id);

	void closeMyConnection();
}
