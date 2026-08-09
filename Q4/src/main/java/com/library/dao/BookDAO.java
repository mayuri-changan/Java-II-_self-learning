package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;

public class BookDAO {
	public void addBook(Book book) {
		try (Connection conn = DBUtil.getMyConnection();
				PreparedStatement pst = conn.prepareStatement("INSERT INTO books(title,author) VALUES(?,?)")) {
			pst.setString(1, book.getTitle());
			pst.setString(2, book.getAuthor());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		try (Connection conn = DBUtil.getMyConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM books")) {
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
