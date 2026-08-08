package com.library.service;

import java.util.List;

import com.library.dao.BookDao;
import com.library.dao.BookDaoImpl;
import com.library.model.Book;

public class BookServiceImpl implements BookService {
	private BookDao bdao = new BookDaoImpl();

	@Override
	public boolean addBook(Book b) {
		return bdao.saveBook(b);
	}

	@Override
	public List<Book> getAll() {
		return bdao.findAll();
	}

	@Override
	public Book getById(int id) {
		return bdao.findById(id);
	}

	@Override
	public boolean updateBook(Book b) {
		return bdao.updateBook(b);
	}

	@Override
	public boolean deleteBook(int id) {
		return bdao.deleteBook(id);
	}

	@Override
	public void closeMyConnection() {
		bdao.closeMyConnection();
	}
}
