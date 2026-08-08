package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Student;

public class StudentDaoImpl implements StudentDao {
	static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public boolean saveStudent(Student s) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO student(name,email) VALUES(?,?)");
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM student");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student findById(int id) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM student WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				return new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateStudent(Student s) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE student SET name=?, email=? WHERE id=?");
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setInt(3, s.getId());
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM student WHERE id=?");
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
