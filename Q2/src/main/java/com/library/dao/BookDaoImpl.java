package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;

public class BookDaoImpl implements BookDao {
	static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public boolean saveBook(Book b) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO book(title,author,price) VALUES(?,?,?)");
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getAuthor());
			pst.setDouble(3, b.getPrice());
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList<>();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM book");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book findById(int id) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM book WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBook(Book b) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE book SET title=?, author=?, price=? WHERE id=?");
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getAuthor());
			pst.setDouble(3, b.getPrice());
			pst.setInt(4, b.getId());
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM book WHERE id=?");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void closeMyConnection() {
		DBUtil.closeMyConnection();
	}
}
