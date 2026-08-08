package com.library.dao;

import java.util.List;

import com.library.model.Book;

public interface BookDao {
	boolean saveBook(Book b);

	List<Book> findAll();

	Book findById(int id);

	boolean updateBook(Book b);

	boolean deleteBook(int id);

	void closeMyConnection();
}
